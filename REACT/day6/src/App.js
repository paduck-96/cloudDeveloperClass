import "./App.css";
import Immer from "./immer";
import { Routes, Route, Link } from "react-router-dom";
import About from "./About";
import Home from "./home";
import Profile from "./profile";
import Article from "./Article";
import Articles from "./Articles";

function App() {
  return (
    <div className="App">
      <ul>
        <li>
          {/*Link는 페이지 새로고침 X */}
          <Link to="/">홈</Link>
          <Link to="/profile/adam"> 아담</Link>
          <Link to="/profile/jessica">제시카</Link>
          <Link to="/profile/annoymus">익명</Link>
        </li>
        {/*a는 페이지 새로고침 */}
        <a href="/about">어바웃</a>
        <a href="/immer">불변성</a>
      </ul>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/immer" element={<Immer />} />
        <Route path="/profile/:username" element={<Profile />} />
        <Route path="/articles" element={<Articles />} />
        <Route path="/articles/:id" element={<Article />} />
      </Routes>
    </div>
  );
}

export default App;
