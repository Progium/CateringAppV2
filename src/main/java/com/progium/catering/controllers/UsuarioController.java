package com.progium.catering.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.progium.catering.contracts.CateringResponse;
import com.progium.catering.contracts.TipoResponse;
import com.progium.catering.contracts.UsuarioResponse;
import com.progium.catering.contracts.UsuarioRequest;
import com.progium.catering.ejb.Catering;
import com.progium.catering.ejb.Provincia;
import com.progium.catering.ejb.Tipo;
import com.progium.catering.ejb.Usuario;
import com.progium.catering.pojo.CateringPOJO;
import com.progium.catering.pojo.ProvinciaPOJO;
import com.progium.catering.pojo.UsuarioPOJO;
import com.progium.catering.services.GeneralServiceInterface;
import com.progium.catering.services.UsuarioServiceInterface;
import com.progium.catering.utils.GeneradorContrasennaUtil;
import com.progium.catering.utils.PojoUtils;
import com.progium.catering.utils.Utils;
import com.progium.catering.utils.SendEmail;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping(value = "rest/protected/usuario")
public class UsuarioController {

	@Autowired
	UsuarioServiceInterface usuarioService;

	@Autowired
	GeneralServiceInterface generalService;

	@Autowired
	ServletContext servletContext;
	
	@Autowired
	HttpServletRequest request;	

	public UsuarioController() {
		// TODO Auto-generated constructor stub
	}
	//Obtiene los parametros que le envia el controller por medio del metodo post.
	@RequestMapping(value = "/registrarFoto", method = RequestMethod.POST)
	@Transactional
	public UsuarioResponse registrarFoto(@RequestParam("file") MultipartFile file,
			@RequestParam("idUsuario") int idUsuario)
			throws NoSuchAlgorithmException {
		//Busca al catering que se acaba de crear y le agrega la foto.
		UsuarioResponse us = new UsuarioResponse();
	
		Usuario objUsuario = usuarioService.getUsuarioById(idUsuario);
		
		String resultFileName = Utils.writeToFile(file, servletContext);
		
		objUsuario.setFotografia(resultFileName);
		
		Boolean state = usuarioService.saveUsuario(objUsuario);
		
		if (state) {
			us.setCode(200);
			us.setCodeMessage("user created succesfully");
		}else{
			us.setCode(401);
			us.setErrorMessage("Unauthorized User");
		}
		return us;
	}
	
	//Obtiene los parametros que le envia el controller por medio del metodo post.
		@RequestMapping(value = "/registrar", method = RequestMethod.POST)
		@Transactional
		public UsuarioResponse registrar(@RequestBody UsuarioRequest usuarioRequest)throws NoSuchAlgorithmException {
			//Crea un nuevo usuario response le setea los datos y le pasa el objeto de usuario al servicio de usuario
			UsuarioResponse us = new UsuarioResponse();
			Tipo objTipo = generalService.getTipoById(usuarioRequest.getTipoUsuarioId());

			Usuario objNuevoUsuario = new Usuario();
			objNuevoUsuario.setNombre(usuarioRequest.getNombre());
			objNuevoUsuario.setApellido1(usuarioRequest.getApellido1());
			objNuevoUsuario.setApellido2(usuarioRequest.getApellido2());
			objNuevoUsuario.setCorreo(usuarioRequest.getCorreo());
			objNuevoUsuario.setTelefono1(usuarioRequest.getTelefono1());
			objNuevoUsuario.setTelefono2(usuarioRequest.getTelefono2());
			objNuevoUsuario.setTipo(objTipo);
			objNuevoUsuario.setContrasenna(GeneradorContrasennaUtil
					.encriptarContrasenna(usuarioRequest.getContrasenna()));

			Boolean state = usuarioService.saveUsuario(objNuevoUsuario);

			if (state) {
				us.setCode(200);
				us.setCodeMessage("user created succesfully");
				us.setIdUsuario(objNuevoUsuario.getIdUsuario());

				String mensaje = "Para ingresar al sistema debe utilizar las siguientes credenciales: "
						+ "Correo: "
						+ objNuevoUsuario.getCorreo()
						+ "</br>"
						+ " Contraseña: " + usuarioRequest.getContrasenna().toString();
				SendEmail.sendEmail("Bienvenido a Catering App!",
						objNuevoUsuario.getCorreo(), "Nuevo Usuario",
						"Bienvenido a Catering App", mensaje);

			}else{
				us.setCode(401);
				us.setErrorMessage("Unauthorized User");
			}
			return us;
		}
		
		//Para mostrar el perfil del usuario
		@RequestMapping(value ="/perfilUsuario", method = RequestMethod.GET)
		public UsuarioResponse PerfilUsuario(){
			
			UsuarioResponse usuarioResponse = new UsuarioResponse();
			
			HttpSession currentSession = request.getSession();
			int idUsuario = (int) currentSession.getAttribute("idUsuario");	
						
			Usuario usuario = usuarioService.getUsuarioById(idUsuario);
			UsuarioPOJO usuarioPojo = new UsuarioPOJO();
			
			PojoUtils.pojoMappingUtility(usuarioPojo,usuario);
			
			usuarioResponse.setUsuario(usuarioPojo);
			
			return usuarioResponse;
		
	}
		
		@RequestMapping(value ="/getUsuarioById", method = RequestMethod.POST)
		public UsuarioResponse getUsuarioById(@RequestBody UsuarioRequest usuarioRequest)throws NoSuchAlgorithmException {
			
			UsuarioResponse usuarioResponse = new UsuarioResponse();
			
			Usuario usuario = usuarioService.getUsuarioById(usuarioRequest.getIdUsuario());

			UsuarioPOJO nUsuario = new UsuarioPOJO();
			nUsuario.setIDUsuario(usuario.getIdUsuario());
			nUsuario.setNombre(usuario.getNombre());
			nUsuario.setApellido1(usuario.getApellido1());
			nUsuario.setApellido2(usuario.getApellido2());
			nUsuario.setCorreo(usuario.getCorreo());
			nUsuario.setTelefono1(usuario.getTelefono1());
			nUsuario.setTelefono2(usuario.getTelefono2());
			nUsuario.setContrasenna(usuario.getContrasenna());
			nUsuario.setFotografia(usuario.getFotografia());
							
			usuarioResponse.setUsuario(nUsuario);
			
			return usuarioResponse;	
			
		}	
		
		//Obtiene los parametros que le envia el controller por medio del metodo post.
				@RequestMapping(value = "/modificarUsuario", method = RequestMethod.POST)
				@Transactional
				public UsuarioResponse ModificarUsuario(@RequestBody UsuarioRequest usuarioRequest)throws NoSuchAlgorithmException {
					//Crea un nuevo usuario response le setea los datos y lo pasa al servicio de usuario
					UsuarioResponse us = new UsuarioResponse();
					
					Usuario objUsuario = usuarioService.getUsuarioById(usuarioRequest.getIdUsuario());
					Tipo objTipo = generalService.getTipoById(usuarioRequest.getTipoUsuarioId());
					
					objUsuario.setNombre(usuarioRequest.getNombre());
					objUsuario.setApellido1(usuarioRequest.getApellido1());
					objUsuario.setApellido2(usuarioRequest.getApellido2());
					objUsuario.setCorreo(usuarioRequest.getCorreo());
					objUsuario.setTelefono1(usuarioRequest.getTelefono1());
					objUsuario.setTelefono2(usuarioRequest.getTelefono2());
					objUsuario.setTipo(objTipo);
					objUsuario.setContrasenna(GeneradorContrasennaUtil
					.encriptarContrasenna(usuarioRequest.getContrasenna()));
					
					Boolean state = usuarioService.saveUsuario(objUsuario);
		
					us.setCodeMessage("usuario updated succesfully");
				
				
				return us;
			}
}