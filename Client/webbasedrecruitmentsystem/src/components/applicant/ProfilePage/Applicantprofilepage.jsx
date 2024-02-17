
import ProfilePicAlternate from "../../../assets/images/ProfilePicAlternate.png";
import { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import { FetchUserDetailsInfo } from '../../../services/applicant'
import { FetchAddressDetails } from '../../../services/applicant'
import { FetchProfileInfo } from "../../../services/applicant";
import { DeleteResume } from "../../../services/applicant";
import { logout } from "../../../services/helper"
import axios from "axios";
import { ToastContainer, toast } from "react-toastify";
import '../ProfilePage/ApplicantProfilePage.css'



function ProfilePage() {



  //useState for User Details api
  const [userDetails, setUserDetails] = useState({ firstName: "", lastName: "", gender: "", email: "", phoneNumber: "", dob: "" })
  //useState for Address api
  const [address, setAddress] = useState({ permanentAddress: "", pincode: "", state: "", country: "" })
  //useState for Profile info api
  const [profileInfo, setProfileInfo] = useState({ emailIdVerifyStatus: false, mobileNumVerifyStatus: false, resumeLink: "", resumeHeadLine: "", profileSummary: "", profilePictureLink: "", maritalStatus: "", noticePeriod: "" })
  //useState for Resume upload api
  const [file, setFile] = useState(null);

  //to fetch data on load
  useEffect(() => {
    FetchUserDetailsInfo(userDetails, setUserDetails);
    FetchAddressDetails(address, setAddress);
    FetchProfileInfo(profileInfo, setProfileInfo);
  }, []);


  //set resume in file on upload
  const handleFileChange = (event) => {
    setFile(event.target.files[0]);
  };

  //send file on application server
  const handleSubmit = async () => {
    const formData = new FormData();
    formData.append('file', file);
    try {
      await axios.post('https://localhost:7878/applicant/upload-resume', formData, {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      });
      console.log('File uploaded successfully');
    } catch (error) {
      console.error('Error uploading file:', error.message);

      toast.error("Resume could not be uploaded")
    }
  };




  const navigate = useNavigate();


  return (<>
    <nav className="navbar navbar-expand-lg  background">
      <Link className="navbar-brand" href="/">
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
            <button className="nav-link items" onClick={() => { logout(navigate) }}>Log out</button>
          </li>
        </ul>
      </div>
    </nav>


    <div className="mainDiv">

      <div className="container  containerDiv pt-3">

        <div className="row ">

          <div className="  basicDetailsDiv roundedShadowDiv pt-4">
            {/* div to keep every div in a row  */}
            <div className="row">

              {/* this is IMAGE div */}
              <div className=" col-3 imageDiv  justify-content-center mx-4 ">
                {profileInfo.profilePictureLink === "deleted" ?
                  <div>
                    <img src={ProfilePicAlternate} className="alt-image " alt="" />
                  </div> :
                  <div>
                    <img src={profileInfo.profilePictureLink} className="image " alt="" />
                  </div>}

              </div>

              {/* this is user detail div */}
              {/* {userDetails.firstName}{userDetails.lastName} */}
              <div className="col-9">
                <div className="px-3"><span className="name">{userDetails.firstName} {userDetails.lastName}</span><i style={{ cursor: "pointer" }} class="bi bi-pencil h4 pencil" ></i> </div>
                <hr />
                <div className="row">
                  <div className="col-5">
                    <div className="iconPadding"><i class="bi bi-geo-alt iconPadding"></i>{address.state}</div>
                    <div><i className="bi bi-calendar2-event iconPadding"></i>
                      {profileInfo.noticePeriod === "FIFTEEN_DAYS_OR_LESS" ? "15 Days or less of notice period" :
                        profileInfo.noticePeriod === "ONE_MONTH" ? "One month of notice period" :
                          profileInfo.noticePeriod === "TWO_MONTHS" ? "Two months of notice period" :
                            profileInfo.noticePeriod === "THREE_MONTHS" ? "Three months of notice period" :
                              "Three months of more notice period"
                      }

                    </div>
                  </div>
                  <div className="col-1 vertical-line  vertical-line-basic"></div>
                  <div className="col-5 paddingMargin">
                    <div className="iconPadding">
                      <i className="bi bi-telephone iconPadding"></i>
                      {userDetails.phoneNumber}
                    </div>
                    <div>
                      <i className="bi bi-envelope iconPadding"></i>
                      {userDetails.email}
                    </div>

                  </div>
                </div>
              </div>
              {/* userDetails div */}
              <div>



              </div>
            </div>



          </div>


        </div>
        {/* resume card */}
        <div className="row my-1">
          <div className="  basicDetailsDiv roundedShadowDiv pt-4">
            <div className="row">
              {/* resume headline */}
              <div className="col-6">
                <div><span className="paddingMargin" style={{ color: "#9B7ED9", fontSize: "30px" }}>Resume headline</span> <i style={{ cursor: "pointer" }} class="bi bi-pencil h5 pencil" ></i></div>
                {
                  profileInfo.resumeHeadLine==="0"?
                  <div className="py-3" >
                    <span>It is the first thing recuiters notice in your profile. Write concisely what makes you unique and right person for the job you are looking for .</span>
                    <div className="py-3"><h4>Write you resume headlines</h4></div>
                  </div>
                  :
                  <div className="m-2">{profileInfo.resumeHeadLine}</div>
                  
                }
              </div>
              <div className="vertical-line col-1" style={{width:"80px"}}></div>
              {/* resume upload */}
              <div className="row col-5">

                {profileInfo.resumeLink === "deleted" ?
                  //if user hasn't uploaded resume
                  <div>
                    <span className="paddingMargin" style={{ color: "#9B7ED9", fontSize: "30px" }}>Resume</span> <br />
                    <span style={{ fontSize: "14px" }} className="">A resume is the most important document recruiter look for. Recruiters generally do no look at profiles without resume.</span>

                    <div className="col-6">
                      <div className="row">
                        <div className="py-3"><input className="form-control" type="file" onChange={handleFileChange} /></div>
                        <div className="py-2">Supported formats : PDF</div>
                      </div>
                    </div>

                    <div className="col-6 py-1">

                      <button className="  rounded-button rounded-button:hover" onClick={handleSubmit}>Upload</button>
                    </div>
                  </div> :
                  //if user has uploaded resume
                  <div>

                    <div className="row">
                      <div className="col-6"><span className="paddingMargin" style={{ color: "#9B7ED9", fontSize: "30px" }}>Resume</span> </div>
                      <div className="col-6 py-2"><span onClick={() => { DeleteResume() }} style={{ cursor: "pointer", color: "blue" }} className="text-decoration-none">Delete</span></div>

                    </div>

                    <span style={{ fontSize: "14px" }} className="paddingMargin">A resume is the most important document recruiter look for. Recruiters generally do no look at profiles without resume.</span>

                    <div className="col-12">
                      <div className="dotted-border-div row justify-content-center">
                        <div className="col-8">
                          <Link to={profileInfo.resumeLink} target="_blank" rel="noopener noreferrer" className="rounded-button rounded-button:hover text-decoration-none">DOWNLOAD-RESUME</Link></div>

                      </div>
                    </div>

                  </div>
                }


              </div>
            </div>

          </div>

        </div>

      </div>
      <ToastContainer />
    </div>
  </>
  );
}

export default ProfilePage;

