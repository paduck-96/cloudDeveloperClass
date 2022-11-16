//파일 읽고 쓰는 모듈
const fs = require("fs");
const { buffer } = require("stream/consumers");

let data = fs.readFileSync(__dirname + "/test.txt"); //동기적으로 읽기
console.log(data.toString());

let ar = data.toString().split("\n");
console.log(ar);

//error는 에러, data가 buffer
//콜백 대신에 프로미스 사용도 가능
fs.readFile(__dirname + "/test.txt", (error, data) => {
  if (error) {
    console.log(error.message);
  } else {
    console.log(data.toString());
  }
});
console.log("end");

fs.promises
  .readFile(__dirname + "/test.txt")
  .then((data) => {
    console.log(data.toString());
  })
  .catch((error) => console.log(error.message));

///
///
///

//스트림을 이용한 읽기
//읽기 전용 스트림
const readStream = fs.createReadStream(__dirname + "/test.txt", {
  highWaterMark: 16,
});
//스트림은 데이터 저장 객체 생성 필요
const data3 = [];

//읽는 동안 발생하는 이벤트
readStream.on("data", (chunk) => {
  data3.push(chunk);
});
//읽기 끝나면 발생하는 이벤트
readStream.on("end", () => {
  let result = Buffer.concat(data3);
  console.log(result.toString());
});
//에러 이벤트
readStream.on("error", (error) => {
  console.log(error.message);
});

///
///
///

//용량이 큰 파일 만들기
// const file = fs.createWriteStream(__dirname + "/data.txt");
// for (let i = 0; i < 10000000; i++) {
//   file.write("용량이 큰 파일 만들기\n");
// }
// file.end();

//스트림 없이 읽어서 쓰기
console.log("복사 전" + process.memoryUsage().rss);

const data4 = fs.readFileSync(__dirname + "/data.txt");
fs.writeFileSync(__dirname + "/nostreamdata.txt", data4);

console.log("복사 후" + process.memoryUsage().rss);

//스트림으로 읽어서 쓰기
console.log("복사 전" + process.memoryUsage().rss);

const readStream2 = fs.createReadStream(__dirname + "/data.txt");
const writeStream2 = fs.createWriteStream(__dirname + "/streamdata.txt");
readStream2.pipe(writeStream2);
readStream2.on("end", () => {
  console.log("복사 후" + process.memoryUsage().rss);
});
//쉽게 말해 스트림 없으면 용량보다 좀 크게
//스트림 있으면 자릿수 하나가 차이 날 정도로 감소
