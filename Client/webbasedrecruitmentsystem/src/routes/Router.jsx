import {
  createRoutesFromElements,
  createBrowserRouter,
  Route,
} from "react-router-dom";

import Dashboard from "../components/Dashboard";
import ContactUs from "../components/common/ContactUs/ContatctUs";
import AboutUs from "../components/common/AboutUs/About";
import Home from "../components/common/Home/Home";
import Register from "../components/auth/Register";
import ApplicantWelcomePage from "../components/applicant/ApplicantWelcomePage/ApplicantWelcomePage";

const router = createBrowserRouter(
  createRoutesFromElements(
    <Route path="/" element={<Dashboard />}>
      <Route path="/" element={<Home />}></Route>
      <Route path="/home" element={<Home />}></Route>
      <Route path="/contact-us" element={<ContactUs />}></Route>
      <Route path="/about-us" element={<AboutUs />}></Route>
      <Route path="/register" element={<Register />}></Route>
      <Route path="/applicant" element={<ApplicantWelcomePage />}></Route>
    </Route>
  )
);
export default router;
