package com.jonathan.api_matriz_curricular.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonathan.api_matriz_curricular.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

//	Usuario findByLogin(Long login);
	
	
}
