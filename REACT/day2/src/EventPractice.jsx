import React, { Component } from "react";

class EventPractice extends Component {
  state = {
    name: "",
  };

  handleChange = (e) => {
    this.setState({
      name: e.target.value,
    });
  };
  handleClick = (e) => {
    alert(this.state.name);
    this.setState({ name: "" });
  };

  // 인스턴스의 메서드로 자동 변환
  // constructor(props) {
  //   super(props);
  //   this.handleChange = this.handleChange.bind(this);
  //   this.handleClick = this.handleClick.bind(this);
  // }
  render() {
    return (
      <>
        <h1>이벤트 연습</h1>
        <input
          type="text"
          name="message"
          placeholder="이름 입력"
          value={this.state.name}
          onChange={
            this.handleChange
            // 함수화 (e) => {
            // this.setState({ name: e.target.value });
            // 콘솔 출력 console.log(e.target.value);
          }
        />
        <button
          onClick={
            this.handleClick
            //(e) => {
            //alert(this.state.name);
            //this.setState({
            //  name: "",
            //});
          }
        >
          확인
        </button>
      </>
    );
  }
}

export default EventPractice;
