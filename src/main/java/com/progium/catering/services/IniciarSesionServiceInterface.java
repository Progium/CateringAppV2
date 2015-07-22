package com.progium.catering.services;

import com.progium.catering.contracts.IniciarSesionRequest;
import com.progium.catering.ejb.Usuario;


public interface IniciarSesionServiceInterface {

	
	Usuario verificarusuario(IniciarSesionRequest lr);
	
}