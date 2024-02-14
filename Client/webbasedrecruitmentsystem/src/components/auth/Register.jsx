import { useState } from "react";
import axios from "axios";
import "../auth/Register.css";
function Register() {
  const url = "https://localhost:7878/users/signup";
  /* Response {
  "id": 9,
  "firstName": "Hero",
  "lastName": "no one",
  "email": "her0@gmail.com",
  "phoneNumber": "876543211",
  "dob": "2023-02-13",
  "role": "ROLE_APPLICANT",
  "gender": "MALE"
}*/

  const [responseData, setResponseData] = useState();

  const [sendData, setSendUpData] = useState({
    firstName: "",
    lastName: "",
    email: "",
    password: "",
    phoneNumber: "",
    dob: "",
    gender: "",
  });

  const OnTextChanged = (args) => {
    var copyOfEmp = { ...sendData };
    copyOfEmp[args.target.name] = args.target.value;
    setSendUpData(copyOfEmp);
  };

  function SignUp() {
    console.log("Hi");
    console.log(sendData);
    axios
      .post(url, sendData)
      .then((result) => {
        if (result.data.email === sendData.email) {
          setResponseData(result.data);
        }
      })
      .catch((error) => {
        console.log(error);
      });
   
  }

  // Function to handle radio button change
  const handleGenderChange = (event) => {
    const genderValue = event.target.value; // Get the selected gender value
    setSendUpData({
      ...sendData,
      gender: genderValue, // Update the gender field in the state
    });
  };
  return (
    <div className="container">
      <div
        className=" row justify-content-center   my-5 "
        style={{ backgroundColor: "#F5F5F5" }}
      >
        <div id="signUpBar" className=" text-center  ">
          <h2>SignUp</h2>
        </div>

        <div className="col-6">
          <br />
          <form>
            <div className="form-group">
              <b style={{ color: "#9B7ED9", fontSize: 22 }}>First Name</b>
              <input
                type="text"
                className="form-control"
                id="firstName"
                name="firstName"
                value={sendData.firstName}
                placeholder="Enter first name"
                autoComplete="off"
                onChange={OnTextChanged}
              />
            </div>
            <br />
            <div className="form-group">
              <b style={{ color: "#9B7ED9", fontSize: 22 }}>Last Name</b>
              <input
                type="text"
                className="form-control"
                id="lastName"
                name="lastName"
                value={sendData.lastName}
                placeholder="Enter Last name"
                autoComplete="off"
                onChange={OnTextChanged}
              />
            </div>
            <br />
            <div className="form-group">
              <b style={{ color: "#9B7ED9", fontSize: 22 }}>Gender</b>
              <br />

              <input
                className="form-check-input"
                type="radio"
                name="MALE"
                id="MALE"
                checked={sendData.gender === 'MALE'}
                onChange={handleGenderChange}
                value="MALE"
              />
              <b style={{ color: "#9B7ED9", fontSize: 15 }}> Male</b>

              <input
                className="form-check-input"
                type="radio"
                name="FEMALE"
                checked={sendData.gender === 'FEMALE'}
                onChange={handleGenderChange}
                value="FEMALE"
              />

              <b style={{ color: "#9B7ED9", fontSize: 15 }}> Female</b>
              <input
                className="form-check-input"
                type="radio"
                name="OTHER"
                id="OTHER"
                checked={sendData.gender === 'OTHER'}
                onChange={handleGenderChange}
                value="OTHER"
              />
              <b style={{ color: "#9B7ED9", fontSize: 15 }}> Other</b>
            </div>
            <br />
            <div className="form-group">
              <b style={{ color: "#9B7ED9", fontSize: 22 }}>Email ID</b>
              <input
                type="email"
                className="form-control"
                id="email"
                name="email"
                value={sendData.email}
                placeholder="Enter email ID"
                autoComplete="off"
                onChange={OnTextChanged}
              />
            </div>
            <br />
            <div className="form-group">
              <b style={{ color: "#9B7ED9", fontSize: 22 }}>Password</b>
              <input
                type="password"
                className="form-control"
                id="password"
                name="password"
                value={sendData.password}
                placeholder="Enter password"
                autoComplete="off"
                onChange={OnTextChanged}
              />
            </div>
            <br />
            <div className="form-group">
              <b style={{ color: "#9B7ED9", fontSize: 22 }}>Date of birth</b>
              <input
                type="date"
                className="form-control"
                id="dob"
                name="dob"
                autoComplete="off"
                onChange={OnTextChanged}
              />
            </div>
            <br />
            <div className="form-group">
              <b style={{ color: "#9B7ED9", fontSize: 22 }}>Phone number</b>
              <input
                type="text"
                className="form-control"
                id="phoneNumber"
                name="phoneNumber"
                value={sendData.phoneNumber}
                placeholder="Enter mobile number"
                autoComplete="off"
                onChange={OnTextChanged}
              />
            </div>
            <br />
            <button
              type="button"
              className="btn btn-primary"
              onClick={() => {
                SignUp();
              }}
              style={{ backgroundColor: "#9B7ED9", width: 120, height: 50 }}
            >
              Sign Up
            </button>
          </form>
        </div>
      </div>
    </div>
  );
}

export default Register;
