import React from "react";
import { connect } from "react-redux";
import Counter from "../components/Counter";
import { increase, decrease } from "../modules/counter";

const CounterContainer = ({ number, increase, decrease }) => {
  return <Counter number={number} onIncrese={increase} onDecrease={decrease} />;
};

const mapStateProps = (state) => ({
  number: state.counter.number,
});

const mapToDispatchToProps = (dispatch) => ({
  increase: () => {
    dispatch(increase());
  },
  decrease: () => {
    dispatch(decrease());
  },
});

export default connect(mapStateProps, mapToDispatchToProps)(CounterContainer);
