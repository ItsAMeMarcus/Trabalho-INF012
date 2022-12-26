import React, { useState } from 'react'
import user from '../../assets/user.png'

export default function NovaConta() {

    const [nome, setNome] = useState('')
    const [email, setEmail] = useState('')
    const [senha, setSenha] = useState('')

  return (
    <div className='centro'>
        <div className='centro-icone'>
            <img alt='usuario-icone' src={user} className='icone'/>
        </div>
        <div className='formulario'>
            <h1>Novo Usuário</h1>
            <input type='text' placeholder='Seu Nome' value={nome} onChange={(e)=>{setNome(e.target.value)}}/>
            <input type='text' placeholder='email@example.com' value={email} onChange={(e)=>{setEmail(e.target.value)}}/>
            <input type='text' placeholder='******' value={senha} onChange={(e)=>{setSenha(e.target.value)}}/>
            <button >Acessar</button>
            <p>Já tem uma conta? <a href="http://localhost:3000">Clique aqui</a></p>
        </div>
    </div>
  )
}
