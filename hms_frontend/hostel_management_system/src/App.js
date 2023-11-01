import { BrowserRouter, Routes, Route } from "react-router-dom";
import AdminHome from "./components/Admin/AdminHome";
import AdminEmptyContent from "./components/Admin/AdminEmptyContent";
import PageNotFound from "./components/Common/PageNotFound";
import Login from "./components/User/Login";
import Register from "./components/User/Register";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<AdminHome/>} />
          <Route path="/adminempty" element={<AdminEmptyContent/>} />
          <Route path="/login" element={<Login/>} />
          <Route path="/register" element={<Register/>} />
          <Route path="*" element={<PageNotFound/>} />

        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
