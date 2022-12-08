import React from "react";
import "./ToDoInsert.scss";
// react-icons 의 Material Design 의 MdAdd 아이콘
import { MdAdd } from "react-icons/md";

const ToDoInsert = () => {
  return (
    <form className="ToDoInsert">
      <input type="text" placeholder="Todo 작성" />
      <button type="submit">
        <MdAdd />
      </button>
    </form>
  );
};

export default ToDoInsert;
