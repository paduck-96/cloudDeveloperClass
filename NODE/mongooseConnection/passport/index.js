const passport = require("passport");
// 로컬 로그인 구현
const local = require("./localStrategy");
// 카카오 로그인 구현
const kakao = require("./kakaoStrategy");
// 유저 모델
const User = require("../models/User");

module.exports = () => {
  // 로그인 성공 시 정보 deserializeUser 함수 전달
  passport.serializeUser((user, done) => {
    done(null, user.id);
  });

  // 넘어온 id에 해당하는 데이터 DB에서 찾아 세션 저장
  passport.deserializeUser((id, done) => {
    User.findOne({ where: { id } })
      .then((user) => done(null, user))
      .catch((err) => done(err));
  });
  local();
  kakao();
};
