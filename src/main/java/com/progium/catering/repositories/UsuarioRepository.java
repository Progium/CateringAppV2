package com.progium.catering.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.progium.catering.ejb.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario,Integer> {
	
	public static final int PAGE_SIZE = 5;
	
	Usuario findByCorreoAndContrasenna(String email, String password);
	
	Page<Usuario> findAll(Pageable pageable);
	
	Page<Usuario> findByNombreContaining(String nombre, Pageable pageable);
	
	Page<Usuario> findByApellido1Containing(String apellido1, Pageable pageable);
}
