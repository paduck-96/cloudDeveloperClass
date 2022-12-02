const express = require("express");
const axios = require("axios");

const router = express.Router();
// http~v1 까지는 모든 요청마다 동일한 URL
// 상수 설정
const URL = "http://localhost:9000/v1";
// ajax 요청 시 누가 했는지 확인하기 위해
// origin header 추가
axios.defaults.headers.origin = "http://localhost:4000";

// 토큰 발급 코드 수행
// 테스트 시 진행되었던 과정을 하나의 함수로
const request = async (req, api) => {
  try {
    if (!req.session.jwt) {
      // 세션에 토큰이 없으면 토큰 발급 시도
      const tokenResult = await axios.post(`${URL}/token`, {
        clientSecret: process.env.CLIENT_SECRET,
      });

      req.session.jwt = tokenResult.data.token; // 세션에 토큰 저장
    }
    // API 요청
    return await axios.get(`${URL}/${api}`, {
      headers: { authorization: req.session.jwt },
    });
  } catch (err) {
    /**
     * 유효기간만 만료된 상태이기 때문에
     * 토큰 발급을 해줘야 되는 사용자로 에러 차리 2개
     */
    // 토큰 유효기간 만료시 에러
    if (err.response.status === 419) {
      // 기존 토큰 삭제
      delete req.session.jwt;
      // 다시 토큰 생성해달라고 요청
      return request(req, api);
    }
    return err.response;
  }
};

// 실제 요청 작업
// 주소만 변경하면 서버에 지속적으로 토큰과 같이 요청 전달 가능
router.get("/mypost", async (req, res, next) => {
  try {
    const result = await request(req, "/posts/my");
    res.json(result.data);
  } catch (err) {
    console.error(err);
    next(err);
  }
});
router.get("/test", async (req, res, next) => {
  // 토큰 테스트 라우터
});

module.exports = router;
