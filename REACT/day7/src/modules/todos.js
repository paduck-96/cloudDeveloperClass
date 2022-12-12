// 액션 타입 정의
const CHANGE_INPUT = "todos/CHANGE_INPUT";
const INSERT = "todos/INSERT";
const TOGGLE = "todos/TOGGLE";
const REMOVE = "todos/REMOVE";

// 액션 생성 함수 정의
export const changeInput = (input) => ({
  type: CHANGE_INPUT,
  input,
});
//더미데이터 생성
let id = 3;
export const insert = (text) => ({
  type: INSERT,
  todo: {
    id: id++,
    text,
    done: false,
  },
});

export const toggle = (id) => {
  return { type: TOGGLE, id };
};

export const remove = (id) => ({
  type: REMOVE,
  id,
});

// 초기값 설정
const initialState = {
  input: "",
  todos: [
    {
      id: 1,
      text: "Node",
      done: true,
    },
    {
      id: 2,
      text: "React",
      done: false,
    },
  ],
};

// state,action으로 구성된 redux 생성
const todos = (state = initialState, action) => {
  switch (action.type) {
    case CHANGE_INPUT:
      return { ...state, input: action.input };
    case INSERT:
      return { ...state, todos: state.todos.concat(action.todo) };
    case TOGGLE:
      return {
        ...state,
        todos: todos.map((todo) =>
          todo.id === action.id ? { ...todo, done: !todo.done } : todo
        ),
      };
    case REMOVE:
      return {
        ...state,
        todos: state.todos.filter((todo) => todo.id !== action.id),
      };
    default:
      return state;
  }
};

export default todos;
