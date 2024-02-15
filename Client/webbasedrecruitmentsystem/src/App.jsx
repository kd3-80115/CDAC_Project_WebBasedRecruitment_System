import AuthProvider from "./services/authprovider";
import Routes from "./routes/Router";
function App() {
  return (
    <AuthProvider>
      <Routes />
    </AuthProvider>
  );
}

export default App;
