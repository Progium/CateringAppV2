package com.progium.catering.contracts;

/**
* Esta clase se encarga de setear las variables 
* para realizar peticiones al controlador.
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class IniciarSesionRequest  {
	
	private String correo;
	private String contrasenna;
	
	public IniciarSesionRequest() {
		super();
	}

	public IniciarSesionRequest(String correo, String contrasenna) {
		super();
		this.correo = correo;
		this.contrasenna = contrasenna;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getContrasenna() {
		return contrasenna;
	}
	
	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}

}
