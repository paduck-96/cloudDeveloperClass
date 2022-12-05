import React from "react";
import PropTypes from "prop-types";

const MyComponent = ({ name, children, year }) => {
  return (
    <>
      <div>나의 컴포넌트</div>
      <div>
        <h1>컴포넌트 이름은 {name} 입니다</h1>
        <h3>{children}</h3>
        <h3>나는 {year}년 에 태어났다</h3>
      </div>
    </>
  );
};

MyComponent.propTypes = {
  name: PropTypes.string,
  year: PropTypes.number.isRequired,
};
MyComponent.defaultProps = {
  name: "미기입 시 기본값",
};
export default MyComponent;
