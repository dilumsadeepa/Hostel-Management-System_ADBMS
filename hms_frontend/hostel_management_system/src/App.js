import { BrowserRouter, Routes, Route } from "react-router-dom";
import AdminHome from "./components/Admin/AdminHome";
import AdminEmptyContent from "./components/Admin/AdminEmptyContent";
import PageNotFound from "./components/Common/PageNotFound";
import Report from "./components/Common/Report";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<AdminHome/>} />
          <Route path="/adminempty" element={<AdminEmptyContent/>} />
          <Route path="*" element={<PageNotFound/>} />
          <Route path="reports" element={<Report/>} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
