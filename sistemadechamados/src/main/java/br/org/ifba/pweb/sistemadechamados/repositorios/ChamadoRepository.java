package br.org.ifba.pweb.sistemadechamados.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.ifba.pweb.sistemadechamados.entidades.Chamado;
import br.org.ifba.pweb.sistemadechamados.entidades.Status;

public interface ChamadoRepository extends JpaRepository<Chamado, Long>{
	
	public List<Chamado> findByAssunto(String assunto);
	public List<Chamado> findByStatus(Status status);
	public Optional<Chamado> findById(Long id);
	
}
