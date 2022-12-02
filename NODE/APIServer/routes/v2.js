const express = require("express");
const { verifyToken, apiLimiter } = require("./middlewares");
const jwt = require("jsonwebtoken");
const { Domain, Hashtag, Post, User } = require("../models");
const cors = require("cors");
const url = require("url");

const router = express.Router();

// 무조건 CORS 허용
// router.use(cors({
//   origin: req.get("origin"),
//   credentials: true,
// }))

// Domain 등록된 경우만 전송
router.use(async (req, res, next) => {
  // 현재 요청 도메인이 DB 등록 도메인인지 찾아오기
  const domain = await Domain.findOne({
    where: { host: url.parse(req.get("origin")).host },
  });
  if (domain) {
    cors({
      origin: req.get("origin"),
      credentials: true,
    })(req, res, next);
  } else {
    next();
  }
});
// 데이터 리턴 요청 처리
router.get("/posts/my", apiLimiter, verifyToken, (req, res) => {
  Post.findAll({ where: { userId: req.decoded.id } })
    .then((posts) => {
      console.log(posts);
      res.json({ code: 200, payload: posts });
    })
    .catch((err) => {
      console.error(err);
      return res.status(500).json({ code: 500, message: "서버 에러" });
    });
});
// 토큰 확인 처리
router.post("/token", apiLimiter, async (req, res) => {
  const { clientSecret } = req.body;
  try {
    // 도메인 찾아오기
    const domain = await Domain.findOne({
      where: { clientSecret },
      include: { model: User, attribute: ["nick", "id"] },
    });
    if (!domain) {
      return res.status(401).json({
        code: 401,
        message: "미등록 도메인",
      });
    }
    const token = jwt.sign(
      {
        id: domain.User.id,
        nick: domain.User.nick,
      },
      process.env.JWT_SECRET,
      { expiresIn: "1m", issuer: "adam" }
    );

    return res.json({
      code: 200,
      message: "토큰 발급 완료",
      token,
    });
  } catch (err) {
    console.error(err);
    return res.status(500).json({
      code: 500,
      message: "서버에러",
    });
  }
});

// 테스트 시 동작
// 토큰을 확인하기 위한 처리
router.get("/test", apiLimiter, verifyToken, (req, res) => {
  res.json(req.decoded);
});

module.exports = router;
