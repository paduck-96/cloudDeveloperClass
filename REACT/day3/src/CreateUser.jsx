import React from "react";

function CreateUser({ username, email, onChange, onCreate }) {
  return (
    <div>
      이름 : <input name="username" value={username} onChange={onChange} />
      이메일 : <input name="email" value={email} onChange={onChange} />
      <button onClick={onCreate}>추가</button>
    </div>
  );
}
export default CreateUser;
