import "./App.css";
import ErrorBoundary from "./ErrorBoundary";
import Iteration from "./iteration";

function App() {
  return (
    <div>
      <ErrorBoundary>
        <Iteration />
      </ErrorBoundary>
    </div>
  );
}

export default App;
