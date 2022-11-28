const express = require("express");
const path = require("path");

const { sequelize } = require("./models");

const app = express();
app.set("port", process.env.DB_PORT || 9000);

const User = require("./models/user");
const Comment = require("./models/comment");

// sequelize 연결
sequelize
  .sync({ force: false })
  .then(() => {
    console.log("데이터 연걸 ✔");
  })
  .catch((err) => {
    console.log("데이터 연결 ❌..." + err);
  });

//사용
app.get("/", async (req, res) => {
  User.create({
    name: "(☞ﾟヮﾟ)☞",
    age: 25,
  });
});

app.listen(app.get("port"), () => {
  console.log("http://localhost:" + app.get("port"));
});
