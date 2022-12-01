const express = require("express");
const { verifyToken } = require("./middlewares");

const router = express.Router();

// 토큰 확인 처리
router.get("/test", verifyToken, (req, res) => {
  res.json(req.decoded);
});

module.exports = router;
