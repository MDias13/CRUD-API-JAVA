package com.crud.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crud.api.model.Usuario;
import com.crud.api.repository.UsuarioRepository;

@RestController
public class apiController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@GetMapping(value = "/listar")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Usuario>> listar(){
		
		List<Usuario> usuarios = null;
		try {
			usuarios = usuarioRepository.findAll();
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		
		return new ResponseEntity<List<Usuario>>(usuarios,HttpStatus.OK);
		
	}

}
