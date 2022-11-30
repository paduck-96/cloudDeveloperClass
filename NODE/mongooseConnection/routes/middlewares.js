exports.isLoggedIn = (req, res, next) => {
  if (req.isAuthenticated()) {
    next();
  } else {
    res.status(403).send("로그인 필요");
  }
};

exports.isNotLoggedIn = (req, res, next) => {
  if (!req.isAuthenticated()) {
    next();
  } else {
    // 메시지 생성하는 query string(param)
    // 따로 encoding 필요
    const message = encodeURIComponent("로그인 상태");
    // 이전 req 객체 모두 삭제 후 새로운 요청 흐름
    // 새로 고침 시 결과 화면만 새로 고침
    res.redirect(`/?error=${message}`);
  }
};
