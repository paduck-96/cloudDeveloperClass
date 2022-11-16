const crypto = require("crypto");

let password = "123456";

//단방향 암호호 수행
//원문과는 상관없이 알고리즘을 통해 문자열 길이 지정
let p1 = crypto.createHash("sha256").update(password).digest("base64");
let p2 = crypto.createHash("sha256").update("123").digest("base64");
let p3 = crypto.createHash("sha256").update("123456").digest("base64");
console.log(p1);
console.log(p2);
console.log(p1 === p2);
console.log(p1 === p3);

//양방향 수행
const algorithm = "aes-256-cbc"; //정해진 것
//node crypto 모듈에서는
const key = "12345678912345678912345678900000"; //32자리, 정해지지 않음
const iv = "1234567891234560"; //16자리, 정해지지 않음

//암호화 객체 생성
const cipher = crypto.createCipheriv(algorithm, key, iv);
let result = cipher.update("01012341234", "utf8", "base64");
result += cipher.final("base64");
console.log(result);

//복호화 객체 생성
let decipher = crypto.createDecipheriv(algorithm, key, iv);
let result2 = decipher.update(result, "base64", "utf8");
result2 += decipher.final("utf8");
console.log(result2);
