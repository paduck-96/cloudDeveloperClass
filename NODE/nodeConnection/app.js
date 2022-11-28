const express = require("express");
const morgan = require("morgan");
const compression = require("compression");
const path = require("path");
const mysql = require("mysql");
const cookieParser = require("cookie-parser");
const session = require("express-session");
const multer = require("multer");
const dotenv = require("dotenv");

//.env 사용
dotenv.config();

// 서버 설정
const app = express();
app.set("port", process.env.PORT || 9000);

// 로그 기록
const fileStreamRotator = require("file-stream-rotator");
const fs = require("fs");
let logDirectory = path.join(__dirname, "/log");
// 폴더 없으면 생성
fs.existsSync(logDirectory) || fs.mkdirSync(logDirectory);
// 로그 파일 옵션
let accessLogStream = fileStreamRotator.getStream({
  date_format: "YYYYMMDD",
  filename: path.join(logDirectory, "access-%DATE%.log"),
  frequency: "daily",
  verbose: false,
});
// 로그 기록 설정
app.use(morgan("combined", { stream: accessLogStream }));

// 서버 압축해서 클라이언트로 전송
app.use(compression());

// post 파라미터 읽기
const bodyParser = require("body-parser");
app.use(bodyParser.json());
app.use(
  bodyParser.urlencoded({
    //post 요청에 대해 application server 가  인코딩
    extended: true,
  })
);

// 데이터베이스 접속 정보
let options = {
  host: process.env.DB_HOST,
  port: process.env.DB_PORT,
  user: process.env.DB_USERNAME,
  password: process.env.DB_PASSWORD,
  database: process.env.DB_NAME,
};

//세션 저장 MySQL 데이터베이스 생성
const mariaDBStore = require("express-mysql-session")(session);
//세션설정
app.use(
  session({
    secret: process.env.COOKIE_SECRET,
    resave: false,
    saveUninitialized: true,
    store: new mariaDBStore(options),
  })
);

//파일 업로드 설정
const upload = multer({
  storage: multer.diskStorage({
    destination(req, file, done) {
      done(null, "public/img");
    },
    filename(req, file, done) {
      const ext = path.extname(file.originalname);
      done(null, path.basename(file.originalname, ext) + Date.now() + ext);
    },
  }),
  limits: { fileSize: 10 * 1024 * 1024 },
});

// 정적 파일 경로 설정
app.use("/", express.static("public"));

// 파일 다운로드 모듈
let util = require("util");
let mime = require("mime");
const e = require("express");

// 데이터베이스 연결
let connection = mysql.createConnection(options);
connection.connect((err) => {
  if (err) {
    console.error(err);
  } else {
    //
  }
});

///
/**
 * sequelize 를 이용한 DB 연결
 * require 를 할 때 디렉토리 이름 기재
 * 디렉토리 안의 index.js 의 내용 import
 */
const { Good } = require("./models");
const { sequelize } = require("./models/index");
sequelize
  .sync({ force: false })
  .then(() => {
    console.log("DB 연결 성공");
  })
  .catch((err) => {
    console.log("DB 연결 실패");
  });

///
// 실행
app.get("/", (req, res) => {
  res.sendFile(path.join(__dirname, "index.html"));
});

// 데이터 전체 가져오기
app.get("/item/all", (req, res) => {
  //json 문자열 형태로 데이터를 제공받아
  //front end에서 데이터를 수신해서 출력
  connection.query(
    "select * from goods order by itemid desc",
    //전체 출력에는 정렬 필수
    //두 번째 파라미터는 ? 값,
    (err, results, fields) => {
      if (err) {
        //에러 발생했다고 데이터 전송하지 않으면 안됨
        res.json({ result: false });
      } else {
        res.json({ result: true, list: results });
      }
    }
  );
});
// 일부 데이터 가져오기
// 페이지 시작하는 데이터 번호 + 한 페이지 출력 데이터 개수
// 시작 데이터 번호 주는 경우는 데이터 갯수 고정 확률 높음
// URl:/item/list 파라미터는 pageno 1개
app.get("/item/list", (req, res) => {
  //파라미터 읽기
  let pageno = req.query.pageno;
  if (pageno == undefined) {
    pageno = 1;
  }
  /**
   * item 테이블에서 itemid를 내림차순 후 페이지 단위
   * select * from item order by itemid desc limit 시작번호, 5
   * (페이지 번호-1)*데이터개수
   */
  let result = true; // 성공, 실패 여부 확인
  let list; // 데이터 저장
  // 데이터 목록 가져오기
  connection.query(
    "select * from goods order by itemid desc limit ?, 5",
    [(parseInt(pageno) - 1) * 5], //파라미터는 무조건 문자열로 숫자 변환
    (err, results, fields) => {
      if (err) {
        console.log(err);
        result = false;
      } else {
        list = results;
      } // 비동기 과정으로 처리
      // 명시적으로 순서 구현해줘야 함
      // 테이블 전체 개수 가져오기
      let cnt = 0;
      connection.query(
        "select count(*) cnt from goods",
        (err, results, fields) => {
          if (err) {
            console.log(err);
            result = false;
          } else {
            // 하나의 행만 리턴되므로 0번째 데이터 읽기
            cnt = results[0].cnt;
          }
          // 응답 전송
          if (result === false) {
            res.json({ result: false });
          } else {
            res.json({ result: true, list: list, count: cnt });
          }
        }
      );
    }
  );
});

app.get("/item/detail/:itemid", (req, res) => {
  // 상세값은 하나만 볼 수 있으니 params
  let itemid = req.params.itemid;
  connection.query(
    "select * from goods where itemid = ?",
    [itemid],
    (err, results, field) => {
      if (err) {
        console.log(err);
        res.json({ result: false });
      } else {
        res.json({ result: true, item: results[0] });
      }
    }
  );
});

/**
 * 이미지 다운로드 처리
 */
app.get("/img/:pictureurl", (req, res) => {
  let pictureurl = req.params.pictureurl;
  // 이미지 파일에 대한 절대 경로 추가
  let file =
    "C:\\Users\\user\\kakaocloudschool\\NODE\\nodeConnection\\public\\img" +
    "/" +
    pictureurl;
  // 파일 이름 가지고 타입 생성
  let mimetype = mime.lookup(pictureurl);
  res.setHeader("Content-disposition", "attachment; filename=" + pictureurl);
  res.setHeader("Content-type", mimetype);
  // 파일의 내용을 읽어서 res에 전송
  let fileStream = fs.createReadStream(file);
  fileStream.pipe(res);
});

/**
 * 데이터 삽입
 * 외부 파일에서 import
 */
//const { getDate, getTime } = require("./function");
// 현재 날짜 문자열 리턴
const getDate = () => {
  let date = new Date();
  let year = date.getFullYear();
  let month = date.getMonth() + 1; // 월은 +1을 해야 우리가 인지하는 날이 됌
  let day = date.getDate();

  month = month >= 10 ? month : "0" + month;
  day = day >= 10 ? day : "0" + day;

  return year + "-" + month + "-" + day;
};
const getTime = () => {
  let date = new Date();
  let hour = date.getHours();
  let minute = date.getMinutes();
  let second = date.getSeconds();
  hour = hour >= 10 ? hour : "0" + hour;
  minute = minute >= 10 ? minute : "0" + minute;
  second = second >= 10 ? second : "0" + second;

  return getDate() + " " + hour + ":" + minute + ":" + second;
};

//Sequalize를 통한 삽입 과정 구현
app.post("/item/insert", upload.single("pictureurl"), async (req, res) => {
  //파라미터 읽어오기
  const itemname = req.body.itemname;
  const description = req.body.description;
  const price = req.body.price;

  //파일 이름
  let pictureurl;
  if (req.file) {
    pictureurl = req.file.filename;
  } else {
    pictureurl = "default.jpg";
  }
  // 가장 큰 itemid를 이용해서 itemid 생성
  let itemid = 1;
  try {
    let x = await Good.max("itemid");
    itemid = x + 1;
  } catch (err) {
    console.log(err);
  }
  //데이터 삽입
  Good.create({
    itemid,
    itemname,
    price,
    description,
    pictureurl,
    updatedate: getDate(),
  });

  //현재 날짜 및 시간 저장
  const writeStream = fs.createWriteStream("./update.txt");
  writeStream.write(getTime());
  writeStream.end();

  res.json({ result: true });

  // 가장 큰 itemid 찾기
  // connection.query(
  //   "select max(itemid) maxid from goods",
  //   (err, results, field) => {
  //     let itemid;
  //     //최대값이 있으면 +1, 없으면 1로 설정
  //     if (results.length > 0) {
  //       itemid = results[0].maxid + 1;
  //     } else {
  //       itemid = 1;
  //     }

  //     connection.query(
  //       "insert into goods(itemid, itemname, price, description, pictureurl, updatedate) values(?, ?, ?, ?, ?, ?)",
  //       [itemid, itemname, price, description, pictureurl, getDate()],
  //       (err, results, field) => {
  //         if (err) {
  //           console.log(err);
  //           res.json({ result: false });
  //         } else {
  //           //현재 날짜 및 시간 저장
  //           const writeStream = fs.createWriteStream("./update.txt");
  //           writeStream.write(getTime());
  //           writeStream.end();

  //           res.json({ result: true });
  //         }
  //       }
  //     );
  //   }
  // );
});

//데이터 삭제
app.post("/item/delete", (req, res) => {
  let itemid = req.body.itemid;
  connection.query(
    "delete from goods where itemid=?",
    [itemid],
    (err, results, fields) => {
      if (err) {
        console.log(err);
        res.json({ result: false });
      } else {
        //현재 날짜 및 시간 저장
        const writeStream = fs.createWriteStream("./update.txt");
        writeStream.write(getTime());
        writeStream.end();

        res.json({ result: true });
      }
    }
  );
});

//수정 get 요청
app.get("/item/update", (req, res) => {
  //public의 update.html 읽어옴
  fs.readFile("public/update.html", (err, data) => {
    res.end(data);
  });
});
// 수정 post 데이터
app.post("/item/update", upload.single("pictureurl"), (req, res) => {
  const { itemid, itemname, price, description, oldpictureurl } = req.body;
  let pictureurl; // 수정할 파일 이름
  if (req.file) {
    // 새로 선택한 파일 유무에 따라 다름
    pictureurl = req.file.filename;
  } else {
    pictureurl = oldpictureurl;
  }

  // 이후 db 정리
  connection.query(
    "update goods set itemname=?, price=?, description=?, pictureurl=?, updatedate=? where itemid=?",
    [itemname, price, description, pictureurl, getDate(), itemid],
    (err, results, field) => {
      if (err) {
        console.log(err);
        res.send({ result: false });
      } else {
        const writeStream = fs.createWriteStream("./update.txt");
        writeStream.write(getTime());
        writeStream.end();
        res.json({ result: true, results });
      }
    }
  );
});

app.get("/item/updatedate", (req, res) => {
  fs.readFile("./update.txt", (err, data) => {
    res.json({ result: data.toString() });
  });
});
// 에러 핸들링
app.use((err, req, res, next) => {
  res.status(500).send(err.message);
});

app.listen(app.get("port"), () => {
  console.log(`Listening to PORT...${app.get("port")}
  explorer.exe http://localhost:${app.get("port")}`);
});
