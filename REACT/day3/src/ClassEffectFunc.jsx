import React, { useState, useEffect } from "react";

const ClassEffectFunc = () => {
  //생성자 와 동일
  const [count, setCount] = useState(0);

  useEffect(() => {
    console.log("마운트 와 업데이트가 끝나면 호출");
    document.title = `You clicked ${count} times`;
  });

  return (
    <div>
      <p>You clicked {count} times</p>
      <button onClick={(e) => setCount(count + 1)}>+1</button>
    </div>
  );
};
export default ClassEffectFunc;
