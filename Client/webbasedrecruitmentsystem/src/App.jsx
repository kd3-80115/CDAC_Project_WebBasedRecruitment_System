import AuthProvider from "./services/authprovider";
import Routes from "./routes/Router";
import { BrowserRouter } from "react-router-dom";
function App() {
  return (
      <AuthProvider>
        <Routes />
      </AuthProvider>
  );
}

export default App;
