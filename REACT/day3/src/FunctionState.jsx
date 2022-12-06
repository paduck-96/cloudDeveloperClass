import React, { useState } from "react";

const FunctionState = () => {
  const [count, setCount] = useState(0);
  return (
    <div>
      <p> 클릭 {count} 수행</p>
      <button
        onClick={(e) => {
          setCount(count + 1);
        }}
      >
        +1
      </button>
    </div>
  );
};
export default FunctionState;
