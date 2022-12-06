import "./App.css";
import ErrorBoundary from "./ErrorBoundary";
import FunctionState from "./FunctionState";
import Iteration from "./iteration";
import ClassState from "./ClassState";
import InputSample from "./InputSample";
import ClassEffect from "./ClassEffect";
import ClassEffectFunc from "./ClassEffectFunc";
import UserList from "./UserList";

function App() {
  //UserList 받기
  const users = [
    { id: 1, username: "adam", email: "1234@naver.com" },
    { id: 2, username: "jacob", email: "1421@naver.com" },
    { id: 3, username: "pax", email: "4678@naver.com" },
    { id: 4, username: "john", email: "198765@naver.com" },
  ];

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
      </ErrorBoundary>
    </div>
  );
}

export default App;
