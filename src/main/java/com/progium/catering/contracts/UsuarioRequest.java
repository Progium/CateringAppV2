package com.progium.catering.contracts;

/**
* Esta clase se encarga de setear las variables 
* para realizar peticiones al controlador.
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/

import com.progium.catering.pojo.UsuarioPOJO;

public class UsuarioRequest extends BasePagingRequest {

	private int idUsuario;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String correo;
	private String telefono1;
	private String telefono2;
	private int tipoUsuarioId;
	private String contrasenna;
	private String needAccess;
		
	public UsuarioRequest() {
		super();
	}
	
	public UsuarioRequest(String nombre, String apellido1, String apellido2,
			String correo, String telefono1, String telefono2,
			int tipoUsuarioId, String contrasenna, String needAccess) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.correo = correo;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.tipoUsuarioId = tipoUsuarioId;
		this.contrasenna = contrasenna;
		this.needAccess = needAccess;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono1() {
		return telefono1;
	}
	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}
	public String getTelefono2() {
		return telefono2;
	}
	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}
	public int getTipoUsuarioId() {
		return tipoUsuarioId;
	}
	public void setTipoUsuarioId(int tipoUsuarioId) {
		this.tipoUsuarioId = tipoUsuarioId;
	}
	public String getContrasenna() {
		return contrasenna;
	}
	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}
	public String getNeedAccess() {
		return needAccess;
	}
	public void setNeedAccess(String needAccess) {
		this.needAccess = needAccess;
	}
}
