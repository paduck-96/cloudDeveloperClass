const Sequelize = require("sequelize");
module.exports = class Post extends Sequelize.Model {
  static init(sequelize) {
    return super.init(
      {
        //컬럼에 대한 설정
        content: {
          type: Sequelize.STRING(200),
          allowNull: false,
        },
        img: {
          type: Sequelize.STRING(200),
          allowNull: true,
        },
      },
      {
        //테이블에 대한 설정
        sequelize,
        timestamps: true,
        underscored: false,
        modelName: "Post",
        tableName: "posts",
        paranoid: false,
        charset: "utf8mb4",
        collate: "utf8mb4_general_ci",
      }
    );
  }
  static associate(db) {
    db.Post.belongsTo(db.User);
    // 다 대 다 관계에서는 테이블이 하나 생성
    // through 가 테이블 이름이 됌
    db.Post.belongsToMany(db.Hashtag, { through: "PostHashtag" });
  }
};
