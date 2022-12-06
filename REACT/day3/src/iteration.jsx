import React, { Component } from "react";

class Iteration extends Component {
  state = {
    names: ["JavaScript"],
  };

  render() {
    const namesList = this.state.names.map((name, index) => (
      <li key={index}>{name}</li>
    ));
    return (
      <div>
        <ul>{namesList}</ul>
      </div>
    );
  }
}

export default Iteration;
