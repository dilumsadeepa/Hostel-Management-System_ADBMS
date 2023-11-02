import { BrowserRouter, Routes, Route } from "react-router-dom";
import AdminHome from "./components/Admin/AdminHome";
import AdminEmptyContent from "./components/Admin/AdminEmptyContent";
import PageNotFound from "./components/Common/PageNotFound";
<<<<<<< Updated upstream
=======
import Login from "./components/User/Login";
import Register from "./components/User/Register";
import Complaint from "./components/Admin/Complaint";
>>>>>>> Stashed changes

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<AdminHome/>} />
          <Route path="/adminempty" element={<AdminEmptyContent/>} />
          <Route path="*" element={<PageNotFound/>} />
<<<<<<< Updated upstream
=======
          <Route path="/complaints" element={<Complaint/>} />

>>>>>>> Stashed changes
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
