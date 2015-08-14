package com.progium.catering.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

public interface UsuarioRepository extends CrudRepository<Usuario,Integer> {
	
	public static final int PAGE_SIZE = 5;
	
	Usuario findByCorreoAndContrasenna(String email, String password);
	
	Usuario findByCorreo(String correo);
	
	List<Usuario> findByTipo(Integer idTipo);
	
	Page<Usuario> findAll(Pageable pageable);
	
	Page<Usuario> findByNombreContaining(String nombre, Pageable pageable);
	
	Page<Usuario> findByApellido1Containing(String apellido1, Pageable pageable);
}
