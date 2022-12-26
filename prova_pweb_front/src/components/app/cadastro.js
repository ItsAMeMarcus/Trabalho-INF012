import React, { useState } from 'react'
import user from '../../assets/user.png'
import {createUserWithEmailAndPassword} from "firebase/auth";
import auth from '../../fireBaseConnection';
import { Link, redirect } from 'react-router-dom';
import Home from '../../Pages/Home';

export default function NovaConta() {

    const [nome, setNome] = useState('')
    const [email, setEmail] = useState('')
    const [senha, setSenha] = useState('')

    async function novoUsuario(){
      await createUserWithEmailAndPassword(auth, email, senha).then((value)=>{
        console.log(value)
        console.log(value.user)
        
      }).catch((error)=>{
        console.log(error)
        if(error.code==='auth/weak-password'){
          alert('Senha Fraca')
        }
        else if(error.code==='auth/email-already-in-use'){
          alert('Email já em uso')
        }
      })
    }

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
            <button onClick={()=>{novoUsuario()}}>Acessar</button>
            <p>Já tem uma conta? <a href="http://localhost:3000">Clique aqui</a></p>
        </div>
    </div>
  )
}
