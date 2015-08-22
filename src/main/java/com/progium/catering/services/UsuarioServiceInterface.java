package com.progium.catering.services;

import java.util.List;

import com.progium.catering.ejb.Usuario;

/**
* Esta clase se encarga de exponer las funcionalidades 
* implementadas por el servicio
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/


public interface UsuarioServiceInterface {

	Boolean saveUsuario(Usuario objUsuario);
	Usuario getUsuarioById(Integer idUsuario);
	Usuario getUsuarioByCorreo(String correo);
	List<Usuario> findByTipoUsuario(Integer idTipo); 
}
