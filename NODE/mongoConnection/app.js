const express = require("express");
const morgan = require("morgan");
const path = require("path");
const multer = require("multer");
const fs = require("fs");

const app = express();
app.set("port", process.env.PORT || 9000);
app.use(morgan("dev"));

let bodyParser = require("body-parser");
app.use(bodyParser.json()); // to support JSON-encoded bodies
app.use(
  bodyParser.urlencoded({
    // to support URL-encoded bodies
    extended: true,
  })
);

//파일 다운로드
let util = require("util");
let mime = require("mime");
try {
  fs.readdirSync("img");
} catch (error) {
  console.error("img 폴더가 없어 img 폴더를 생성합니다.");
  fs.mkdirSync("img");
}

const upload = multer({
  storage: multer.diskStorage({
    destination(req, file, done) {
      //업로드 경로
      done(null, "img/");
    },
    filename(req, file, done) {
      // 업로드 파일 명
      const ext = path.extname(file.originalname);
      done(null, path.basename(file.originalname, ext) + Date.now() + ext);
    },
  }),
  limits: { fileSize: 10 * 1024 * 1024 },
});

//템플릿 엔진(서버 데이터 html에 출력 모듈)
app.set("view engine", "html");
app.engine("html", require("ejs").renderFile);

//MongoDB 사용 모듈
let MongoClient = require("mongodb").MongoClient;
//접속 DB URL
let databaseUrl = "mongodb://127.0.0.1:27017/";

/**
 *
 */
// node db의 item 컬렉션 모든 데이터 리턴
app.get("/item/all", (req, res) => {
  MongoClient.connect(
    databaseUrl,
    { useNewUrlParser: true },
    (err, database) => {
      if (err) {
        console.log(err);
        res.json({ result: false, message: err.message });
      } else {
        let db = database.db("node");
        db.collection("item")
          .find()
          .sort({ itemid: -1 })
          .toArray((err, items) => {
            if (err) {
              console.log(err);
              res.json({ result: false, message: err.message });
            } else {
              res.json({ result: true, list: items, count: items.length });
            }
          });
      }
    }
  );
});
// 페이지 단위 데이터 가져오기
// 건너뛸 개수 와 가져올 데이터 개수 필요
app.get("/item/paging", (req, res) => {
  //클라이언트 데이터
  let pageno = Number(req.query.pageno);
  let count = Number(req.query.count);
  if (pageno == undefined) {
    pageno = 1;
  }
  if (count == undefined) {
    count = 2;
  }
  // 웹 상 클라이언트 전송 데이터는 문자열
  // 계산을 위해 숫자 변형 필요
  let start = (pageno - 1) * count;

  MongoClient.connect(
    databaseUrl,
    { useNewUrlParser: true },
    (err, database) => {
      if (err) {
        console.log(err);
        res.json({ result: false, message: err.message });
      } else {
        let db = database.db("node");
        db.collection("item")
          .find()
          .sort({ itemid: -1 })
          .skip(start)
          .limit(count)
          .toArray((err, items) => {
            if (err) {
              console.log(err);
              res.json({ result: false, message: err.message });
            } else {
              res.json({ result: true, list: items, count: items.length });
            }
          });
      }
    }
  );
});
// 상세보기
// 기본키 하나로 주로 출력, 결과는 하나의 데이터 리턴
// 그 이외에는 3-10개 정도 넉넉하게 리턴
// mongodb 행 번호 같은걸 찾아서 여유롭게 리턴 가능
// 각 DB 별로 그런게 다를 수 있음
app.get("/item/:itemid", (req, res) => {
  //클라이언트 데이터
  let itemid = req.params.itemid;

  MongoClient.connect(
    databaseUrl,
    { useNewUrlParser: true },
    (err, database) => {
      if (err) {
        console.log(err);
        res.json({ result: false, message: err.message });
      } else {
        let db = database.db("node");
        db.collection("item").findOne(
          { itemid: Number(itemid) },
          (err, item) => {
            if (err) {
              console.log(err);
              res.json({ result: false, message: err.message });
            } else {
              res.json({ result: true, item });
            }
          }
        );
      }
    }
  );
});

//데이터 삽입 구현
//itemname, description, price, pictureurl(파일) 삽입
app.post("/item", upload.single("pictureurl"), (req, res) => {
  // 파라미터
  const { itemname, description, price } = req.body;
  let pictureurl;
  if (req.file) {
    pictureurl = req.file.filename;
  } else {
    pictureurl = "default.jpg";
  }

  MongoClient.connect(
    databaseUrl,
    { useNewUrlParser: true },
    (err, database) => {
      if (err) {
        console.log(err);
        res.json({ result: false, message: err.message });
      } else {
        let db = database.db("node");
        db.collection("item")
          .find({}, { projection: { _id: 0, itemid: 1 } })
          .sort({ itemid: -1 })
          .limit(1)
          .toArray((err, result) => {
            let itemid = 1;

            if (result[0] != null) {
              itemid = result[0].itemid + 1;
            }
            db.collection("item").insertOne(
              {
                itemid,
                itemname,
                description,
                price: Number(price),
                pictureurl,
              },
              (err, result) => {
                if (err) {
                  res.json({ result: false });
                } else {
                  res.json({ result: true });
                }
              }
            );
          });
      }
    }
  );
});

///
// 에러 처리 미들웨어
app.use((err, req, res, next) => {
  console.log(err);
  res.status(500).send(err.message);
});

app.listen(app.get("port"), () => {
  console.log(`http://localhost:${app.get("port")}`);
});
