const passport = require("passport");
const local = require("./localStrategy");
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
};
