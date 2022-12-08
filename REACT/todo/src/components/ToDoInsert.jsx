import React from "react";
import "./ToDoInsert.scss";
// react-icons 의 Material Design 의 MdAdd 아이콘
import { MdAdd } from "react-icons/md";
import { useState, useCallback } from "react";

const ToDoInsert = ({ onInsert }) => {
  // 입력된 데이터 state
  const [value, setValue] = useState("");

  // 입력 내용 변경 시 호출 함수
  //입력 시 todo 재생성 불필요
  //삽입시 처리
  const onChange = useCallback((e) => {
    setValue(e.target.value);
  }, []);

  // form>submit 이벤트 발생 시 호출
  //form>submit 시 submit 이벤트와 엔터 이벤트 동시 발생
  //어떤 action을 받느냐에 따라 submit 혹은 button으로 할 지 결정
  const onSubmit = useCallback(
    (e) => {
      const result = window.confirm(`${value} 추가?`);
      if (result === false) {
        e.preventDefault();
        return;
      }
      onInsert(value);
      setValue("");
      e.preventDefault();
    },
    [onInsert, value]
  );
  return (
    <form className="ToDoInsert" onSubmit={onSubmit}>
      <input
        type="text"
        placeholder="Todo 작성"
        value={value}
        onChange={onChange}
      />
      <button type="submit">
        <MdAdd />
      </button>
    </form>
  );
};

export default ToDoInsert;
