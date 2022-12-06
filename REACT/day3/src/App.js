import "./App.css";
import ErrorBoundary from "./ErrorBoundary";
import FunctionState from "./FunctionState";
import Iteration from "./iteration";
import ClassState from "./ClassState";
import InputSample from "./InputSample";
import ClassEffect from "./ClassEffect";
import ClassEffectFunc from "./ClassEffectFunc";
import UserList from "./UserList";
import CreateUser from "./CreateUser";

//하위 컴포넌트 Createuser 활용
import { useState, useRef, useMemo } from "react";

// active true 데이터 개수
const countActiveUser = (users) => {
  console.log("사용자 수 세기");
  return users.filter((user) => user.active).length;
};
function App() {
  //UserList 받기
  // 배열의 데이터 수정시 컴포넌트가 리랜더링 될 수 있도록
  // state로 생성
  const [users, setUsers] = useState([
    { id: 1, username: "adam", email: "1234@naver.com", active: false },
    { id: 2, username: "jacob", email: "1421@naver.com", active: false },
    { id: 3, username: "pax", email: "4678@naver.com", active: false },
    { id: 4, username: "john", email: "198765@naver.com", active: false },
  ]);

  const [inputs, setInputs] = useState({
    username: "",
    email: "",
  });
  const { username, email } = inputs;

  const onChange = (e) => {
    setInputs({
      ...inputs,
      [e.target.name]: e.target.value,
    });
  };

  //ref 변수
  const nextId = useRef(5);

  const onCreate = () => {
    // 하나의 객체 생성
    const user = {
      id: nextId.current,
      username,
      email,
      active: false,
    };
    // users 에 user 객체 추가
    setUsers([...users, user]);
    // 입력 요소 초기화
    setInputs({
      username: "",
      email: "",
    });
    // 다음 삽입 위해 증가
    nextId.current += 1;
  };

  const onRemove = (id) => {
    // users state 에서 id=id 인 데이터 삭제
    // id가 일치하지 않은 데이터로만 새로운 배열 생성
    setUsers(users.filter((user) => user.id !== id));
  };

  // id에 해당하는 데이터 active 속성 값 반전
  const onToggle = (id) => {
    setUsers(
      users.map((user) =>
        user.id === id ? { ...user, active: !user.active } : user
      )
    );
  };

  // 활성화된 user 개수 세기
  // 계속해서 리랜더링 되므로 유저 수 계산
  // 변화 생길 때 함수 호출하고 나머지는 결과 복사
  const count = useMemo(() => countActiveUser(users), [users]);
  return (
    <div>
      <ErrorBoundary>
        <Iteration />
        <ClassState />
        <FunctionState />
        <InputSample />
        <ClassEffect />
        <ClassEffectFunc />
        <UserList users={users} onRemove={onRemove} onToggle={onToggle} />
        <CreateUser
          username={username}
          email={email}
          onChange={onChange}
          onCreate={onCreate}
        />
        <div>활성화된 유저 수 : {count}</div>
      </ErrorBoundary>
    </div>
  );
}

export default App;
