import React from "react";

const Iteration = () => {
  const names = ["Javascript", "Java", "Python", "C#", "Go", "Rust"];
  const namesList = names.map((name, index) => <li key={index}>{name}</li>);
  return (
    <div>
      <ul>{namesList}</ul>
    </div>
  );
};

export default Iteration;
