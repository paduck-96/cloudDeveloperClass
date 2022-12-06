import React from "react";

class ClassEffect extends React.Component {
  //생성자
  constructor(props) {
    super(props);
    console.log("생성자 - 가장 먼저 호출되는 메서드");
    this.state = {
      count: 0,
    };
  }

  //Component 가 Mount 된 후 호출 메서드
  componentDidMount() {
    console.log("마운트 된 후 호출되는 메서드");
    document.title = `You clicked ${this.state.count} times`;
  }

  //Component 가 update 된 후 호출 메서드
  componentDidUpdate() {
    console.log("업데이트 된 후 호출되는 메서드");
    document.title = `You clicked ${this.state.count} times`;
  }

  render() {
    return (
      <div>
        <p>You clicked {this.state.count} times</p>
        <button onClick={(e) => this.setState({ count: this.state.count + 1 })}>
          +1
        </button>
      </div>
    );
  }
}
export default ClassEffect;
