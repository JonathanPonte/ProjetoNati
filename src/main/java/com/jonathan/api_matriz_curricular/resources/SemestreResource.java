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

import com.jonathan.api_matriz_curricular.core.SemestreCore;
import com.jonathan.api_matriz_curricular.dto.SemestreDTO;
import com.jonathan.api_matriz_curricular.models.Curso;
import com.jonathan.api_matriz_curricular.models.Semestre;
import com.jonathan.api_matriz_curricular.repository.CursoRepository;
import com.jonathan.api_matriz_curricular.repository.SemestreRepository;

import javassist.NotFoundException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api")
public class SemestreResource {

	@Autowired
	SemestreRepository semestreRepository;

	@Autowired
	CursoRepository cursoRepository;

	SemestreCore semestreCore = new SemestreCore();

	@GetMapping("/semestres")
	public List<Semestre> listarSemestre() {
		return semestreRepository.findAll();
	}

	@PostMapping("/semestre")
	public Semestre novoSemestre(@RequestBody SemestreDTO semestreDto) throws NotFoundException {
		Semestre semestre = null;
		Curso curso = cursoRepository.findById(semestreDto.getCursoId()).orElse(null);
		semestre = new Semestre(semestreDto.getPeriodo(), curso);

		return semestreRepository.save(semestre);
	}

	@DeleteMapping("/semestre/{id}")
	public void deleteDisciplina(@PathVariable int id) {
		semestreRepository.deleteById(id);
	}

	@PutMapping("/semestre")
	public Semestre atualizarDisciplina(@RequestBody SemestreDTO semestreDto) {
		Curso cursoU = cursoRepository.findById(semestreDto.getCursoId()).orElse(null);
		
		Semestre semestre = new Semestre(semestreDto.getId(), semestreDto.getPeriodo(), cursoU);
		semestreRepository.save(semestre);
		
		
		List<Curso> cursos = cursoRepository.findAll();
		
		for(Curso curso : cursos) {
			if(curso.getId() == semestreDto.getId()) {
				System.out.println(curso.getId() + " " + semestreDto.getId());
				curso.addSemestre(semestre);
				cursoRepository.save(curso);
			}
		}
		
		return semestre;
	}

}
