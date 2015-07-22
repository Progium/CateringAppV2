package com.progium.catering.repositories;

import org.springframework.data.repository.CrudRepository;

import com.progium.catering.ejb.Usuario;

public interface IniciarSesionRepository extends CrudRepository<Usuario,Integer> {
	
	public static final int PAGE_SIZE = 5;


	Usuario findByCorreoAndContrasenna(String correo, String contrasenna);
	
}