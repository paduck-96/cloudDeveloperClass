import React, { Component } from "react";

class Iteration extends Component {
  state = {
    names: ["JavaScript"],
    name: "",
  };

  // input에 입력하면 name state의 값을 변경하는 이벤트
  handleChange = (e) => {
    this.setState({
      name: e.target.value,
    });
  };
  // 변경된 name을 names에 추가 이벤트
  handleInsert = (e) => {
    this.setState({
      // 원본을 수정하지 않는 방식
      // .push( )는 원본 수정
      names: this.state.names.concat(this.state.name),
      name: "",
    });
  };
  // 데이터 삭제 함수
  // index를 매개변수로 받아서 삭제
  handleRemove = (index) => {
    const { names } = this.state;
    //slice(매개변수 2개) 받아서 배열을 잘라내는 과정
    //시작위치와 마지막 위치 대입
    this.setState({
      names: [names.slice(0, index), names.slice(index + 1, names.length)],
    });
  };
  render() {
    const namesList = this.state.names.map((name, index) => (
      <li key={index} onDoubleClick={(e) => this.handleRemove(index)}>
        {name}
      </li>
    ));
    return (
      <div>
        <input
          type="text"
          onChange={this.handleChange}
          value={this.state.name}
        />
        <button onClick={this.handleInsert}>추가</button>
        <ul>{namesList}</ul>
      </div>
    );
  }
}

export default Iteration;
