import React from "react";
import { useState, useMemo } from "react";

const getAverage = (numbers) => {
  console.log("평균 계산");
  if (numbers.length === 0) return 0;
  // recude> 배열 순회하면서 연산 수행 후 하나의 값 리턴
  // 첫 번째 매개변수 : 연산 수행 함수
  //최대 매개변수 4개
  //누적값 > 배열 요소 > 배열 인덱스 > 배열 자체
  // 두 번째 매개변수 : 연산 시작시 초기값
  //생략 시 배열의 첫번째 요소로 설정
  const sum = numbers.reduce((a, b) => a + b);
  return sum / numbers.length;
};

const Average = () => {
  const [list, setList] = useState([]);
  // useMemo를 이용해 평균 계산
  //list 변화가 있을 경우에만 메서드 호출(리랜더링)
  const avg = useMemo(() => getAverage(list), [list]);
  const [number, setNumber] = useState("");

  // 하나의 값 입력 받는 함수
  const onChange = (e) => {
    setNumber(e.target.value);
  };
  // 배열 삽입 함수
  const onInsert = (e) => {
    //const nextList = list.concat(parseInt(number));
    const nextList = [...list, Number(number)];
    setList(nextList);
    setNumber("");
  };

  return (
    <div>
      <input value={number} onChange={onChange} />
      <button onClick={onInsert}>추가</button>
      <ul>
        {list.map((value, index) => (
          <li key={index}>{value}</li>
        ))}
      </ul>
      <div>
        <b>평균 : </b>
        {avg}
      </div>
    </div>
  );
};

export default Average;
