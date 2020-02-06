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

import com.jonathan.api_matriz_curricular.dto.CadeiraDTO;
import com.jonathan.api_matriz_curricular.models.Cadeira;
import com.jonathan.api_matriz_curricular.models.Disciplina;
import com.jonathan.api_matriz_curricular.models.Semestre;
import com.jonathan.api_matriz_curricular.repository.CadeiraRepository;
import com.jonathan.api_matriz_curricular.repository.DisciplinaRepository;
import com.jonathan.api_matriz_curricular.repository.SemestreRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/api")
public class CadeiraResource {

	@Autowired
	CadeiraRepository cadeiraRepository;
	
	@Autowired
	SemestreRepository semestreRepositoy;
	
	@Autowired
	DisciplinaRepository disciplinaRepositoy;
	
	@GetMapping("/cadeiras")
	public List<Cadeira> listarCadeiras(){
		return cadeiraRepository.findAll();
	}
	
	
	@PostMapping("/cadeira")
	public Cadeira novacadeira(@RequestBody CadeiraDTO cadeiraDto) {
		
		Semestre semestre = semestreRepositoy.findById(cadeiraDto.getSemestreId()).orElse(null);
		Disciplina disciplina = disciplinaRepositoy.findById(cadeiraDto.getDisciplinaId()).orElse(null);
		
		Cadeira cadeira = new Cadeira(cadeiraDto.getQtdCreditos(), semestre, disciplina);
		
		
//		semestre.addCadeira(cadeira);
//		semestreRepositoy.save(semestre);
		
		
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
