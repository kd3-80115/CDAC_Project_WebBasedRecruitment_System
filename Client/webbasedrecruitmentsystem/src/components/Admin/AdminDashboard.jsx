import { Link, Outlet } from "react-router-dom";
import './Admin.css'
function AdminDashboard() {
  return (
    <>
      <nav className="navbar navbar-expand-lg  background">
        <Link className="navbar-brand" href="/Home">
          Get Hired
        </Link>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarSupportedContent">
          <ul className="navbar-nav ms-auto">
            <li className="nav-item ">
              <button className="nav-link items">Log out</button>
            </li>
          </ul>
        </div>
      </nav>
      <div className="side-bar">
        <div className="">
          <h1 className="m-2">Welcome</h1>
          <h2>Admin</h2>
        </div>
        <div></div>
      </div>
      <Outlet/>
    </>
  );
}

export default AdminDashboard;
