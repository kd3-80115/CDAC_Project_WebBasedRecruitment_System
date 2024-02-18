import axios from "axios";
import { BASE_URL } from "./helper";

/*Get hr details*/
export const getHrDetails = () => {
  return axios.get(BASE_URL + "/hr").then((response) => {
    return response.data;
  });
};

/*Upload Image of hr*/
export const uploadImage = (file) => {
  const formData = new FormData();
  formData.append("file", file); // 'image' should match the name expected by your server
  return axios.post(BASE_URL + "/hr/upload-image",formData,{
    headers: {
      'Content-Type': 'multipart/form-data',
    },
  }).then((response) => {
    return response.data;
  });
};

/*Update Image*/
export const upDateImage = (file) => {
  const formData = new FormData();
  formData.append("file", file); // 'image' should match the name expected by your server
  return axios.put(BASE_URL + "/hr/update-image",formData,{
    headers: {
      'Content-Type': 'multipart/form-data',
    },
  }).then((response) => {
    return response.data;
  });
};

/*remove image*/
export const removeImage=()=>{
  return axios.delete(BASE_URL + "/hr/remove-image").then((response)=>{
    return response.data;
  })
}

export const updateProfile=(sendData)=>{
  return axios.post(BASE_URL+"/hr",sendData).then((response)=>{
    return response.data;
  })
}