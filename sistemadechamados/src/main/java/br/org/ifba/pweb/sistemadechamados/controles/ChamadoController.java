package br.org.ifba.pweb.sistemadechamados.controles;

import java.net.URI;
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

import br.org.ifba.pweb.sistemadechamados.dtos.ChamadoDto;
import br.org.ifba.pweb.sistemadechamados.entidades.Chamado;
import br.org.ifba.pweb.sistemadechamados.repositorios.ChamadoRepository;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {
	
	@Autowired
	ChamadoRepository chamadoRepository;
	
	@GetMapping
	public List<ChamadoDto> listar() {
		List<Chamado> lista = chamadoRepository.findAll(); 
		return lista.stream().map(ChamadoDto::new).collect(Collectors.toList());
	}
	
	@PostMapping
	public ResponseEntity<ChamadoDto> cadastrar(@RequestBody ChamadoDto chamadoDto, UriComponentsBuilder uriBuilder) {
		Chamado chamado = new Chamado();
		chamado.setCliente(chamadoDto.getCliente());
		chamado.setAssunto(chamadoDto.getAssunto());
		chamado.setStatus(chamadoDto.getStatus());
		chamado.setDataCadastro(chamadoDto.getDataCadastro());
		chamadoRepository.save(chamado);
		
		URI uri = uriBuilder.path("/chamados/{id}").buildAndExpand(chamado.getId()).toUri();
		return ResponseEntity.created(uri).body(new ChamadoDto(chamado));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarPorId(@PathVariable Long id, @RequestBody ChamadoDto chamadoDto) {
		
		Optional<Chamado> optional = chamadoRepository.findById(id);
		if (optional.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Chamado chamado = optional.get();
		chamado.setCliente(chamadoDto.getCliente());
		chamado.setAssunto(chamadoDto.getAssunto());
		chamado.setStatus(chamadoDto.getStatus());
			
		chamadoRepository.save(chamado);
		
		return new ResponseEntity<>(new ChamadoDto(chamado), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarPorId(@PathVariable Long id){
		
		Optional<Chamado> optional = chamadoRepository.findById(id); 
		
		if (optional.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Chamado chamado = optional.get();
		ResponseEntity<?> entity= new ResponseEntity<>(new ChamadoDto(chamado), HttpStatus.OK);
		
		chamadoRepository.deleteById(id);
		return entity;
	}
	
}
