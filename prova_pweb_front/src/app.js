import React from 'react'
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'
import Cadastro from './Pages/Cadastro'
import Home from './Pages/Home/'
import AreaUsuario from './Pages/AreaUsuario'


export default function App() {
  return (
    <Router>
        <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/cadastro" element={<Cadastro />} />
            <Route path="/chamados" element={<AreaUsuario />} />
        </Routes>
    </Router>
  )
}
