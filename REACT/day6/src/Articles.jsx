import { Link } from "react-router-dom";

const Articles = () => {
  return (
    <ul>
      <li>
        <Link to="/articles/1">기사 1번</Link>
      </li>
      <li>
        <Link to="/articles/2">기사 2번</Link>
      </li>
      <li>
        <Link to="/articles/1">기사 1번</Link>
      </li>
    </ul>
  );
};

export default Articles;
