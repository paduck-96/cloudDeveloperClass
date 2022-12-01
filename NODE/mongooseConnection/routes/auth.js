const express = require("express");
const passport = require("passport");
const bcrypt = require("bcrypt");
const { isLoggedIn, isNotLoggedIn } = require("./middlewares");
const User = require("../models/User");

const router = express.Router();

router.post("/join", isNotLoggedIn, async (req, res, next) => {
  // 데이터 가져오기
  const { email, nick, password } = req.body;
  try {
    // 이메일 존재 여부 확인
    const exUser = await User.findOne({ where: { email } });
    if (exUser) {
      // 회원 가입 페이지로 전달
      // error 키에 메시지 가지고 이동
      return res.redirect("/join?error=exist");
    } else {
      //회원가입 진행
      //비밀번호 해싱
      const hash = await bcrypt.hash(password, 12);
      await User.create({
        email,
        nick,
        password: hash,
      });
      return res.redirect("/");
    }
  } catch (err) {
    console.log(err);
    return next(err);
  }
});

// 로그인 처리
router.post("/login", isNotLoggedIn, (req, res, next) => {
  // passport 모듈로 로그인
  passport.authenticate("local", (authError, user, info) => {
    if (authError) {
      console.error(authError);
      return next(authError);
    }
    // 일치하는 유저 없을 경우
    if (!user) {
      return res.redirect(`/?loginError=${info.message}`);
    }
    return req.login(user, (loginError) => {
      if (loginError) {
        console.error(loginError);
        return next(loginError);
      }
      return res.redirect("/");
    });
  })(req, res, next);
});

//로그아웃 처리
router.get("/logout", isLoggedIn, (req, res, next) => {
  req.logout((err) => {
    if (err) {
      return next(err);
    }
    //세션 초기화
    req.session.destroy();
    res.redirect("/");
  });
});

// 카카오 로그인 처리
router.get("/kakao", passport.authenticate("kakao"));
// 카카오 로그인 성공 유무
router.get(
  "/kakao/callback",
  passport.authenticate("kakao", {
    failureRedirect: "/",
  }),
  (req, res) => {
    res.redirect("/");
  }
);
module.exports = router;
