import React from 'react'
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'
import Cadastro from './Pages/Cadastro'
import Home from './Pages/Home/'
import AreaUsuario from './Pages/AreaUsuario'
import AreaClientes from './Pages/AreaClientes'


export default function App() {
  return (
    <Router>
        <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/cadastro" element={<Cadastro />} />
            <Route path="/configuracoes" element={<AreaUsuario />} />
            <Route path="/clientes" element={<AreaClientes />} />
        </Routes>
    </Router>
  )
}
