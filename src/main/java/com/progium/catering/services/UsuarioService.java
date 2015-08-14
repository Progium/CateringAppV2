package com.progium.catering.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.progium.catering.repositories.UsuarioRepository;
import com.progium.catering.ejb.Usuario;

/**
* Esta clase se encarga de dar el comportamiento a las diferentes 
* funcioalidades 
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/

@Service
public class UsuarioService implements UsuarioServiceInterface{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	/**
	* Este  metodo se encarga salvar un usuario
	*
	* @param usuario
	* 
	* @return Boolean
	*
	*/
	@Override
	@Transactional
	public Boolean saveUsuario(Usuario objUsuario) {
		Usuario objDBUsuario = usuarioRepository.save(objUsuario);
		
		Boolean result = true;
		if(objDBUsuario == null){
			result = false;
		}
		return result;
		
	}
	
	/**
	* Este  metodo se encarga buscar un usuario dado un determinado id
	*
	* @param  idUsuario
	* 
	* @return Usuario
	*
	*/
	@Override
	public Usuario getUsuarioById(Integer idUsuario){
		return usuarioRepository.findOne(idUsuario);
	}
	
	/**
	* Este  metodo se encarga buscar un usuario dado un determinado correo
	*
	* @param  correo
	* 
	* @return Usuario
	*
	*/
	@Override
	public Usuario getUsuarioByCorreo(String correo){
		return usuarioRepository.findByCorreo(correo);
	}
	
	/**
	* Este  metodo se encarga buscar los usuarios administradores
	*
	* @param  idTipo
	* 
	* @return Usuario
	*
	*/
	@Override
	public List<Usuario> findByTipoUsuario(Integer idTipo){
		return usuarioRepository.findByTipo_idTipo(idTipo);
	}

	
}