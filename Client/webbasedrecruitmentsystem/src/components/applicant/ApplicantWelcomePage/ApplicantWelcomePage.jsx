import "./ApplicantWelcomePage.css";
import { useNavigate } from "react-router-dom";
function ApplicantWelcomePage() {
  /*use to navigate the function*/
  const navigate = useNavigate();
  return (
    <div
      style={{ height: "100vh" }}
      className="d-flex align-items-center justify-content-center"
    >
      <div
        className="container"
        style={{ backgroundColor: "#f5f5f5", height: "100vh" }}
      >
        <div style={{ marginTop: "150px" }}>
          <h1 className="text-center">Welcome to GET HIRED</h1>
        </div>

        <div
          className="row d-flex justify-content-around  "
          style={{ marginTop: "120px" }}
        >
          <div
            className="col-5 d-flex justify-content-center"
            style={{ height: "100px" }}
          >
            <button
              className="btn btn-success "
              style={{ width: "280px", fontSize: "25px" }}
            >
              Jobs
            </button>
          </div>
          <div
            className="col-5 d-flex justify-content-center"
            style={{ height: "100px" }}
          >
            <button onClick={()=>{
              navigate("/profile");
            }}
              className="btn btn-success   "
              style={{ width: "280px", fontSize: "25px" }}
            >
              Update Profile
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}

export default ApplicantWelcomePage;
