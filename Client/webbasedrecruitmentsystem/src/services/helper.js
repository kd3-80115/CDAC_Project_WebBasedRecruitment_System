import axios from "axios";

/*Base url of backend*/
export const BASE_URL="https://localhost:7878";


/*Use throughout the application */
/*set the token in the header*/
export const appAxios = axios.create({
    baseURL:BASE_URL,
    headers:{
        'Authorization':'Bearer '+localStorage.getItem("token")
    }
});