const Sequelize = require("sequelize");
const env = process.env.NODE_ENV || "development";
const config = require(__dirname + "/../config/config.json")[env];
const db = {};
// 사용자 정의 모델 가져오기
const User = require("./User");
const Post = require("./Post");
const Hashtag = require("./Hashtag");

const sequelize = new Sequelize(
  config.database,
  config.username,
  config.password,
  config
);

db.sequelize = sequelize;
db.Sequelize = Sequelize;

db.User = User;
db.Post = Post;
db.Hashtag = Hashtag;

//db 초기화 작업
User.init(sequelize);
Post.init(sequelize);
Hashtag.init(sequelize);

//관계 설정
User.associate(db);
Post.associate(db);
Hashtag.associate(db);

module.exports = db;
