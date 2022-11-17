const express = require("express");
const path = require("path");
const morgan = require("morgan");
const FileStreamRotator = require("file-stream-rotator");
const fs = require("fs");

const app = express();

const PORT = 8000;

//서버 준비
app.set("port", PORT);

//일단위 로그 기록
//로그 파일 저장 디렉토리 생성
//existsSync 로 디렉토리 존재 여부 불리언 반환
//없으면 mkdirSync 진행
const logDirectory = path.join(__dirname + "log");
fs.existsSync(logDirectory) || fs.mkdirSync(logDirectory);
//일단위 로그 작성 설정
const accessLogStream = FileStreamRotator.getStream({
  date_format: "YYYYMMDD",
  filename: path.join(logDirectory) + "access-%DATE%.log",
  frequency: "daily",
  verbose: true,
});
app.use(morgan("combined", { stream: accessLogStream }));

app.get("/", (req, res) => {
  console.log(req.ip); //루프백 - 자기자신
  console.log(req.query); //?키=value 형태
  res.sendFile(__dirname + "/main.html");
});

app.listen(app.get("port"), () => {
  console.log(`listening to port...${PORT}\nhttp://localhost:${PORT}`);
});
