import React, { Component } from "react";
import "./sample.css";

class ValidationSample extends Component {
  // 클래스 안의 멤버 변수 나 함수 안의 지역 변수 와 유사
  // state 변경 즉시 화면 적용
  state = {
    password: "",
    clicked: false,
    validated: false,
  };

  handleButtonClick = (e) => {
    this.setState({
      clicked: true,
      validated: this.state.password === "0000",
    });
  };
  handleChange = (e) => {
    this.setState({
      [e.target.name]: e.target.value,
    });
  };
  render() {
    return (
      <div>
        <input
          type="password"
          value={this.state.password}
          className={
            this.state.clicked
              ? this.state.validated
                ? "success"
                : "failure"
              : ""
          }
          name="password"
          onChange={this.handleChange}
        />
        <button onClick={this.handleButtonClick}>검증</button>
      </div>
    );
  }
}

export default ValidationSample;
