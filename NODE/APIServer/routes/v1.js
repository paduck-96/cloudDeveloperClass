const express = require("express");
const { verifyToken, jwt } = require("./middlewares");
const Domain = require("../models/domain");
const router = express.Router();

// 토큰 확인 처리
router.post("/token", async (req, res) => {
  const { clientSecret } = req.body;
  try {
    // 도메인 찾아오기
    const domain = await Domain.findOne({
      where: { clientSecret },
      include: { model: URLSearchParams, attribute: ["nick", "id"] },
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
  } catch (error) {
    console.error(error);
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
