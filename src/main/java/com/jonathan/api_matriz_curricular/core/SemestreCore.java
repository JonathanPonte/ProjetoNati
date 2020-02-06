package com.jonathan.api_matriz_curricular.core;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathan.api_matriz_curricular.dto.SemestreDTO;
import com.jonathan.api_matriz_curricular.models.Curso;
import com.jonathan.api_matriz_curricular.repository.CadeiraRepository;
import com.jonathan.api_matriz_curricular.repository.CursoRepository;

@Service
public class SemestreCore {
	
	@Autowired
	CadeiraRepository cadeiraRepository;
	
	@Autowired
	CursoRepository cursoRepository;
	
	
	public void inserir(SemestreDTO semesDto) {
//		Semestre semestre = null;
//		System.out.println("--------------------------------------");
//		System.out.println("semestre id:   " + semesDto.getCursoId());
//		System.out.println("--------------------------------------");
		
//		Curso curso = cursoRepository.findById(semesDto.getCursoId()).orElse(null);
		
		List<Curso> curso = cursoRepository.findAll();
		
		Curso cur = curso.get(0);
		
		System.out.println("--------------------------------------");
		System.out.println("Curso: " + cur);
		System.out.println("--------------------------------------");
		
		
//		if(curso != null) {
//			semestre = new Semestre(semesDto.getPeriodo(), curso);
//			curso.addSemestre(semestre);
//			cursoRepository.save(curso);
//		}
//		
//		return semestre;
	}
	

}
