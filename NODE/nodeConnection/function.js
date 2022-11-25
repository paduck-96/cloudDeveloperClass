// 현재 날짜 문자열 리턴
const getDate = () => {
  let date = new Date();
  let year = date.getFullYear();
  let month = date.getMonth() + 1; // 월은 +1을 해야 우리가 인지하는 날이 됌
  let day = date.getDate();

  month = month >= 10 ? month : "0" + month;
  day = day >= 10 ? day : "0" + day;

  return year + "-" + month + "-" + day;
};
const getTIme = () => {
  let date = new Date();
  let hour = date.getHours();
  let minute = date.getMinutes();
  let second = date.getSeconds();
  hour = hour >= 10 ? hour : "0" + hour;
  minute = minute >= 10 ? minute : "0" + minute;
  second = second >= 10 ? second : "0" + second;

  return getDate() + " " + hour + ":" + minute + ":" + second;
};

exports.modules = {
  getDate,
  getTIme,
};
