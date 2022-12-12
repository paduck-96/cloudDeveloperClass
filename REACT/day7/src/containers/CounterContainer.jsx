import React from "react";
import { connect } from "react-redux";
import Counter from "../components/Counter";
import { increase, decrease } from "../modules/counter";

const CounterContainer = ({ number, increase, decrease }) => {
  return <Counter number={number} onIncrese={increase} onDecrease={decrease} />;
};

// 리덕스 스토어의 상태를 조회해 props 너멱주기
const mapStateProps = (state) => ({
  number: state.counter.number,
});

// 액션을 디스패치하는 함수로  props
const mapToDispatchToProps = (dispatch) => ({
  increase: () => {
    dispatch(increase());
  },
  decrease: () => {
    dispatch(decrease());
  },
});

export default connect(mapStateProps, mapToDispatchToProps)(CounterContainer);
