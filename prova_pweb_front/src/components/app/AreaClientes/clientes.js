import { onAuthStateChanged } from 'firebase/auth'
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import auth from '../../../fireBaseConnection'
import axios from 'axios'
import icon from '../../../assets/clientesIcon.png'


export default function MeuClientes(props) {
  const urlBack = props.url
  const navigate = useNavigate()
  const [nome, setNome] = useState("")
  const [CNPJ, setCNPJ] = useState("")
  const [endereco, setEndereco] = useState("")

  function post(){
    axios.post(urlBack + "/clientes", {nome:nome, cnpj: CNPJ, endereco:endereco}).then(res=>{
      console.log(res)
      console.log(res.data)
    }).catch((e)=>console.log(e.message))

    alert("Cliente Cadastrado com Sucesso")
    navigate("/configuracoes")

  }

  useEffect(()=>{
    async function checkLogin(){
      onAuthStateChanged(auth,(user)=>{
        if(user){
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
        <h1><img src={icon} alt="meu perfil" className='clientes'/>Clientes</h1>
      </div>
      <div className='conteudo'>
      <p>Nome </p>
      <input type='text' placeholder='seu nome' value={nome} onChange={(e)=>{setNome(e.target.value)}}/>
      <p>CNPJ </p>
      <input type='text' placeholder='CNPJ' value={CNPJ} onChange={(e)=>{setCNPJ(e.target.value)}}/>
      <p>Endereço </p>
      <input type='text' placeholder='Endereço' value={endereco} onChange={(e)=>{setEndereco(e.target.value)}}/>
      <button className='salvar' onClick={()=>{post()}}>Salvar</button>
      </div>
      <div>
      </div>
    </div>
  )
}
