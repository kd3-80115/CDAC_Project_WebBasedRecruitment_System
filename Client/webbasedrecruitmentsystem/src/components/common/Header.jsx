import "../../assets/styles/Navbar.css";

function Header() {
  return (
    <div>
      <nav class="navbar navbar-expand-lg background">
        <a className="navbar-brand" href="#">
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
              <a class="nav-link items" href="#">
                Home
              </a>
            </li>
            <li class="nav-item ">
              <a class="nav-link items" href="#">
                Contact us
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link items" href="#">
                About us
              </a>
            </li>
            <li class="nav-item ">
              <a class="nav-link items" href="#">
                SignIn
              </a>
            </li>
            <li class="nav-item ">
              <a class="nav-link items" href="#">
                SignUp
              </a>
            </li>
          </ul>
        </div>
      </nav>
    </div>
  );
}

export default Header;
