package com.jonathan.api_matriz_curricular.resources;

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

import com.jonathan.api_matriz_curricular.models.Disciplina;
import com.jonathan.api_matriz_curricular.repository.DisciplinaRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/api")
public class DisciplinaResource {

	@Autowired
	DisciplinaRepository disciplinaRepository;
	

	
	@GetMapping("/disciplinas")
	public List<Disciplina> listarDisciplinas(){
		return disciplinaRepository.findAll();
	}
	
	
	@PostMapping("/disciplina")
	public Disciplina novaDisciplina(@RequestBody Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}
		

	
	@DeleteMapping("/disciplina/{id}")
	public void deleteDisciplina(@PathVariable int id) {
		disciplinaRepository.deleteById(id);
	}
	
	
	@PutMapping("/disciplina/{id}")
	public Disciplina atualizarDisciplina(@RequestBody Disciplina disciplina, @PathVariable int id) {
		disciplina.setId(id);
		return disciplinaRepository.save(disciplina);
	}
	
	
}
