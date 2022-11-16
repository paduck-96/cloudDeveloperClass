const path = require("path");
const fs = require("fs");

let today = new Date();
console.log(today);
console.log(today.getFullYear());
console.log(today.getMonth() + 1); //0부터 시작하는, 1부터 시작하는 언어가 있음
console.log(today.getDate());

//오늘 날짜로된 디렉토리 없으면 생성
const now = new Date();
const result =
  now.getFullYear().toString() +
  (now.getMonth() + 1).toString() +
  now.getDate().toString();
fs.access(__dirname + `/${result}`, (err) => {
  if (err) {
    fs.mkdir(__dirname + `/${result}`, (err) => {
      if (err) {
        console.log(err.message);
      } else {
        console.log("done");
      }
    });
  } else {
    console.log(err);
  }
});
