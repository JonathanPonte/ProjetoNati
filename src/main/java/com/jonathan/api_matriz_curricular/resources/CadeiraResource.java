package com.jonathan.api_matriz_curricular.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonathan.api_matriz_curricular.models.Cadeira;
import com.jonathan.api_matriz_curricular.repository.CadeiraRepository;

@RestController
@RequestMapping(value="/api")
public class CadeiraResource {

	@Autowired
	CadeiraRepository cadeiraRepository;
	

	
	@GetMapping("/cadeira")
	public List<Cadeira> listarCadeiras(){
		return cadeiraRepository.findAll();
	}
	
	
	@PostMapping("/cadeira")
	public Cadeira novacadeira(@RequestBody Cadeira cadeira) {
		return cadeiraRepository.save(cadeira);
	}
		

	
	@DeleteMapping("/cadeira/{id}")
	public void deleteCurso(@PathVariable int id) {
		cadeiraRepository.deleteById(id);
	}
	
	
	@PutMapping("/cadeira/{id}")
	public Cadeira atualizaCurso(@RequestBody Cadeira curso, @PathVariable int id) {
		curso.setId(id);
		return cadeiraRepository.save(curso);
	}
	
	
}
