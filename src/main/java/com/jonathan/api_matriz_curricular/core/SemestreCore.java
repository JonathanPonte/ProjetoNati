package com.jonathan.api_matriz_curricular.core;

import org.springframework.beans.factory.annotation.Autowired;

import com.jonathan.api_matriz_curricular.repository.CadeiraRepository;
import com.jonathan.api_matriz_curricular.repository.CursoRepository;


public class SemestreCore {
	
	@Autowired
	CadeiraRepository cadeiraRepository;
	
	@Autowired
	CursoRepository cursoRepository;
	
	

}
