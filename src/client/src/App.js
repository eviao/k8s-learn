import React from 'react';
import { Routes, Route } from 'react-router-dom';
import { Home } from './features/home/Home';
import { Register } from './features/user/Register';
import { Login } from './features/session/Login';
import './mvp.css';
import './App.css';

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/session/login" element={<Login />} />
        <Route path="/user/register" element={<Register />} />
      </Routes>
    </>
  );
}

export default App;
