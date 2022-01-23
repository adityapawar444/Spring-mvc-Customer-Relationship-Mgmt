
import React from "react";

import Header from "./components/Header";
import Footer from "./components/Footer";
import "./App.css";

import CustomerList from "./components/CustomersList";

function App() {
  return (
    <div>
      <Header />
      <div className="container">
        <CustomerList />
      </div>
      <Footer />
    </div>
  );
}

export default App;

