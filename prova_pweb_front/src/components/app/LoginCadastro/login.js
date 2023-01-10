import { onAuthStateChanged, signInWithEmailAndPassword } from 'firebase/auth'
import React, { useEffect, useState } from 'react'
import { redirect, useNavigate } from 'react-router-dom'
import userIcon from '../../../assets/user.png'
import auth from '../../../fireBaseConnection'
import './app.css'

export default function Login() {

  const [email, setEmail] = useState('')
  const [senha, setSenha] = useState('')
  const [user, setUser] = useState(false)
  const [logedUser, setLogedUser] = useState({})
  const navigate = useNavigate()

  useEffect(()=>{
    async function checkLogin(){
      onAuthStateChanged(auth,(user)=>{
        if(user){
          setUser(true)
          console.log(user.email)
          setLogedUser({
            uid:user.uid,
            email:user.email
          })
          navigate("/configuracoes")
        }
        else{
          setUser(false)
          setLogedUser({})
        }
      })
    }
    checkLogin()
  },[])

    //firebase para fazer a autenticação do login
    async function login(){
      await signInWithEmailAndPassword(auth, email, senha).then((value)=>{
        console.log(value)
        alert(value)
      }).catch((error)=>{
        alert("Login/Senha incorretos")
        console.log(error)
      })
    }

  return (
    <div className='centro'>
        <div className='centro-icone'>
            <img alt='usuario-icone' src={userIcon} className='icone'/>
        </div>
        <div className='formulario'>
            <h1>Entrar</h1>
            <input type='text' placeholder='email@example.com' value={email} onChange={(e)=>{setEmail(e.target.value)}}/>
            <input type='password' placeholder='******' value={senha} onChange={(e)=>{setSenha(e.target.value)}}/>
            <button onClick={()=>{login()}}>Acessar</button>
            <p>Ainda não tem uma conta? <a href="http://localhost:3000/cadastro">Crie aqui</a></p>
        </div>

        {user && (
          <div>
            <strong>Seja Bem-Vindo!</strong>
            <span>{logedUser.uid} - {logedUser.email}</span>
          </div>
        )}
        
    </div>
  )
}
