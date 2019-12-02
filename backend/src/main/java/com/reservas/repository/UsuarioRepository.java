package com.reservas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservas.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,String>{

	//public Usuario findByNombre(String nombre);
	
}
