import React from "react";
import ToDoListItem from "./ToDoListItem";

const ToDoList = ({ todos }) => {
  return (
    <div className="ToDoList">
      {todos.map((todo) => (
        <ToDoListItem todo={todo} key={todo.id} />
      ))}
    </div>
  );
};

export default ToDoList;
