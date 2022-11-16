//html에서 요청이 오면
onmessage = (event) => {
  //전송한 데이터를 받아오고
  let num = event.data;
  //작업 수행
  let result = 0;
  for (let i = 1; i <= num; i++) {
    result += i;
  }
  //결과값 전달
  postMessage(result);
};
