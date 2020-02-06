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

import com.jonathan.api_matriz_curricular.models.Curso;
import com.jonathan.api_matriz_curricular.repository.CursoRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/api")
public class CursoResource {
	
	@Autowired
	CursoRepository cursoRepository;
	

	
	@GetMapping("/cursos")
	public List<Curso> listarCursos(){
		return cursoRepository.findAll();
	}
	
	
	@PostMapping("/curso")
	public Curso novoCurso(@RequestBody Curso curso) {
		return cursoRepository.save(curso);
	}
		

	
	@DeleteMapping("/curso/{id}")
	public void deleteCurso(@PathVariable int id) {
		cursoRepository.deleteById(id);
	}
	
	
	@PutMapping("/curso/{id}")
	public Curso atualizaCurso(@RequestBody Curso curso, @PathVariable int id) {
		curso.setId(id);
		return cursoRepository.save(curso);
	}

}
