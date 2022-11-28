const Sequelize = require("sequelize");
const env = process.env.NODE_ENV || "development";
const config = require("../config/config.json")[env];

const User = require("./user");
const Comment = require("./comment");

const db = {};

const sequelize = new Sequelize(
  config.databse,
  config.username,
  config.password,
  config
);

db.sequelize = sequelize;
db.User = User;
db.Comment = Comment;

User.init(sequelize);
Comment.init(sequelize);

User.associate(db); // 테이블 관계 통합 연결은 db
Comment.associate(db);

module.exports = db;
