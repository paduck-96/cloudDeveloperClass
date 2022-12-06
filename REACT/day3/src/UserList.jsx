import React, { useEffect } from "react";

function User({ user, onRemove, onToggle }) {
  // 마운트 될 때 그리고 state 가 변경될 떄 모두 호출
  useEffect(() => {
    console.log("컴포넌트 등장");
    console.log(user); //삽입 과 수정 시 호출됌
    //이 순간의 id 유무에 따라 있으면 수정, 없으면 삭제

    //함수 리턴할 경우 컴포넌트 사라질 경우 호출 됌
    // 소멸자
    return () => {
      console.log("컴포넌트 사라짐");
      console.log(user); //유저가 삭제될 때 불림
      // 삭제는 이 순간에 구현
    };
  }, [user]);
  return (
    <div>
      <b
        style={{ cursor: "pointer", color: user.active ? "blue" : "red" }}
        onClick={() => onToggle(user.id)}
      >
        {user.username}
      </b>
      <span>{user.email}</span>
      <button onClick={(e) => onRemove(user.id)}>❌</button>
    </div>
  );
}

function UserList({ users, onRemove, onToggle }) {
  return (
    <div>
      {users.map((user) => (
        <User
          user={user}
          key={user.id}
          onRemove={onRemove}
          onToggle={onToggle}
        />
      ))}
    </div>
  );
}

export default UserList;
