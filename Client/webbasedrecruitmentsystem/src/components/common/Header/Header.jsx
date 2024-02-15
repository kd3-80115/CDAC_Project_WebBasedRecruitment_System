import "./Header.css";
import { NavLink } from "react-router-dom";
function Header() {
  return (
    <div>
      <nav class="navbar  fnavbar-expand-lg navbar-fixed-top background">
        <a class="navbar-brand " href="/Home">
          Get Hired
        </a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul className="navbar-nav ms-auto ">
            <li class="nav-item">
              <NavLink className="nav-link items" to={"/home"}>
                Home
              </NavLink>
            </li>
            <li class="nav-item ">
              <NavLink className="nav-link items" to={"/contact-us"}>
                Contact us
              </NavLink>
            </li>
            <li class="nav-item">
              <NavLink className="nav-link items" to={"/about-us"}>
                AboutUs
              </NavLink>
            </li>
            <li class="nav-item ">
              <NavLink className="nav-link items" to={"/register"}>
                SignIn
              </NavLink>
            </li>
            <li class="nav-item ">
              <NavLink className="nav-link items" to={""}>
                SignUp
              </NavLink>
            </li>
          </ul>
        </div>
      </nav>
    </div>
  );
}

export default Header;
