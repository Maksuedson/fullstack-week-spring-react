package br.com.maksuedson.fullstackweek.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.maksuedson.fullstackweek.domain.GruposPrioridades;
import br.com.maksuedson.fullstackweek.repository.GruposPrioridadesRepository;

@RestController
@RequestMapping (path = "/grupos")
public class GruposPrioridadesResource {
	
	@Autowired
	private GruposPrioridadesRepository repo;
	
	@GetMapping
	public List<GruposPrioridades> listarTodos(){
		return repo.findAll();
	}
	
	@PostMapping
	public GruposPrioridades salvar(@RequestBody GruposPrioridades obj) {
		return repo.save(obj);
	}
	
	@GetMapping (path = "{codigo}")
	public GruposPrioridades buscarPorCodigo(@PathVariable ("codigo") Long codigo) {
		return repo.findById(codigo).orElse(null);		
	}
	
	@RequestMapping (path = "{codigo}")
	public GruposPrioridades alterar(@PathVariable ("codigo") Long codigo, 
			@RequestBody GruposPrioridades obj) {
		 repo.findById(codigo).orElse(null);
		 return repo.save(obj);
	}
	
	@DeleteMapping (path = "{codigo}")
	public void deletar(@PathVariable ("codigo") Long codigo) {
		repo.deleteById(codigo);
	}

}
