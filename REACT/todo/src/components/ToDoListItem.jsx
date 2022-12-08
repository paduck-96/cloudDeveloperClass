import React from "react";
import "./ToDoListItem.scss";

import {
  MdCheckBoxOutlineBlank,
  MdCheckBox,
  MdRemoveCircleOutline,
} from "react-icons/md";

import { useCallback } from "react";

import cn from "classnames";

const ToDoListItem = ({ todo, onRemove, onToggle }) => {
  // 넘어온 데이터 중에서 text 와 checked 만 분해
  const { id, text, checked } = todo;

  // 데이터 삭제 함수
  const onDelete = useCallback(
    (e) => {
      const result = window.confirm(text + "를 삭제?");
      if (result) {
        onRemove(id);
      }
    },
    [onRemove, id, text]
  );
  return (
    <div className="ToDoListItem">
      <div
        className={cn("checkbox", { checked })}
        onClick={(e) => onToggle(id)}
      >
        {checked ? <MdCheckBox /> : <MdCheckBoxOutlineBlank />}
        <div className="text">{text}</div>
      </div>
      <div className="remove" onClick={onDelete}>
        <MdRemoveCircleOutline />
      </div>
    </div>
  );
};

export default React.memo(ToDoListItem);
