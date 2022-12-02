const express = require("express");
const { verifyToken } = require("./middlewares");
const jwt = require("jsonwebtoken");
const { Domain, Hashtag, Post, User } = require("../models");

const router = express.Router();

// 데이터 리턴 요청 처리
router.get("/posts/my", verifyToken, (req, res) => {
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
router.post("/token", async (req, res) => {
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
router.get("/test", verifyToken, (req, res) => {
  res.json(req.decoded);
});

module.exports = router;
