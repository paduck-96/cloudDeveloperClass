import "./App.css";
import ErrorBoundary from "./ErrorBoundary";
import FunctionState from "./FunctionState";
import Iteration from "./iteration";
import ClassState from "./ClassState";
import InputSample from "./InputSample";
import ClassEffect from "./ClassEffect";
import ClassEffectFunc from "./ClassEffectFunc";

function App() {
  return (
    <div>
      <ErrorBoundary>
        <Iteration />
        <ClassState />
        <FunctionState />
        <InputSample />
        <ClassEffect />
        <ClassEffectFunc />
      </ErrorBoundary>
    </div>
  );
}

export default App;
