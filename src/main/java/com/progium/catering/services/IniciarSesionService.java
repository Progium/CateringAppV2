package com.progium.catering.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.progium.catering.contracts.IniciarSesionRequest;
import com.progium.catering.ejb.Usuario;
import com.progium.catering.repositories.IniciarSesionRepository;

/**
* Esta clase se encarga dar el comportamiento a las diferentes 
* funcioalidades 
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/

@Service
public class IniciarSesionService implements IniciarSesionServiceInterface{

	@Autowired
	IniciarSesionRepository iniciarSesionRepository;
	
	/**
	* Este  metodo se encarga de verificar si los datos suministrados al iniciar sesion son correctos.
	*
	* @param  iniciarSesionRequest
	* 
	* @return Usuario
	*
	*/
	@Override
	@Transactional
	public Usuario verificarusuario(IniciarSesionRequest lr) {
		return iniciarSesionRepository.findByCorreoAndContrasenna(lr.getCorreo(), lr.getContrasenna()); 
	}

}