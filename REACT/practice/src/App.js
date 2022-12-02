import "./App.css";
import React, { Component } from "react";
import A from "./MyComponent";
class App extends Component {
  render() {
    const message = "클래스형 컴포넌트";

    return (
      <div className="react">
        <h3>{message}</h3>
        <A></A>
      </div>
    );
  }
}

export default App;
