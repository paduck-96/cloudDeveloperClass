import ToDoTemplate from "./components/ToDoTemplate";
import "./App.css";
import ToDoInsert from "./components/ToDoInsert";
import ToDoList from "./components/ToDoList";
// useRef 는 변수 생성 OR 변수 만들어 DOM에 할당할 때
// useCallback 은 함수를 효율적으로 생성
import { useRef, useCallback, useReducer } from "react";

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

// state를 조작할 reducer 함수 생성
const todoReducer = (todos, action) => {
  //분기
  switch (action.type) {
    case "INSERT":
      return todos.concat(action.todo);
    case "REMOVE":
      return todos.filter((todo) => todo.id !== action.id);
    case "TOGGLE":
      return todos.map((todo) =>
        todo.id === action.id ? { ...todo, checked: !todo.checked } : todo
      );
    default:
      return todos;
  }
};
function App() {
  // 함수 이름을 대입해야 함수를 전부 수행하고 1번만 리랜더링
  // 호출 구문 대입 시 데이터 만들어질 때마다 리랜더링
  //const [todos, setToDos] = useState(createBulkTodos);
  // reducer 설정
  //(호출될 함수, 초기값, 호출할 메서드 - 리턴 값이 초기값)
  // 리턴 결과는 state 의 이름 과 state 를 수정할 함수명
  const [todos, dispatch] = useReducer(todoReducer, undefined, createBulkTodos);
  /**
   * 데이터 만들어주는 함수 없다면
   * (''', 초기값, undefined)
   */

  //아이디 변수 생성
  const nextId = useRef(2001);
  // 삽입 처리 함수
  // todos 에 변화 생길 경우에만 함수 재생성
  const onInsert = useCallback((text) => {
    const todo = {
      id: nextId.current,
      text,
      checked: false,
    };
    //setToDos((todos) => todos.concat(todo));

    dispatch({ type: "INSERT", todo });
    nextId.current += 1;
  }, []);

  // 데이터 삭제
  const onRemove = useCallback((id) => {
    //setToDos((todos) => todos.filter((todo) => todo.id !== id));
    dispatch({ type: "REMOVE", id });
  }, []);

  // 데이터 수정
  const onToggle = useCallback((id) => {
    // setToDos((todos) =>
    //   todos.map((todo) =>
    //     todo.id === id ? { ...todo, checked: !todo.checked } : todo
    //   )
    // );

    dispatch({ type: "TOGGLE", id });
  }, []);
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
