package com.progium.catering.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.progium.catering.ejb.Usuario;
import com.progium.catering.contracts.BaseResponse;
import com.progium.catering.contracts.IniciarSesionRequest;
import com.progium.catering.contracts.IniciarSesionResponse;
import com.progium.catering.services.IniciarSesionServiceInterface;
import com.progium.catering.utils.GeneradorContrasennaUtil;

@RestController
@RequestMapping(value = "rest/iniciarsesion/")
public class LoginController {
	
	@Autowired
	IniciarSesionServiceInterface iniciarSesionService;
	
	@Autowired
	HttpServletRequest request;	
	
	@RequestMapping(value = "/verificarusuario", method = RequestMethod.POST)
	@Transactional
	public BaseResponse verificarusuario(@RequestBody IniciarSesionRequest iniciarSesionRequest) throws NoSuchAlgorithmException{	
		
		iniciarSesionRequest.setContrasenna(GeneradorContrasennaUtil.encriptarContrasenna(iniciarSesionRequest.getContrasenna()));
		Usuario usuarioLogueado = iniciarSesionService.verificarusuario(iniciarSesionRequest);
		IniciarSesionResponse iniciarSesionResponse = new IniciarSesionResponse();
		HttpSession currentSession = request.getSession();
		if(usuarioLogueado == null){
			iniciarSesionResponse.setCode(401);
			iniciarSesionResponse.setErrorMessage("Unauthorized User hola");
		}
		else
		{
			iniciarSesionResponse.setCode(200);
			iniciarSesionResponse.setCodeMessage("User authorized");
			
			iniciarSesionResponse.setIdUsuario(usuarioLogueado.getIdUsuario());
			iniciarSesionResponse.setNombre(usuarioLogueado.getNombre());
			iniciarSesionResponse.setApellido1(usuarioLogueado.getApellido1());
			iniciarSesionResponse.setApellido2(usuarioLogueado.getApellido2());
			iniciarSesionResponse.setCorreo(usuarioLogueado.getCorreo());
			iniciarSesionResponse.setFotografia(usuarioLogueado.getFotografia());
			iniciarSesionResponse.setTipo(usuarioLogueado.getTipo().getIdTipo());
			
			currentSession.setAttribute("idUsuario", usuarioLogueado.getIdUsuario());
		}
		return iniciarSesionResponse;
	}	
	
	
	@RequestMapping(value = "/setusuario", method = RequestMethod.POST)
	@Transactional
	public void setusuario(){
		HttpSession currentSession = request.getSession();
			currentSession.setAttribute("idUsuario", 0);
	
	}	
	
}