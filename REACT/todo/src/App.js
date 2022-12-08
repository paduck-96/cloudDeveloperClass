import ToDoTemplate from "./components/ToDoTemplate";
import "./App.css";
import ToDoInsert from "./components/ToDoInsert";
import ToDoList from "./components/ToDoList";
// useRef 는 변수 생성 OR 변수 만들어 DOM에 할당할 때
// useCallback 은 함수를 효율적으로 생성
import { useState, useRef, useCallback } from "react";

// 대용량 데이터 생성
const createBulkTodos = () => {
  const array = [];
  for (let i = 0; i <= 2000; i++) {
    array.push({
      id: i,
      text: `할 일 ${i}`,
      checked: false,
    });
  }
  return array;
};

function App() {
  // 함수 이름을 대입해야 함수를 전부 수행하고 1번만 리랜더링
  // 호출 구문 대입 시 데이터 만들어질 때마다 리랜더링
  const [todos, setToDos] = useState(createBulkTodos);

  //아이디 변수 생성
  const nextId = useRef(2001);
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

  // 데이터 삭제
  const onRemove = useCallback(
    (id) => {
      setToDos(todos.filter((todo) => todo.id !== id));
    },
    [todos]
  );

  // 데이터 수정
  const onToggle = useCallback(
    (id) => {
      setToDos(
        todos.map((todo) =>
          todo.id === id ? { ...todo, checked: !todo.checked } : todo
        )
      );
    },
    [todos]
  );
  return (
    <div className="App">
      <ToDoTemplate>
        <ToDoInsert onInsert={onInsert} />
        <ToDoList todos={todos} onRemove={onRemove} onToggle={onToggle} />
      </ToDoTemplate>
    </div>
  );
}

export default App;
