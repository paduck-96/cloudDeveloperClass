import React, { useState, useRef } from "react";

const InputSample = () => {
  // 2개의 속성을 가지는 state
  const [inputs, setInputs] = useState({
    name: "",
    nickname: "",
  });

  // state 비구조화 할당
  const { name, nickname } = inputs;

  // react 에서 다른 컴포넌트 나 DOM 참조 변수 생성
  const nameInput = useRef();

  const onChange = (e) => {
    setInputs({
      [e.target.name]: e.target.value,
    });
  };
  const onReset = (e) => {
    setInputs({
      name: "",
      nickname: "",
    });
    // 초기화 후 이름 칸으로 커서 옮기기
    nameInput.current.focus();
  };

  return (
    <div>
      <input name="name" value={name} onChange={onChange} ref={nameInput} />
      <input name="nickname" value={nickname} onChange={onChange} />
      <button onClick={onReset}>초기화</button>
    </div>
  );
};
export default InputSample;
