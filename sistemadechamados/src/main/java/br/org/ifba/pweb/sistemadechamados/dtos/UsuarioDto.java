package br.org.ifba.pweb.sistemadechamados.dtos;

import br.org.ifba.pweb.sistemadechamados.entidades.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UsuarioDto {
	
	private Long id;
	
	@NotBlank(message = "O campo não pode estar em branco")
	private String nome;
	
	@Email
	private String email;
	//mudar pra userId
	@NotBlank(message = "O campo não pode estar em branco")
	private String senha;
	
	
	@NotBlank(message = "O campo não pode estar em branco")
	private String userId;
	
	//foto perfil
	


	public UsuarioDto() {
			
	}
	
	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
//		this.userId = usuario.getUserId();
		//foto perfil
	}
	
//	public String getUserId() {
//		return userId;
//	}
//
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
