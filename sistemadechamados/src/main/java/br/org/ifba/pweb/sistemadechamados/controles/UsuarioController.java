package br.org.ifba.pweb.sistemadechamados.controles;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.org.ifba.pweb.sistemadechamados.dtos.UsuarioDto;
import br.org.ifba.pweb.sistemadechamados.entidades.Usuario;
import br.org.ifba.pweb.sistemadechamados.repositorios.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<UsuarioDto> listar() {
		List<Usuario> lista = usuarioRepository.findAll(); 
		return lista.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}
	
	@GetMapping("/list/{id}")
	public ResponseEntity<?> listarPorId(@PathVariable String id) {
		try {
			Optional<Usuario> usuario = usuarioRepository.findBySenha(id);
			if (usuario.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(usuario, HttpStatus.OK);
		} catch (Exception e) {
			List<Usuario> lista2 = usuarioRepository.findByNomeContaining(id);
			return new ResponseEntity<>(lista2.stream().map(UsuarioDto::new).collect(Collectors.toList()), HttpStatus.OK);
		}
	}
	
//	@GetMapping("/list/{nome}")
//	public List<Usuario> listarPorNome(@PathVariable String nome){
//		return usuarioRepository.findByNomeContaining(nome); 
//	}
	
	@PostMapping
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody UsuarioDto usuarioDto, UriComponentsBuilder uriBuilder) {
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioDto.getNome());
		usuario.setEmail(usuarioDto.getEmail());
//		usuario.setUserId(usuarioDto.getUserId());
		usuario.setSenha(usuarioDto.getSenha());
		usuarioRepository.save(usuario);
		
		URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarPorId(@PathVariable String id, @RequestBody UsuarioDto usuarioDto) {
		
		Optional<Usuario> optional = usuarioRepository.findBySenha(id);
		if (optional.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Usuario usuario = optional.get();
		usuario.setNome(usuarioDto.getNome());
		usuario.setEmail(usuarioDto.getEmail());
//		usuario.setUserId(usuarioDto.getUserId());
		usuario.setSenha(usuarioDto.getSenha());
			
		usuarioRepository.save(usuario);
		
		return new ResponseEntity<>(new UsuarioDto(usuario), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletarPorId(@PathVariable Long id){
		
		Optional<Usuario> optional = usuarioRepository.findById(id); 
		
		if (optional.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Usuario usuario = optional.get();
		ResponseEntity<?> entity= new ResponseEntity<>(new UsuarioDto(usuario), HttpStatus.OK);
		
		usuarioRepository.deleteById(id);
		return entity;
	}
}