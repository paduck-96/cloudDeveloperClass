import React from "react";
import { useLocation } from "react-router-dom";
import qs from "qs";

const About = () => {
  // query string 읽어오기
  const location = useLocation();
  const queryString = qs.parse(location.search, {
    ignoreQueryPrefix: true,
  });
  console.log(queryString);
  return (
    <div>
      <h1>React Router 실습</h1>
      <p>Query String : {location.search}</p>
    </div>
  );
};

export default About;
