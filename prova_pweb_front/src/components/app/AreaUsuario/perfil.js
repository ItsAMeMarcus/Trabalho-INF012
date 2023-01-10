import { onAuthStateChanged, signInWithCredential, signOut, updateEmail } from 'firebase/auth'
import React, { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import auth from '../../../fireBaseConnection'
import './menu.css'
import icon from '../../../assets/configuracaoIcon.png'
import axios from 'axios'

export default function MeuPerfil(props) {

  const navigate = useNavigate()
  const [nome, setNome] = useState("")
  const [senha, setSenha] = useState("")
  const [email, setEmail] = useState("")

  async function logout(){
    await signOut(auth).then(()=>{
      alert("usuário desconectado")
      navigate("/")
    }).catch((erro)=>{
      console.log(erro)
      alert("Algo deu errado :/")
    })
  }

  function update(){
    axios.put(props.url + `/usuarios/${senha}`,{nome: nome, email:email, senha: senha}).then(res=>{
      }).then(()=>{
        updateEmail(auth.currentUser,email).then(()=>{
      alert("Seus dados foram atualizados")
    }).catch((e)=>{
        alert("Erro axios:" + e.message)
      })
      }).catch((e)=>{
      alert("Erro: " + e.message)
    })

    
  }

  useEffect(()=>{
    async function checkLogin(){
      onAuthStateChanged(auth,(user)=>{
        if(user){
          axios.get(props.url + `/usuarios/list/${user.uid}`).then(res=>{
            setNome(res.data.nome)
            setEmail(res.data.email)
            setSenha(res.data.senha)
          })
          
        }
        else{
          navigate("/login")
        }
      })
    }
    checkLogin()
  },[])

  return (
    <div>
      <div className='nomeTela'>
        <h1><img src={icon} alt="meu perfil" className='configuracoes'/>Meu Perfil</h1>
      </div>
      <div className='conteudo'>
      <p>Nome </p>
      <input type='text' placeholder='seu nome' value={nome} onChange={(e)=>{setNome(e.target.value)}}/>
      <p>Email</p>
      <input type='text' placeholder='email@example.com' value={email} onChange={(e)=>{setEmail(e.target.value)}}/>
      <button className='salvar' onClick={()=>{update()}}>Salvar</button>
      </div>
      <div>
        <button className='logout' onClick={()=>{logout()}}>Logout</button>
      </div>
    </div>
  )
}
