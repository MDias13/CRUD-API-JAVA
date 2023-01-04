package com.crud.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.crud.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

	@Query(value = "select u from Usuario u where Upper(trim(u.nome)) like %?1%")
	List<Usuario> buscarNome(String nome);
	
	
	
}
