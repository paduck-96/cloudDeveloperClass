import "./App.css";
import axios from "axios";

import Average from "./Average";
import CSSModule from "./CSSModule";
import Button from "./components/button";
import styles from "./App.scss";
import classNames from "classnames/bind";
import StyledComponent from "./components/StyledComponent";
const cx = classNames.bind(styles);

function App() {
  const isBlue = true;
  return (
    <div className="App">
      <nav>
        <div className="nav-wrapper">머터리얼 디자인</div>
      </nav>
      <div>머터리얼 디자인</div>

      <div className={cx("box", { blue: isBlue })}>
        <div className={cx("box-inside")}></div>
      </div>
      <div className={cx("box-inside")}></div>
      <Average />
      <CSSModule />
      <Button />
      <StyledComponent />
      <button
        onClick={(e) =>
          axios
            .get("https://jsonplaceholder.typicode.com/users")
            .then((res) => console.log(res.data))
            .catch((err) => console.log(err.message))
        }
      >
        다운로드
      </button>
    </div>
  );
}

export default App;
