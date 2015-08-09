package com.progium.catering.services;

import java.util.List;

import com.progium.catering.ejb.Usuario;


public interface UsuarioServiceInterface {

	Boolean saveUsuario(Usuario objUsuario);
	Usuario getUsuarioById(Integer idUsuario);
	Usuario getUsuarioByCorreo(String correo);
}
