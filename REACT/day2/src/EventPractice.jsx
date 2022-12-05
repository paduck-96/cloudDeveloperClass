import React, { Component } from "react";

class EventPractice extends Component {
  state = {
    name: "",
  };
  render() {
    return (
      <>
        <h1>이벤트 연습</h1>
        <input
          type="text"
          name="message"
          placeholder="이름 입력"
          value={this.state.name}
          onChange={(e) => {
            this.setState({ name: e.target.value });
            // 콘솔 출력 console.log(e.target.value);
          }}
        />
        <button
          onClick={(e) => {
            alert(this.state.name);
            this.setState({
              name: "",
            });
          }}
        >
          확인
        </button>
      </>
    );
  }
}

export default EventPractice;
