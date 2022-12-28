import React from 'react'
import { Link } from 'react-router-dom'
import casaIcon from '../../../assets/casaIcon.png'
import clientesIcon from '../../../assets/clientesIcon.png'
import configuracaoIcon from '../../../assets/configuracaoIcon.png'
import './menu.css'

export default function MenuLateral() {

  //fetch com axios as informações e monitora com useEffect

  return (
    <div className='menuLateral'>
      <div className='imagemPerfil'>
        <img alt='fotoPerfil'/>
      </div>
        <Link to="/chamados" className='li'><img src={casaIcon} alt='chamados' className='casa'/>Chamados</Link>
        <Link to="/clientes" className='li'><img src={clientesIcon} alt='chamados' className='clientes'/>Clientes</Link>
        <Link to="/configuracoes" className='li'><img src={configuracaoIcon} alt='chamados' className='configuracoes'/>Configurações</Link>
    </div>
  )
}
