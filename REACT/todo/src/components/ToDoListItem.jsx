import React from "react";
import "./ToDoListItem.scss";

import {
  MdCheckBoxOutlineBlank,
  MdCheckBox,
  MdRemoveCircleOutline,
} from "react-icons/md";

import cn from "classnames";

const ToDoListItem = ({ todo }) => {
  // 넘어온 데이터 중에서 text 와 checked 만 분해
  const { text, checked } = todo;
  return (
    <div className="ToDoListItem">
      <div className={cn("checkbox", { checked })}>
        {checked ? <MdCheckBox /> : <MdCheckBoxOutlineBlank />}
        <div className="text">{todo.text}</div>
      </div>
      <div className="remove">
        <MdRemoveCircleOutline />
      </div>
    </div>
  );
};

export default ToDoListItem;
