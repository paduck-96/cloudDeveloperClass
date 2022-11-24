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
  }
});
