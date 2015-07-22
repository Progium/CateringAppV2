package com.progium.catering.contracts;

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
