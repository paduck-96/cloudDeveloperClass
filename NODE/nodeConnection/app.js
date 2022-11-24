const mariadb = require("mysql");
const dotenv = require("dotenv");

dotenv.config();

//db 정보 전달
let connection = mariadb.createConnection({
  host: "127.0.0.1",
  port: 3306,
  user: "root",
  password: process.env.DB_PASSWORD,
  database: "nodeConnection",
});

//연결 확인
connection.connect((err) => {
  if (err) {
    throw new Error("DB Connection ❌ :" + err);
  } else {
    console.log("DB Connection ✔");
    // sql구문 문자열로 전달
    // connection.query(
    //   "create table family(id int auto_increment primary key, name varchar(20))"
    // );
    // connection.query("insert into family(name) values(?)", "박문석");
    // connection.query("insert into family(name) values(?)", "예시");
    // select
    connection.query("select * from family", (err, results, fields) => {
      if (err) {
        throw new Error("{result:false, message: }", err.code);
      } else {
        let result = JSON.stringify(results);
        console.log(result);
      }
    });
  }
});
