import axios from "axios";
import ProfilePicAlternate from "../../../assets/images/ProfilePicAlternate.png";
import { useState, useEffect } from "react";


function ProfilePage() {

const [userDetails,setUserDetails]=useState(
  {
    firstName: "",
    lastName: "",
    gender: "",
    email: "",
    phoneNumber: "",
    dob: ""
}
)

//base url for applicant contoller
const baseurl = "https://localhost:7878/applicant/";

function FetchUserDetailsInfo(){
  
  axios.get(baseurl+"user-detail").then((response)=>{

    setUserDetails(response.data)
    
    console.log("RESPONSE :"+userDetails.firstName,userDetails.lastName,userDetails.email);
  
  }).catch((error)=>{
  
    console.log("ERROR :"+error);
  
  })
}

  useEffect(() => {
    FetchUserDetailsInfo();
  }, []);
  return ( 
    <div className="mainDiv">
      <div className="container containerDiv pt-3">
        <div className="basicDetailsDiv roundedShadowDiv pt-4">
          <div className=" imageDiv row justify-content-center py-3 mx-4">
            <img
              src={ProfilePicAlternate}
              className="image img-responsive"
              alt=""
            />
          </div>
        </div>
      </div>
    </div>

   );
}

export default ProfilePage;

