const Sequelize = require("sequelize");

module.exports = class User extends Sequelize.Model {
  static init(sequelize) {
    //테이블 설정
    return super.init(
      {
        //컬럼 설정
        name: {
          type: Sequelize.STRING(20),
          allowNull: false,
          unique: true,
        },
        age: {
          type: Sequelize.INTEGER,
          allowNull: false,
        },
      },
      {
        //테이블 설정
        sequelize,
        timestamps: true,
        modelName: "User",
        tableName: "users",
        paranoid: false,
        charset: "utf8",
        collate: "utf8_general_ci",
      }
    );
  }

  static associate(db) {
    //외래키 설정
    db.User.hasMany(
      db.Comment, // 모델의 이름
      { foreignKey: "commenter", sourceKey: "id" }
    );
  }
};
