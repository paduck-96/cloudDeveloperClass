const { odd, even } = require("./var");
//하나를 내보냈을 때는 이름 바꿔서 받아오기 가능
//func 의 내용을 가져와서 checkNumber 라는 이름을 붙이는 것
const checkNumber = require("./func");

console.log(checkNumber(5));

const path = require("path");
console.log(__dirname);
console.log(path.join(__dirname, "public"));

const url = require("url");

const addr = "https://www.naver.com/login?id=asdasd";
//url 분해
const p = url.parse(addr);
console.log(p);
//path는 서버 url 제외한 경로
//query 는 query string

//searchparams 속성을 호출하면 파라미터 부분에 해당하는 객체 리턴
const address = new URL(url.format(p));
console.log(address.searchParams);
console.log(address.searchParams.get("id"));
