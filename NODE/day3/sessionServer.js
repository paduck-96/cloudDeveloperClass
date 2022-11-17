//웹 서버 생성 기본 구조 정도는 암기
const express = require("express");
const session = require("express-session");

const app = express();

app.set("port", 8000);

app.use(
  session({
    secret: "kakaocloudschool", // 어렵게 연산을 수행하게 할 값
    resave: false,
    saveUninitialized: true,
  })
);
//사용자 요청 처리
//요청 처리 함수 외부에 만들면 모든 사용자 공유
app.get("/session", (req, res) => {
  if (!req.session.num) {
    req.session.num = 1;
  } else {
    req.session.num += 1;
  }
  res.send(req.session.num);
});

app.listen(app.get("port"), () => {
  console.log(`listening port to...${app.get("port")}
    http://localhost:${app.get("port")}`);
});
