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

import com.jonathan.api_matriz_curricular.dto.LoginDTO;
import com.jonathan.api_matriz_curricular.models.Usuario;
import com.jonathan.api_matriz_curricular.repository.UsuarioRepository;

import javassist.NotFoundException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/api")
public class UsuarioResource {

	@Autowired
	UsuarioRepository usuarioRepository;
	

	
	@GetMapping("/usuarios")
	public List<Usuario> listarUsuarios(){
		return usuarioRepository.findAll();
	}
	
	
	@PostMapping("/usuario")
	public Usuario novoUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
		

	
	@DeleteMapping("/usuario/{id}")
	public void deleteUsuario(@PathVariable int id) {
		usuarioRepository.deleteById(id);
	}
	
	
	@PutMapping("/usuario/{id}")
	public Usuario atualizaUsuario(@RequestBody Usuario usuario, @PathVariable int id) {
		usuario.setId(id);
		return usuarioRepository.save(usuario);
	}
		
	
	@PostMapping("/login")
	public Usuario login(@RequestBody LoginDTO loginUsuario) throws NotFoundException{
		
		Usuario usuario = usuarioRepository.findByEmailAndSenha(loginUsuario.getEmail(), loginUsuario.getSenha());
		
		if(usuario == null) {
			throw new NotFoundException("Usuario não existe.");
		}
		
		return usuario;
	}
	
	
}
