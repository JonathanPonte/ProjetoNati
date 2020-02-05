package com.jonathan.api_matriz_curricular.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jonathan.api_matriz_curricular.models.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{
	
	

	
}
