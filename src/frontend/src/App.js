import { BrowserRouter, Routes, Route } from "react-router-dom";
import Header from "./component/Header/Header";
import Sidebar from "./component/Sidebar/Sidebar";
import CustomerPage from "./pages/CustomerPages/CustomerPage";
import NewCustomer from "./pages/CustomerPages/NewCustomer";
import HomePages from "./pages/HomePages/HomePages";
import LoanResultListPage from "./pages/LoanResultListPage/LoanResultListPage";
function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Header />
        <Sidebar />
        <div class="main-container" id="container">
          <div class="overlay"></div>
          <div class="search-overlay"></div>
          <Routes>
            <Route exact path="/" element={<HomePages />}></Route>
            <Route exact path="/loan-result" element={<LoanResultListPage />}></Route>
            <Route exact path="/customers" element={<CustomerPage />}></Route>
            <Route exact path="/customers/register" element={<NewCustomer />}></Route>
          </Routes>
        </div>
      </BrowserRouter>
    </div>
  );
}

export default App;
