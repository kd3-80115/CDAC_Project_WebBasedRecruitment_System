import axios from "axios";
import {BASE_URL} from './helper'
export const registerHR = (hrDetails) =>{
    return axios.post(BASE_URL+'/admin/register-hr',hrDetails).then((response)=>{
        return  response.json();
    });
}

export const getHrList =() =>{
    return axios.get(BASE_URL+'/admin/hr-list').then((response)=>{
      return response.data
    });
}