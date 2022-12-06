import React, { Component } from "react";

class ErrorBoundary extends Component {
  state = {
    error: false,
  };
  // 컴포넌트 예외 시 호출
  componentDidCatch(error, info) {
    this.setState({
      error: true,
    });
    console.log({ error, info });
  }
  render() {
    if (this.state.error) {
      return <div>에러 발생</div>;
    } else {
      return this.props.children;
    }
  }
}

export default ErrorBoundary;
