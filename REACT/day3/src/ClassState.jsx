import React, { Component } from "react";

class ClassState extends Component {
  /* 생성자 없이 state 초기화
    state = {
      count: 0,
    };
    */

  constructor(props) {
    super(props);
    this.state = {
      count: 0,
    };
  }

  render() {
    return (
      <div>
        <p> 클릭 {this.state.count} 수행</p>
        <button
          onClick={(e) => {
            this.setState({
              name: this.state.count + 1,
            });
          }}
        >
          +1
        </button>
      </div>
    );
  }
}

export default ClassState;
