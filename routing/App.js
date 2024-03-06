import React from "react";
import { BrowserRouter } from "react-router-dom";
import { Routes } from "react-router-dom";
import { Route } from "react-router-dom";
import Index from "./pages/Index";
import Login from "./pages/Login";
import Registration from "./pages/Registration";

function App() {
  return (
  <BrowserRouter>
  <div>
    <Routes>
      <Route path="/" element={<Index />}></Route>
      <Route path="/login" element={<Login />}></Route>
      <Route path="/registration" element={<Registration />}></Route>
    </Routes>
    </div>
  </BrowserRouter>
  );
}

export default App;
