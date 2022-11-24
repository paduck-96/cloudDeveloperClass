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

// 데이터베이스 연결
let connection = mysql.createConnection(options);
connection.connect((err) => {
  if (err) {
    console.error(err);
  } else {
    //
  }
});

// 에러 핸들링
app.use((err, req, res, next) => {
  res.status(500).send(err.message);
});

app.listen(app.get("port"), () => {
  console.log(`Listening to PORT...${app.get("port")}
  explorer.exe http://localhost:${app.get("port")}`);
});
