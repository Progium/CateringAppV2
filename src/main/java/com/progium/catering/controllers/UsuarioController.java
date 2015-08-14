package com.progium.catering.controllers;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

import com.progium.catering.contracts.BaseResponse;
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
* Esta clase se encarga de crear el controlador
* para el manejo de las diferentes funcionalidades 
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
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
	
	/**
	* Este  método se encarga de registrar una fotografia 
	*
	* @param  file
	* @param  idUsuario
	* 
	* @return UsuarioResponse
	*
	*/
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
	
	/**
	* Este  metodo se encarga de registrar un usuario 
	*
	* @param  UsuarioRequest
	* 
	* @return UsuarioResponse
	*
	*/
	
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
		
	/**
	 * Este  método se encarga de mostrar los datos de un usuario 
	 *
	 * @param  UsuarioRequest
	 * 
	 * @return UsuarioResponse
	 *
	 */
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
	
	/**
	 * Este  método se encarga de modificar los datos de un usuario 
	 *
	 * @param  UsuarioRequest
	 * 
	 * @return UsuarioResponse
	 *
	 */
	@RequestMapping(value = "/modificar", method = RequestMethod.POST)
	@Transactional
	public UsuarioResponse modificar(@RequestBody UsuarioRequest usuarioRequest)throws NoSuchAlgorithmException {
		//Modifica los datos del usuario.
		UsuarioResponse us = new UsuarioResponse();
		
		Tipo objTipo = generalService.getTipoById(usuarioRequest.getTipoUsuarioId());

		Usuario objUsuario = usuarioService.getUsuarioById(usuarioRequest.getIdUsuario());
		
		objUsuario.setNombre(usuarioRequest.getNombre());
		objUsuario.setApellido1(usuarioRequest.getApellido1());
		objUsuario.setApellido2(usuarioRequest.getApellido2());
		objUsuario.setCorreo(usuarioRequest.getCorreo());
		objUsuario.setTelefono1(usuarioRequest.getTelefono1());
		objUsuario.setTelefono2(usuarioRequest.getTelefono2());
		objUsuario.setTipo(objTipo);
		//Valida que si la contraseña es igual a la anterior no la encripte
		if(usuarioRequest.getCambio().equals("true")){
			objUsuario.setContrasenna(GeneradorContrasennaUtil.encriptarContrasenna(usuarioRequest.getContrasenna()));
		}

		Boolean state = usuarioService.saveUsuario(objUsuario);

		if (state) {
			us.setCode(200);
			us.setCodeMessage("user created succesfully");
			us.setIdUsuario(objUsuario.getIdUsuario());

				String mensaje = "Notificación: "
						+ "<p></p>"
						+ objUsuario.getNombre()
						+ " sus datos han sido cambiados satisfactoriamente";
						
				SendEmail.sendEmail("Cambio datos Catering App!",
						objUsuario.getCorreo(), "Usuario",
						"Gracias por usar Catering App", mensaje);

		}else{
			us.setCode(401);
			us.setErrorMessage("Unauthorized User");
		}
		return us;
	}
	
	
	private String randomString() {
		char[] characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		int length = 5;
		Random random = new SecureRandom();
		char[] result = new char[length];
		for (int i = 0; i < result.length; i++) {
			int randomCharIndex = random.nextInt(characterSet.length);
			result[i] = characterSet[randomCharIndex];
		}
		return new String(result);
	}

	@RequestMapping(value = "/olvidoContrasenna", method = RequestMethod.POST)
	@Transactional
	public BaseResponse olvidoContrasenna(@RequestBody UsuarioRequest usuarioRequest) throws NoSuchAlgorithmException{	
	
		BaseResponse bs = new BaseResponse();
		Usuario objUsuario = usuarioService.getUsuarioByCorreo(usuarioRequest.getCorreo());
		
		if(objUsuario != null){
			String nuevaContrasenna = randomString();
			objUsuario.setContrasenna(GeneradorContrasennaUtil.encriptarContrasenna(nuevaContrasenna));
			Boolean state = usuarioService.saveUsuario(objUsuario);
			
			if(state){
				bs.setCode(200);
				bs.setCodeMessage("Contraseña modify succesfully");
				String mensaje = "Para volver ingresar al sistema debe utilizar la siguiente contraseña: "
						+ "contraseña: "
						+ nuevaContrasenna;
				SendEmail.sendEmail("Solicitud de cambio de contraseña",
										objUsuario.getCorreo(), "Usuario", 
										"Cambio de contraseña", mensaje);
			}else{
				bs.setCode(400);
				bs.setCodeMessage("Contraseña modify succesfully");
			}
			
		}else{
			bs.setCode(400);
			bs.setCodeMessage("Contraseña modify succesfully");
		}
		
	return bs;
 }
	
}