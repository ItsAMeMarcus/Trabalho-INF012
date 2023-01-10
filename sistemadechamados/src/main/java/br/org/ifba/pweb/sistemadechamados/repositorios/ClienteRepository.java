package br.org.ifba.pweb.sistemadechamados.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.ifba.pweb.sistemadechamados.entidades.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	public List<Cliente> findByNomeContaining(String nome);
	
}
