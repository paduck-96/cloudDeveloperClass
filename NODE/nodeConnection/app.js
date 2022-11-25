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

// 테이블 전체 개수 가져오기

// 에러 핸들링
app.use((err, req, res, next) => {
  res.status(500).send(err.message);
});

app.listen(app.get("port"), () => {
  console.log(`Listening to PORT...${app.get("port")}
  explorer.exe http://localhost:${app.get("port")}`);
});
