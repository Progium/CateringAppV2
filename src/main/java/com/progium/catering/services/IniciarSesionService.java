package com.progium.catering.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.progium.catering.contracts.IniciarSesionRequest;
import com.progium.catering.ejb.Usuario;
import com.progium.catering.repositories.IniciarSesionRepository;


@Service
public class IniciarSesionService implements IniciarSesionServiceInterface{

	@Autowired
	IniciarSesionRepository iniciarSesionRepository;
	
	
	@Override
	@Transactional
	public Usuario verificarusuario(IniciarSesionRequest lr) {
		return iniciarSesionRepository.findByCorreoAndContrasenna(lr.getCorreo(), lr.getContrasenna()); 
	}

}