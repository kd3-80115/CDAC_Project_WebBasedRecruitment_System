import {
  createRoutesFromElements,
  createBrowserRouter,
  Route,
  RouterProvider,
  Navigate,
} from "react-router-dom";
import AdminDashboard from "../components/Admin/AdminDashboard"
import { useAuth } from "../services/authprovider";
import { ProtectedRoute } from "./ProtectedRoute";
import Dashboard from "../components/Dashboard";
import ContactUs from "../components/common/ContactUs/ContatctUs";
import AboutUs from "../components/common/AboutUs/About";
import Home from "../components/common/Home/Home";
import Register from "../components/auth/Register";
import LogIn from "../components/auth/Login";
import { jwtDecode } from "jwt-decode";

const Routes = () => {
  /*
  useAuth hook is called to retrieve the token value from the authentication context
  */
  const { token } = useAuth();

  // Check if the user has specific roles based on the decoded token
  const userRoles = token ? jwtDecode(token).authorities : [];

  //All public routes that will be shown to all users
  const routesForPublic =createRoutesFromElements(
    <Route key  ="public" path="/" element={<Dashboard />}>
        <Route id="public1" path="/" element={<Home />}></Route>
        <Route id="public2" path="/home" element={<Home />}></Route>
        <Route id="public3" path="/contact-us" element={<ContactUs />}></Route>
        <Route id="public4" path="/about-us" element={<AboutUs />}></Route>
        <Route id="public5" path="/signup" element={<Register/>}></Route>
        <Route id="public6" path="/signin" element={<LogIn/>}></Route>
      </Route>
  );

  //All routes that are for admin only
  const routesForAdminOnly= createRoutesFromElements(
    <Route id="admin1" path="/" element={<ProtectedRoute/>}>
      <Route id="admin2" path="/admin" element={<AdminDashboard/>}></Route>
    </Route>
  );

  //All routes that are for Hr Only
  const routesForHROnly= createRoutesFromElements(
    <Route id="hr1" path="/" element={<ProtectedRoute/>}>
      <Route id="hr2" path="/hr" element={<div><br/><br/><br/><h1>Hello HR</h1></div>}></Route>
    </Route>
  );

  const routesForApplicant=createRoutesFromElements(
    <Route id="applicant" path="/" element={<ProtectedRoute/>}>
      {/*Add your applicant component here element={<Applicant/>}*/}
      <Route id="applicant1" path="/applicant" element></Route>
      <Route id="applicant2" path="/profile" element></Route>
      <Route id="applicant3" path="/jobs" element></Route>
      <Route id="applicant4" path="/applied-jobs" element></Route>
      <Route id="applicant5" path="/saved-jobs" element></Route>
    </Route>
  );


  //In this route we will show that use is un authorized for
  // particular page
  const routeForNotAuthorizedHR= createRoutesFromElements(
    <Route id="hrUnauth" path="*" element={<ProtectedRoute/>}>
      <Route id="hrUnauth1" path="*" element={<><br/><br/><br/><br/><h1>You are not supposed to view this page</h1></>}></Route>
    </Route>
  )
  const routeForNotAuthorizedAdmin= createRoutesFromElements(
    <Route id="adminUnAuth" path="*" element={<ProtectedRoute/>}>
      <Route id="adminUnAuth1" path="*" element={<><br/><br/><br/><br/><h1>You are not supposed to view this page</h1></>}></Route>
    </Route>
  )
  const router = createBrowserRouter([
    /*All public routes*/
    ...routesForPublic,
    /*IF the user is logged in as a HR else unauthorized*/
    ...(userRoles.includes('ROLE_HR') ? routesForHROnly : routeForNotAuthorizedHR),
    /*IF the user is logged in as a ADMIN else unauthorized*/
    ...(userRoles.includes('ROLE_ADMIN') ? routesForAdminOnly : routeForNotAuthorizedAdmin),
    !token && <Navigate to="/signin"></Navigate>
  ]);
  return <RouterProvider router={router} />;
};

export default Routes;
