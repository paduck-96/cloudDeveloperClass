import React from "react";
import styles from "./Button.scss";
import classNames from "classnames/bind";

const cx = classNames.bind(styles);

// props 를 받아오고, children 으로 넘겨주기
const Button = ({ children, ...rest }) => {
  return (
    <div className={cx("button")} {...rest}>
      {children}
    </div>
  );
};
export default Button;
