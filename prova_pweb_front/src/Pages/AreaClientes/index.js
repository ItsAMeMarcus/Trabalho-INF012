import React from 'react'
import MeuClientes from '../../components/app/AreaClientes/clientes'
import MenuLateral from '../../components/app/AreaUsuario/menuLateral'

export default function AreaClientes() {
  return (
    <div className='main'>
        <MenuLateral />
        <MeuClientes url="http://localhost:8080" />
    </div>
  )
}
