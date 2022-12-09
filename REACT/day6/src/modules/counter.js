// 타입 생성 - 매개변수 받아 증감, INCREASE, DECREASE
const SET_DIFF = "counter/SET_DIFF";
const INCREASE = "counter/INCREASE";
const DECREASE = "counter/DECREASE";

// 액션 생성 함수
//밖에서 액션을 연결해야하니 export
export const setDiff = (diff) => ({ type: SET_DIFF, diff });
export const increase = () => ({ type: INCREASE });
export const decrease = () => ({ type: DECREASE });

// 초기 상태 선언
const initialState = {
  number: 0,
  diff: 1,
};

// 리두서
export default function counter(state = initialState, action) {
  switch (action.type) {
    case SET_DIFF:
      return { ...state, diff: action.diff };
    case INCREASE:
      return { ...state, number: state.number + state.diff };
    case DECREASE:
      return { ...state, number: state.number - state.diff };
    default:
      return state;
  }
}
