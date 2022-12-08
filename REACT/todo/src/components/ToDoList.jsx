import React from "react";
import ToDoListItem from "./ToDoListItem";

const ToDoList = ({ todos, onRemove, onToggle }) => {
  return (
    <div className="ToDoList">
      {todos.map((todo) => (
        <ToDoListItem
          todo={todo}
          key={todo.id}
          onRemove={onRemove}
          onToggle={onToggle}
        />
      ))}
    </div>
  );
};

export default ToDoList;
