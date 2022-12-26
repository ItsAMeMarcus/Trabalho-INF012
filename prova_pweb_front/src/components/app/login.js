import React, { useState } from 'react'
import user from '../../assets/user.png'

export default function Login() {

  const [email, setEmail] = useState('')
  const [senha, setSenha] = useState('')

    //firebase para fazer a autenticação do login

  return (
    <div className='centro'>
        <div className='centro-icone'>
            <img alt='usuario-icone' src={user} className='icone'/>
        </div>
        <div className='formulario'>
            <h1>Entrar</h1>
            <input type='text' placeholder='email@example.com' value={email} onChange={(e)=>{setEmail(e.target.value)}}/>
            <input type='text' placeholder='******' value={senha} onChange={(e)=>{setSenha(e.target.value)}}/>
            <button >Acessar</button>
            <p>Ainda não tem uma conta? <a href="http://localhost:3000/cadastro">Crie aqui</a></p>
        </div>
    </div>
  )
}
