import MyComponent from "./MyComponent";
import StateComponent from "./StateComponent";
import StateComponentFunc from "./StateComponentFunc";
import EventPractice from "./EventPractice";
import EventPracticeFunc from "./EventPracticeFunc";

function App() {
  return (
    <div>
      <MyComponent name={3}>태그 안에 내용</MyComponent>;
      <StateComponent />;
      <StateComponentFunc />
      <EventPractice />
      <EventPracticeFunc />
    </div>
  );
}

export default App;
