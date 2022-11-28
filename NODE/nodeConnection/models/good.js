const Sequelize = require("sequelize");

module.exports = class Good extends Sequelize.Model {
  static init(sequelize) {
    return super.init(
      {
        itemid: {
          type: Sequelize.INTEGER.UNSIGNED,
          allowNull: false, // 거의 필수 조건
          // DB 에서는 null 유무는 메모리를 하나 더 추가해서 저장하기 때문
          unique: true,
        },
        itemname: {
          type: Sequelize.STRING(100),
          allowNull: true,
        },
        price: {
          type: Sequelize.INTEGER.UNSIGNED,
          allowNull: false,
        },
        description: {
          type: Sequelize.STRING(200),
          allowNull: true,
        },
      },
      {
        sequelize,
        timestamps: true,
        underscored: false,
        tableName: "goods", // 데이터베이스 테이블 이름
        modelName: "Good", // 노드 프로젝트에서 사용할 모델 이름
        // goods 안에 Good 데이터 생성되는 느낌
        paranoid: true,
        charset: "utf8",
        collate: "utf8_general_ci",
      }
    );
  }
};
