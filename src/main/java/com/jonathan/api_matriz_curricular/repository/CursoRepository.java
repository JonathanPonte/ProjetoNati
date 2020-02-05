package com.jonathan.api_matriz_curricular.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonathan.api_matriz_curricular.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{

}
