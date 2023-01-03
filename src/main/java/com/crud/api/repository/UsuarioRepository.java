package com.crud.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.crud.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

}
