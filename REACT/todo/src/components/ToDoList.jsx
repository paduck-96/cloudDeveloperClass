import React from "react";
import ToDoListItem from "./ToDoListItem";

const ToDoList = ({ todos, onRemove }) => {
  return (
    <div className="ToDoList">
      {todos.map((todo) => (
        <ToDoListItem todo={todo} key={todo.id} onRemove={onRemove} />
      ))}
    </div>
  );
};

export default ToDoList;
