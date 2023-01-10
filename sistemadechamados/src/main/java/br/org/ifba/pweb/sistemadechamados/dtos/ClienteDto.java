package br.org.ifba.pweb.sistemadechamados.dtos;

import br.org.ifba.pweb.sistemadechamados.entidades.Cliente;
import jakarta.validation.constraints.NotBlank;

public class ClienteDto {
	
	private Long id;
	
	@NotBlank(message = "O campo não pode estar em branco")
	private String nome;
	
	@NotBlank(message = "O campo não pode estar em branco")
	private String cnpj;
	
	@NotBlank(message = "O campo não pode estar em branco")
	private String endereco;
	
	public ClienteDto() {
		
	}
	
	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.cnpj = cliente.getCnpj();
		this.endereco = cliente.getEndereco();
	}

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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
