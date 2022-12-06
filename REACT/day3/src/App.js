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
import { useState, useRef } from "react";

function App() {
  //UserList 받기
  const [users, setUsers] = useState([
    { id: 1, username: "adam", email: "1234@naver.com" },
    { id: 2, username: "jacob", email: "1421@naver.com" },
    { id: 3, username: "pax", email: "4678@naver.com" },
    { id: 4, username: "john", email: "198765@naver.com" },
  ]);

  const [inputs, setInputs] = useState({
    username: "",
    email: "",
  });
  const { username, email } = inputs;

  const onChange = (e) => {
    setInputs({
      [e.target.name]: e.target.value,
    });
  };

  //ref 변수
  const nextId = useRef(3);

  const onCreate = () => {
    const user = {
      id: nextId.current,
      username,
      email,
    };
    setUsers([...users, user]);
    setInputs({
      username: "",
      email: "",
    });
    nextId.current += 1;
  };

  return (
    <div>
      <ErrorBoundary>
        <Iteration />
        <ClassState />
        <FunctionState />
        <InputSample />
        <ClassEffect />
        <ClassEffectFunc />
        <UserList users={users} />
        <CreateUser
          username={username}
          email={email}
          onChange={onChange}
          onCreate={onCreate}
        />
      </ErrorBoundary>
    </div>
  );
}

export default App;
