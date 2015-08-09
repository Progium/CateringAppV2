package com.progium.catering.repositories;

import org.springframework.data.repository.CrudRepository;

import com.progium.catering.ejb.Usuario;

/**
* Esta clase se encarga de manejar las operaciones de
* manipulacion de datos
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public interface IniciarSesionRepository extends CrudRepository<Usuario,Integer> {
	
	public static final int PAGE_SIZE = 5;


	Usuario findByCorreoAndContrasenna(String correo, String contrasenna);
	
}