import React from "react";

const ToDoItem = ({ todo, onToggle, onRemove }) => {
  return (
    <div>
      <input type="checkbox" />
      <span>텍스트</span>
      <button>삭제</button>
    </div>
  );
};

// 여러 개의 todoitem 출력 컴포넌트
const ToDos = ({
  input,
  todos,
  onChangeInput,
  onInsert,
  onToggel,
  onRemove,
}) => {
  const onSubmit = (e) => {
    e.preventDefault();
  };

  return (
    <div>
      <form onSubmit={onSubmit}>
        <input type="text" />
        <button type="submit">등록</button>
      </form>
      <ul>
        <li>
          <ToDoItem />
        </li>
        <li>
          <ToDoItem />
        </li>
        <li>
          <ToDoItem />
        </li>
        <li>
          <ToDoItem />
        </li>
        <li>
          <ToDoItem />
        </li>
      </ul>
    </div>
  );
};
export default ToDos;
