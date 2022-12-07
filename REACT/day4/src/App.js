import "./App.css";
import Average from "./Average";
import CSSModule from "./CSSModule";
import styles from "./App.scss";
import classNames from "classnames/bind";

const cx = classNames.bind(styles);

function App() {
  const isBlue = true;
  return (
    <div className="App">
      <div className={cx("box", { blue: isBlue })}>
        <div className={cx("box-inside")}></div>
      </div>
      <div className={cx("box-inside")}></div>
      <Average />
      <CSSModule />
    </div>
  );
}

export default App;
