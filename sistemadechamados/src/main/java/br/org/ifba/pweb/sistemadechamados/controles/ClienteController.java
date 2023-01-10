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

import br.org.ifba.pweb.sistemadechamados.dtos.ClienteDto;
import br.org.ifba.pweb.sistemadechamados.entidades.Cliente;
import br.org.ifba.pweb.sistemadechamados.repositorios.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping
	public List<ClienteDto> listar() {
		List<Cliente> lista = clienteRepository.findAll(); 
		return lista.stream().map(ClienteDto::new).collect(Collectors.toList());
	}
	
	@GetMapping("list/{id}") 
	public ResponseEntity<?> listarClientePorId(@PathVariable String id){ 
		try {
			Long meuId = Long.parseLong(id);
			Optional<Cliente> cliente = clienteRepository.findById(meuId);
			if (cliente.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			ClienteDto ct = new ClienteDto(cliente.get());
			List<ClienteDto> lista = new ArrayList<ClienteDto>();
			lista.add(ct);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			List<Cliente> lista2 = clienteRepository.findByNomeContaining(id);
			return new ResponseEntity<>(lista2.stream().map(ClienteDto::new).collect(Collectors.toList()), HttpStatus.OK);
		}
	}
	 
	@GetMapping("list/{nome}")
	public List<Cliente> listarClientePorNome(@PathVariable String nome){
		return clienteRepository.findByNomeContaining(nome); 
	}
	
	@PostMapping
	public ResponseEntity<ClienteDto> cadastrar(@RequestBody ClienteDto clienteDto, UriComponentsBuilder uriBuilder) {
		Cliente cliente = new Cliente();
		cliente.setNome(clienteDto.getNome());
		cliente.setCnpj(clienteDto.getCnpj());
		cliente.setEndereco(clienteDto.getEndereco());
		clienteRepository.save(cliente);
		
		URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDto(cliente));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarPorId(@PathVariable Long id, @RequestBody ClienteDto clienteDto) {
		
		Optional<Cliente> optional = clienteRepository.findById(id);
		if (optional.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Cliente cliente = optional.get();
		cliente.setNome(clienteDto.getNome());
		cliente.setCnpj(clienteDto.getCnpj());
		cliente.setEndereco(clienteDto.getEndereco());
		
		clienteRepository.save(cliente);
		
		return new ResponseEntity<>(new ClienteDto(cliente), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletarPorId(@PathVariable Long id){
		
		Optional<Cliente> optional = clienteRepository.findById(id); 
		
		if (optional.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Cliente cliente = optional.get();
		ResponseEntity<?> entity= new ResponseEntity<>(new ClienteDto(cliente), HttpStatus.OK);
		
		clienteRepository.deleteById(id);
		return entity;
	}
}
