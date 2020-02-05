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

import com.jonathan.api_matriz_curricular.core.SemestreCore;
import com.jonathan.api_matriz_curricular.dto.SemestreDTO;
import com.jonathan.api_matriz_curricular.models.Curso;
import com.jonathan.api_matriz_curricular.models.Semestre;
import com.jonathan.api_matriz_curricular.repository.CursoRepository;
import com.jonathan.api_matriz_curricular.repository.SemestreRepository;

import javassist.NotFoundException;

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
			
		if (curso != null) {
			semestre = new Semestre(semestreDto.getPeriodo(), curso);
			curso.addSemestre(semestre);
			cursoRepository.save(curso);
			semestreRepository.save(semestre);
		}else {
			throw new NotFoundException("Id de curso invalido");
		}

		return semestre;
	}

	@DeleteMapping("/semestre/{id}")
	public void deleteDisciplina(@PathVariable int id) {
		semestreRepository.deleteById(id);
	}

	@PutMapping("/semestre/{id}")
	public Semestre atualizarDisciplina(@RequestBody Semestre semestre, @PathVariable int id) {
		semestre.setId(id);
		return semestreRepository.save(semestre);
	}

}
