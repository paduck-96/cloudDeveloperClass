const express = require("express");
const User = require("../models/User");
const { isLoggedIn } = require("./middlewares");

const router = express.Router();

router.post("/:id/follow", isLoggedIn, async (req, res, next) => {
  try {
    const user = await User.findOne({ where: { id: req.user.id } });
    if (user) {
      // 팔로우로 추가
      await user.addFollwing(parseInt(req.params.id, 10));
    } else {
      res.status(404).send("no user");
    }
  } catch (err) {
    console.error(err);
    next(err);
  }
});

module.exports = router;
