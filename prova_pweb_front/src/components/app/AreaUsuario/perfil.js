import { signOut } from 'firebase/auth'
import React from 'react'
import { useNavigate } from 'react-router-dom'
import auth from '../../../fireBaseConnection'
import './menu.css'

export default function MeuPerfil() {

  const navigate = useNavigate()

  async function logout(){
    await signOut(auth).then(()=>{
      alert("usuário desconectado")
      navigate("/")
    }).catch((erro)=>{
      console.log(erro)
      alert("Algo deu errado :/")
    })
  }

  return (
    <div>
      <h1>Deu certo! Seja Bem-Vindo!!</h1>
      <button onClick={()=>{logout()}}>Logout</button>
    </div>
  )
}
