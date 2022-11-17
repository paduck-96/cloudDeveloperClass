const http = require("http");
const fs = require("fs");

//서버 생성
//포트번호는 1024번까지 예약되어 있으므로 사용 않음
//1521, 3306, 27017 은 DB 가 사용
//8080은 톰캣 같은 WebContainer 가 사용
//80을 사용하게 되면  http 포트 번호 생략 가능
//443은 https의 경우 포트 번호 생략 가능
http
  .createServer(async (req, res) => {
    //응답생성
    // res.writeHead(200, { "Content-Type": "text/html;charset=utf-8" });
    // res.write("<h1>new web server</h1>");
    // res.end("<p>http modules uses</p>");
    //파일의 내용 읽어서 데이터에 저장
    //다음 명령은 이 명령이 끝나고 수행
    try {
      const data = await fs.promises.readFile("./index.html");
      res.writeHead(200, { "Content-Type": "text/html;charset=utf-8" });
      res.end(data);
    } catch (error) {
      //400 클라이언트 오류
      //500 서버 오류
      res.writeHead(500, { "Content-Type": "text/html;charset=utf-8" });
      res.end(error.message);
    }
  })
  .listen(8000, () => {
    //netstate -ano 로 포트 찾고 종료시켜보기
    console.log("8000 server listening : " + "http://localhost:8000");
  });
