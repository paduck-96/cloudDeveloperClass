import React from "react";

import styles from "./CSSModule.module.css";
const CSSModule = () => {
  return (
    <div className={styles.wrapper}>
      <span className="something">CSS 모듈</span>
    </div>
  );
};
export default CSSModule;
