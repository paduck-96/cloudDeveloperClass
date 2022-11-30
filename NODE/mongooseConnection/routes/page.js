const express = require("express");

const router = express.Router();

// 미들웨어
// 무조건 수행
router.use((req, res, next) => {
  // 로그인한 유저 정보 삽입
  res.locals.user = null;
  // 팔로우 기능 변수
  res.locals.followerCount = 0;
  res.locals.followingCount = 0;
  res.locals.followerIdList = [];
  next();
});

router.get("/profile", (req, res) => {
  res.render("profile", {
    title: "내 정보 - NodeAuthentication",
  });
});

router.get("/join", (req, res) => {
  res.render("join", {
    title: "회원가입 - NodeAuthentication",
  });
});

router.get("/", (req, res, next) => {
  const twits = [];
  res.render("main", {
    title: "NodeAuthentication",
    twits,
  });
});

module.exports = router;
