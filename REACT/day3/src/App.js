import "./App.css";
import ErrorBoundary from "./ErrorBoundary";
import FunctionState from "./FunctionState";
import Iteration from "./iteration";
import ClassState from "./ClassState";

function App() {
  return (
    <div>
      <ErrorBoundary>
        <Iteration />
        <ClassState />
        <FunctionState />
      </ErrorBoundary>
    </div>
  );
}

export default App;
