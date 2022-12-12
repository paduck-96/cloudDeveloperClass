const mymiddleware = (store) => (next) => (action) => {
  // 동작을 로깅(할 내용)

  // 다음 미들웨어 나 리듀서에게 전달
  const result = next(action);

  // 작업 내역 확인
  console.log(result);
  console.log(store.getState());

  return result;
};

export default mymiddleware;
