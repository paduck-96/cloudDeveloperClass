//다른 프로세스를 실행할 수 있는 모듈 가져오기
//행해지길 원하는 기능을 작성해야 함
const exec = require("child_process").exec;
const os = require("os");
//알고리즘적 사고가 필요
//운영체제마다 같은 기능을 실행하는 명령어는 다르기 때문
let position = os.type().toLowerCase().indexOf("win");
if (position < 0) {
  let process = exec("ls");
  //프로세스 정상 수행
  process.stdout.on("data", function (data) {
    console.log(data.toString());
  });
  process.stderr.on("data", function (data) {
    console.log(data.toString());
  });
} else {
  //프로세스 준비
  //window 에서는 dir이 디렉토리 목록 확인
  //나머지 운영체제는 ls
  let process = exec("dir");
  //프로세스 정상 수행
  process.stdout.on("data", function (data) {
    console.log(data.toString());
  });
  process.stderr.on("data", function (data) {
    console.log(data.toString());
  });
}
