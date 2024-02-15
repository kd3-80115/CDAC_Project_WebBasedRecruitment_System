import {
  createRoutesFromElements,
  createBrowserRouter,
  Route,
  RouterProvider,
  Navigate
} from "react-router-dom";

import { useAuth } from "../services/authprovider";
import { ProtectedRoute } from "./ProtectedRoute";
import Dashboard from "../components/Dashboard";
import ContactUs from "../components/common/ContactUs/ContatctUs";
import AboutUs from "../components/common/AboutUs/About";
import Home from "../components/common/Home/Home";
import Register from "../components/auth/Register";
import LogIn from "../components/auth/Login";
import { jwtDecode } from "jwt-decode";


const Routes = () =>{
  /*
  useAuth hook is called to retrieve the token value from the authentication context
  */
  const { token } = useAuth();

  // Check if the user has specific roles based on the decoded token
  const userRoles = token ? jwtDecode(token).authorities : [];
  
  //All public routes that will be shown to all users
  const routesForPublic =createRoutesFromElements(
    <Route id="public" path="/" element={<Dashboard />}>
        <Route path="/" element={<Home />}></Route>
        <Route path="/home" element={<Home />}></Route>
        <Route path="/contact-us" element={<ContactUs />}></Route>
        <Route path="/about-us" element={<AboutUs />}></Route>
        <Route path="/signup" element={<Register/>}></Route>
        <Route path="/signin" element={<LogIn/>}></Route>
      </Route>
  );


  //All routes that are for admin only
  const routesForAdminOnly= createRoutesFromElements(
    <Route id="123" path="/" element={<ProtectedRoute/>}>
      <Route id="admin" path="/admin" element={<div><br/><br/><br/><h1>Hello ADMIn</h1></div>}></Route>
    </Route>
  )

  //All routes that are for Hr Only
  const routesForHROnly= createRoutesFromElements(
    <Route id="456" path="/" element={<ProtectedRoute/>}>
      <Route id="hr" path="/hr" element={<div><br/><br/><br/><h1>Hello HR</h1></div>}></Route>
    </Route>
  )

  //In this route we will show that use is un authorized for
  // particular page
  const routeForNotAuthorized= createRoutesFromElements(
    <Route id="err" path="*" element={<ProtectedRoute/>}>
      <Route id="errorpage" path="*" element={<><br/><br/><br/><br/><h1>You are not supposed to view this page</h1></>}></Route>
    </Route>
  )
  
  const router = createBrowserRouter([
    /*All public routes*/
    ...routesForPublic,
    /*IF the user is logged in as a HR else unauthorized*/
    ...(userRoles==='ROLE_HR'?routesForHROnly:routeForNotAuthorized),
    /*IF the user is logged in as a ADMIN else unauthorized*/
    ...(userRoles==='ROLE_ADMIN'?routesForAdminOnly:routeForNotAuthorized),
    !token && <Navigate to="/signin"></Navigate>
  ]);
  return <RouterProvider router={router} />;
}

export default Routes;
