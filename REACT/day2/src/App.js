import MyComponent from "./MyComponent";
import StateComponent from "./StateComponent";
import StateComponentFunc from "./StateComponentFunc";
import EventPractice from "./EventPractice";

function App() {
  return (
    <div>
      <MyComponent name={3}>태그 안에 내용</MyComponent>;
      <StateComponent />;
      <StateComponentFunc />
      <EventPractice />
    </div>
  );
}

export default App;
