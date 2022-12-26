import React from 'react'
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'
import Cadastro from './Pages/Cadastro'
import Home from './Pages/Home/'
import './components/app/app.css'
import Perfil from './Pages/Perfil'


export default function App() {
  return (
    <Router>
        <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/cadastro" element={<Cadastro />} />
            <Route path="/perfil" element={<Perfil />} />
        </Routes>
    </Router>
  )
}
