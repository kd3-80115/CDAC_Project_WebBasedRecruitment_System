import { appAxios } from "./helper";

export const registerHR = (hrDetails) =>{
    return appAxios.post('/admin/register-hr',hrDetails).then((response)=>{
        response.json();
    });
}

export const getHrList =() =>{
    return appAxios.get('/admin/hr-list').then((response)=>{
      return response.data
    });
}