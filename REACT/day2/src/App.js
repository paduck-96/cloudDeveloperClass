import MyComponent from "./MyComponent";
import StateComponent from "./StateComponent";
import StateComponentFunc from "./StateComponentFunc";

function App() {
  return (
    <div>
      <MyComponent name={3}>태그 안에 내용</MyComponent>;
      <StateComponent />;
      <StateComponentFunc />
    </div>
  );
}

export default App;
