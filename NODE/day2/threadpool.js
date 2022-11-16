const crypto = require("crypto");

const pass = "pass";
const salt = "salt";
const start = Date.now();

crypto.pbkdf2(pass, salt, 1000000, 128, "sha512", () => {
  console.log("1:", Date.now() - start);
});

//기본적으로 crypto는 4개의 스레드풀이 배정되어
//아무리 많은 양을 처리하려고 해도 4개씩 끊어서 처리
//또, 임의 생성된 스레드 풀에 작업을 배정하기 때문에
//눈에 보이는 순서와는 달리 결과가 처리되는 순서는
//순간순간마다 다르다
