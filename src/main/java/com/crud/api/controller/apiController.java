package com.crud.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crud.api.model.Usuario;
import com.crud.api.repository.UsuarioRepository;

@RestController
public class apiController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@GetMapping(value = "/listar")
	@ResponseStatus(HttpStatus.OK) /*Retorna os dados para o corpo da resposta*/
	public ResponseEntity<List<Usuario>> listar(){
		
		List<Usuario> usuarios = null;
		try {
			usuarios = usuarioRepository.findAll(); /*Executa a consulta no banco */
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		
		return new ResponseEntity<List<Usuario>>(usuarios,HttpStatus.OK); /*Retorna a lsita em JSON */
		
	}
	
	@PostMapping("/salvar")
	@ResponseBody
	public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){ /*Recebe os dados para salvar */
		
		Usuario user = usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuario>(user,HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/deletar")
	@ResponseBody
	public ResponseEntity<String> deletar(@RequestParam Long id){ /*Recebe os dados para salvar */
	
		usuarioRepository.deleteById(id);
		
		return new ResponseEntity<String>("Usuario Deletado com Sucesso",HttpStatus.OK);
	}
	
	@GetMapping("/buscar")
	@ResponseBody
	public ResponseEntity<Usuario> buscar(@RequestParam(name = "id") Long id){ /*Recebe os dados para salvar */
	
		Usuario user = usuarioRepository.findById(id).get();
		
		return new ResponseEntity<Usuario>(user,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	@ResponseBody
	public ResponseEntity<?> update(@RequestBody Usuario usuario){ /*Recebe os dados para salvar */
	
		if(usuario.getId() == null) {
		
		return new ResponseEntity<String>("ID não informado",HttpStatus.OK);
		}
		
		Usuario user = usuarioRepository.saveAndFlush(usuario);
		
		return new ResponseEntity<Usuario>(user,HttpStatus.OK);
	}
	
	@GetMapping("/buscarNome")
	@ResponseBody
	public ResponseEntity<List<Usuario>> buscarNome(@RequestParam(name = "nome") String nome){ 
	
		List<Usuario> user = usuarioRepository.buscarNome(nome.trim().toUpperCase());
		
		return new ResponseEntity<List<Usuario>>(user,HttpStatus.OK);
	}
	
	
	
	
	
}
