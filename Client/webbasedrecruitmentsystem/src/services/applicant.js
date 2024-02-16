import axios from "axios";

//base url for applicant contoller
const baseurl = "https://localhost:7878/applicant/";


export function FetchUserDetailsInfo(userDetails,setUserDetails){
  
  axios.get(baseurl+"user-detail").then((response)=>{

    setUserDetails(response.data)
    
    console.log("RESPONSE :"+userDetails.firstName+userDetails.lastName+userDetails.email);
  
  }).catch((error)=>{ 
  
    console.log("ERROR :"+error);
  
  })
}

export function FetchAddressDetails(address,setAddress){
  axios.get(baseurl+"address").then((response)=>{
    setAddress(response.data)
    console.log("Address :"+ address.permanentAddress+address.pincode+address.state+address.country);
  }).catch((error)=>{
    console.log("ERROR :"+ error);
  })
}

export function FetchProfileInfo(profileInfo,setProfileInfo){
  axios.get(baseurl+"profile-info").then((response)=>{
    setProfileInfo(response.data)
    console.log("Profile Info :"+ profileInfo.emailIdVerifyStatus +profileInfo.mobileNumVerifyStatus+profileInfo.resumeLink+
    profileInfo.resumeHeadLine+profileInfo.profileSummary+profileInfo.profilePictureLink+profileInfo.maritalStatus+
    profileInfo.noticePeriod);
  }).catch((error)=>{
    console.log("ERROR :"+ error);
  })
}
