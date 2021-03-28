package br.com.maksuedson.fullstackweek.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.maksuedson.fullstackweek.domain.Pessoa;
import br.com.maksuedson.fullstackweek.repository.PessoaRepository;

@RestController
@RequestMapping (path = "/pessoas")
@CrossOrigin(origins = { "http://localhost:3000"})
public class PessoaResource {
	
	@Autowired
	private PessoaRepository repo;
	
	@GetMapping
	public List<Pessoa> listarTodos(){		
		return repo.findAll();		
	}
	
	@PostMapping
	public Pessoa cadastrarPessoa(@RequestBody Pessoa obj) {		
		return repo.save(obj);		
	}
	
//	@PutMapping( path = ("{codigo}"))
//	public ResponseEntity<Pessoa> atualizar(@PathVariable ("codigo") Long codigo, 
//			@RequestBody Pessoa pessoa) {
//		return repo.findById(codigo).map(
//				record -> {
//					record.setCpf(pessoa.getCpf());
//					record.setDataNascimento(pessoa.getDataNascimento());
//					record.setEmail(pessoa.getEmail());
//					record.setIdade(pessoa.getIdade());
//					record.setNome(pessoa.getNome());
//					record.setTelefone(pessoa.getTelefone());
//					Pessoa pessoaAtualizada = repo.save(pessoa);
//					return ResponseEntity.ok().body(pessoaAtualizada);
//				}).orElse(ResponseEntity.notFound().build());
//	}
	
//	@PutMapping( path = ("{codigo}"))
//	public Pessoa atualizar(@PathVariable ("codigo") Long codigo, 
//			@RequestBody Pessoa pessoa) {
//		return repo.findById(codigo).map(
//				record -> {
//					record.setCpf(pessoa.getCpf());
//					record.setDataNascimento(pessoa.getDataNascimento());
//					record.setEmail(pessoa.getEmail());
//					record.setIdade(pessoa.getIdade());
//					record.setNome(pessoa.getNome());
//					record.setTelefone(pessoa.getTelefone());
//					return repo.save(pessoa);
//				}).orElse(null);
//	}
	
	@PutMapping (path = "{codigo}")
	public Pessoa atualizar(@PathVariable ("codigo") Long codigo, @RequestBody Pessoa pessoa) {
		repo.findById(codigo);
		return repo.save(pessoa);		
	}
	
	@GetMapping ( path = ("{codigo}"))
	public Pessoa buscarPorCodigo(@PathVariable ("codigo") Long codigo) {
		return repo.findById(codigo).orElse(null);
	}
	
	@DeleteMapping ( path = ("{codigo}"))
	public void deletarPorCodigo(@PathVariable ("codigo") Long codigo) {
		repo.deleteById(codigo);
	}

}
