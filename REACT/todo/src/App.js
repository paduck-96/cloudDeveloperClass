import ToDoTemplate from "./components/ToDoTemplate";
import "./App.css";
import ToDoInsert from "./components/ToDoInsert";
import ToDoList from "./components/ToDoList";
// useRef 는 변수 생성 OR 변수 만들어 DOM에 할당할 때
// useCallback 은 함수를 효율적으로 생성
import { useState, useRef, useCallback } from "react";

function App() {
  const [todos, setToDos] = useState([
    {
      id: 1,
      text: "HTML, CSS, JavaScript",
      checked: true,
    },
    {
      id: 2,
      text: "Node",
      checked: false,
    },
    {
      id: 3,
      text: "React",
      checked: false,
    },
  ]);

  //아이디 변수 생성
  const nextId = useRef(4);
  // 삽입 처리 함수
  // todos 에 변화 생길 경우에만 함수 재생성
  const onInsert = useCallback(
    (text) => {
      const todo = {
        id: nextId.current,
        text,
        checked: false,
      };
      setToDos(todos.concat(todo));
      nextId.current += 1;
    },
    [todos]
  );

  return (
    <div className="App">
      <ToDoTemplate>
        <ToDoInsert onInsert={onInsert} />
        <ToDoList todos={todos} />
      </ToDoTemplate>
    </div>
  );
}

export default App;
