import MyComponent from "./MyComponent";
import StateComponent from "./StateComponent";

function App() {
  return (
    <div>
      <MyComponent name={3}>태그 안에 내용</MyComponent>;
      <StateComponent />;
    </div>
  );
}

export default App;
