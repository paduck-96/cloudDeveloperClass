const express = require("express");
const path = require("path");

const { sequelize } = require("./models");

const app = express();
app.set("port", process.env.DB_PORT || 9000);

// sequelize 연결
sequelize
  .sync({ force: false })
  .then(() => {
    console.log("데이터 연걸 ✔");
  })
  .catch((err) => {
    console.log("데이터 연결 ❌..." + err);
  });

app.listen(app.get("port"), () => {
  console.log("http://localhost:" + app.get("port"));
});
