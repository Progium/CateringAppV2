package com.progium.catering.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progium.catering.repositories.UsuarioRepository;
import com.progium.catering.ejb.Usuario;

@Service
public class UsuarioService implements UsuarioServiceInterface{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public Boolean saveUsuario(Usuario objUsuario) {
		Usuario objDBUsuario = usuarioRepository.save(objUsuario);
		
		Boolean result = true;
		if(objDBUsuario == null){
			result = false;
		}
		return result;
		
	}
	
	@Override
	public Usuario getUsuarioById(Integer idUsuario){
		return usuarioRepository.findOne(idUsuario);
	}

}