const express = require("express");
const path = require("path");
const session = require("express-session");
const FileStore = require("session-file-store")(session);
const morgan = require("morgan");
const dotenv = require("dotenv"); //.env 파일의 내용을 읽어서 process.env에 저장
const cookieParser = require("cookie-parser");
const fs = require("fs");
const multer = require("multer");

const app = express();

dotenv.config(); //.env 파일 읽어서 process.env.이름오로 처리

app.set("port", process.env.PORT);

//res.render로 출력할 때 사용할 디렉토리 설정
app.set("views", path.join(__dirname, "views"));
//템플릿 엔진 설치
app.set("view engine", "pug");

//로그
app.use(morgan("dev"));

//템플릿 엔진으로 출력
app.use("/", (req, res) => {
  //views/index.html로 출력
  res.render("index", { title: "Pug", job: ["dev", "bedev"] });
});

//post 방식의 파라미터를 읽을 수 있도록 설정
app.use(express.json());
app.use(
  express.urlencoded({
    extended: false,
  })
);
//쿠키 사용이 가능하도록 설정
app.use(cookieParser(process.env.COOKIE_SECRET));
app.use(
  session({
    secret: process.env.SESSION_SECRET,
    resave: false,
    saveUninitialized: true,
    store: new FileStore(), //세션 file로 넘겨주기
  })
);

//파일 업로드하기 위한 디렉토리 생성
try {
  //디렉토리 확인하는데 없으면 catch 발생
  fs.readdirSync("uploads");
} catch (error) {
  //없으니 새로 생성
  fs.mkdirSync("uploads");
}
//파일 업로드 설정
const upload = multer({
  storage: multer.diskStorage({
    destination(req, file, done) {
      done(null, "uploads/");
    },
    filename(req, file, done) {
      file.originalname = Buffer.from(file.originalname, "latin1").toString(
        "utf8"
      );
      const ext = path.extname(file.originalname);
      done(null, path.basename(file.originalname, ext) + Date.now() + ext);
    },
  }),
  limits: { fileSize: 1024 * 1024 * 10 }, // 자리 하나당 단위 하나
});

//요청처리 메서드 - get, post, put(patch), delete, options
// 응답
// send(직접 출력 작성) , sendFile(html 절대 경로)
// json(json 데이터) => 서버 렌더링 X
// app.get("/", (req, res) => {
//   // 루트 경로 - ContextPath
//   res.sendFile(path.join(__dirname + "/index.html"));
// });

//router 파일 가져오기
const indexRouter = require("./index");
const userRouter = require("./user");
const boardRouter = require("./board");
//url 과 매핑
app.use("/", indexRouter);
app.use("/user", userRouter);
app.use("/board", boardRouter);

//하나의 파일 업로드 처리
app.get("/single", (req, res) => {
  //
  res.sendFile(path.join(__dirname + "/single.html"));
});
app.post("/single", upload.single("image"), (req, res) => {
  //upload.single() > 매개변수가 필드네임(name 속성)
  console.log(req.body.title);
  console.log(req.file.originalname);
  res.send("성공");
});
//여러개의 파일 업로드 처리
app.get("/multi", (req, res) => {
  //
  res.sendFile(path.join(__dirname + "/multi.html"));
});
app.post("/multi", upload.array("image"), (req, res) => {
  //res.send("성공");
  //실제 node에서 json 전송
  let result = { result: "success" };
  res.json(result);
});

app.listen(app.get("port"), () => {
  console.log(`listening to port...${process.env.PORT}
    http://localhost:${app.get("port")}`);
});
