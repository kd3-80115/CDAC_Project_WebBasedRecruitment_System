import AuthProvider from "./services/authprovider";
import Routes from "./routes/Router";
import { BrowserRouter } from "react-router-dom";
import "react-toastify/dist/ReactToastify.css";
function App() {
  return (
      <AuthProvider>
          <Routes />
        </AuthProvider>
  );
}

export default App;
