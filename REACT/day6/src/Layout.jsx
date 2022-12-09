import { Outlet } from "react-router-dom";

const Layout = () => {
  return (
    <div>
      <header style={{ background: "lightgray", padding: 16, fontSize: 16 }}>
        Header
      </header>
      <main>
        <Outlet />
      </main>
    </div>
  );
};
export default Layout;
