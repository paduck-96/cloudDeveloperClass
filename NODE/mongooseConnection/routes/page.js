const express = require("express");
const { isLoggedIn, isNotLoggedIn } = require("./middlewares");
const { Post, User, Hashtag } = require("../models");

const router = express.Router();

// 미들웨어
// 무조건 수행
router.use((req, res, next) => {
  // 로그인한 유저 정보 삽입
  // 로그인한 유저 정보 locals 에 저장
  res.locals.user = req.user;
  // 팔로우 기능 변수
  res.locals.followerCount = req.user ? req.user.Followers.length : 0;
  res.locals.followingCount = req.user ? req.user.Followings.length : 0;
  res.locals.followerIdList = req.user
    ? req.user.Followings.map((f) => f.id)
    : [];
  next();
});

router.get("/hashtag", async (req, res, next) => {
  const query = req.query.hashtag;
  if (!query) {
    return res.redirect("/");
  }
  try {
    const hashtag = await Hashtag.findOne({ where: { title: query } });
    let posts = [];
    if (hashtag) {
      posts = await hashtag.getPosts({ include: [{ model: User }] });
    }
    return res.render("main", {
      title: `${query} | NodeAuthentication`,
      twits: posts,
    });
  } catch (err) {
    console.error(err);
    next(err);
  }
});

router.get("/profile", isLoggedIn, (req, res) => {
  res.render("profile", {
    title: "내 정보 - NodeAuthentication",
  });
});

router.get("/join", isNotLoggedIn, (req, res) => {
  res.render("join", {
    title: "회원가입 - NodeAuthentication",
  });
});

// 게시글 출력

router.get("/", async (req, res, next) => {
  try {
    // Post의 모든 데이터 찾아오면서
    // User 의 id 와 nick 정보도 같이 가져올 수 있음
    const posts = await Post.findAll({
      include: {
        model: User,
        attributes: ["id", "nick"],
      },
      order: [["createdAt", "DESC"]],
    });
    res.render("main", { title: "NodeAuthentication", twits: posts });
  } catch (err) {
    console.error(err);
    next(err);
  }
});

module.exports = router;
