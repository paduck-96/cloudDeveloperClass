const passport = require("passport");
const kakaoStrategy = require("passport-kakao").Strategy;

// 유저 정보
const User = require("../models/User");

module.exports = () => {
  passport.use(
    new kakaoStrategy(
      {
        clientID: process.env.KAKAO_ID,
        callbackURL: "/auth/kakao/callback",
      },
      async (accessToken, refreshToken, profile, done) => {
        // 로그인 시 정보 출력
        console.log("kko 정보", profile);
        try {
          // 이전 카카오 로그인 정보 찾기
          // 카카오 아이디 + provider 로 검색
          const exUser = await User.findOne({
            where: { snsId: profile.id, provider: "kakao" },
          });
          // 이전 로그인 유무에 따라서
          if (exUser) {
            // passport 전달
            done(null, exUser);
          } else {
            const newUser = await User.create({
              email: profile._json.kakao_account.email,
              nick: profile.displayName,
              snsId: profile.id,
              provider: "kakao",
            });
            done(null, newUser);
          }
        } catch (err) {
          console.error(err);
          done(err);
        }
      }
    )
  );
};
