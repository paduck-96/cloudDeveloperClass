import React from "react";
import { useParams } from "react-router-dom";
const data = {
  adam: {
    name: "ㅎㅎ",
    description: "ㅎㅎㅎㅎㅎㅎ",
  },
  jessica: {
    name: "ㅌㅌ",
    description: "ㅌㅌㅌㅌㅌㅌㅌ",
  },
};
const Profile = () => {
  const params = useParams();

  //데이터 찾아오기
  const profile = data[params.username];

  return (
    <div>
      <h1>사용자 프로필</h1>
      {profile ? (
        <div>
          <h2>{profile.name}</h2>
          <p>{profile.description}</p>
        </div>
      ) : (
        <h2>존재하지 않는 사용자</h2>
      )}
    </div>
  );
};

export default Profile;
