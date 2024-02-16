
import ProfilePicAlternate from "../../../assets/images/ProfilePicAlternate.png";
import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import {FetchUserDetailsInfo} from '../../../services/applicant'
import {FetchAddressDetails} from '../../../services/applicant'
import { FetchProfileInfo } from "../../../services/applicant";

function ProfilePage() {

const [userDetails,setUserDetails]=useState({firstName: "",lastName: "",gender: "",email: "",phoneNumber: "",dob: ""})
const [address,setAddress]=useState({permanentAddress: "",pincode: "",state: "",country: ""})
const [profileInfo,setProfileInfo]=useState({emailIdVerifyStatus: false,mobileNumVerifyStatus: false,resumeLink: "",resumeHeadLine: "",profileSummary: "",profilePictureLink: "",maritalStatus: "",noticePeriod: ""})  

useEffect(() => {
    FetchUserDetailsInfo(userDetails,setUserDetails);
    FetchAddressDetails(address,setAddress);
    FetchProfileInfo(profileInfo,setProfileInfo);
  },[]);

  return ( <>
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
              <button className="nav-link items">Log out</button>
            </li>
          </ul>
        </div>
      </nav>


    <div className="mainDiv">
      
      <div className="container containerDiv pt-3">
        
        <div className="row ">
          
          <div className=" row basicDetailsDiv roundedShadowDiv pt-4">
            
            {/* this is IMAGE div */}
            <div className=" col-3 imageDiv  justify-content-center py-3 mx-4">
              <img src={ProfilePicAlternate} className="image img-responsive" alt=""/>           
            </div>
            
            {/* this is user detail div */}
            {/* {userDetails.firstName}{userDetails.lastName} */}
            <div className="col-9">
              <div className="px-3"><span className="name">{userDetails.firstName} {userDetails.lastName}</span><a href="#"><i class="bi bi-pencil h4 pencil" ></i> </a></div>
              <hr />
              <div className="row">
                <div className="col-6">
                  <div className="iconPadding"><i class="bi bi-geo-alt iconPadding"></i>{address.state}</div>
                    <div><i class="bi bi-calendar2-event iconPadding"></i> 
                      {profileInfo.noticePeriod==="FIFTEEN_DAYS_OR_LESS"?"15 Days or less of notice period":
                      profileInfo.noticePeriod==="ONE_MONTH"?"One month of notice period":
                      profileInfo.noticePeriod==="TWO_MONTHS"?"Two months of notice period":
                      profileInfo.noticePeriod==="THREE_MONTHS"?"Three months of notice period":
                      "Three months of more notice period"
                      }
                      
                    </div>
                  </div>
                  <div className="col-1 vertical-line  paddingMargin"></div>
                  <div className="col-5 paddingMargin">
                    <div className="iconPadding">
                      <i class="bi bi-telephone iconPadding"></i>
                      {userDetails.phoneNumber}
                    </div>
                    <div> <i class="bi bi-envelope iconPadding"></i> {userDetails.email}</div>
                    
                  </div>
              </div>
            </div>
         
          </div>
        
        </div>
      
      </div>
    
    </div>
</>
   );
}

export default ProfilePage;

