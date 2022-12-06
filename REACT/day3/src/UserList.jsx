import React from "react";

function User({ user, onRemove, onToggle }) {
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
