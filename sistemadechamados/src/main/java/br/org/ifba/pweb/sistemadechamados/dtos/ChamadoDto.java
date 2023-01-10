package br.org.ifba.pweb.sistemadechamados.dtos;

import java.time.LocalDate;

import br.org.ifba.pweb.sistemadechamados.entidades.Chamado;
import br.org.ifba.pweb.sistemadechamados.entidades.Cliente;
import br.org.ifba.pweb.sistemadechamados.entidades.Status;
import jakarta.validation.constraints.NotBlank;

public class ChamadoDto {
	
	private Long id;
	
	@NotBlank(message = "O campo não pode estar em branco")
	private Cliente cliente;
	
	@NotBlank(message = "O campo não pode estar em branco")
	private String assunto;
	
	private Status status;
	
	@NotBlank(message = "O campo não pode estar em branco")
	private LocalDate dataCadastro;
	
	public ChamadoDto() {
		
	}
	
	public ChamadoDto(Chamado chamado) {
		this.id = chamado.getId();
		this.cliente = chamado.getCliente();
		this.assunto = chamado.getAssunto();
		this.status = chamado.getStatus();
		this.dataCadastro = chamado.getDataCadastro();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}
