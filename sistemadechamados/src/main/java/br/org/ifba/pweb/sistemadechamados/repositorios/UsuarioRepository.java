package br.org.ifba.pweb.sistemadechamados.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.ifba.pweb.sistemadechamados.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public List<Usuario> findByNomeContaining(String nome);
	public Optional<Usuario> findById(Long id);
	public Optional<Usuario> findBySenha(String senha);
	
}
