// 각 모듈별로 생성한 리덕스를
//하나의 파일에서 관리
import { combineReducers } from "redux";
import counter from "./counter";
import todos from "./todos";

const rootReducer = combineReducers({
  counter,
  todos,
});

export default rootReducer;
