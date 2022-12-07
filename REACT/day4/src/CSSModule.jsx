import React from "react";
import classNames from "classnames/bind";

import styles from "./CSSModule.module.scss";

// cx 안에서는 styles 생략 가능
const cx = classNames.bind(styles);

const CSSModule = () => {
  return (
    <div className={cx("wrapper", "inverted")}>
      <span className="something">CSS 모듈</span>
    </div>
  );
};
export default CSSModule;
