package com.progium.catering.pojo;

public class UsuarioPOJO {

	private int idUsuario;
	private String nombre;
	private String apellido1;
	private String apelido2;
	private String telefono1;
	private String telefono2;
	private String correo;
	private String fotografia;
	private String contrasenna;
	private Integer tipoUsuarioId;
	
	public UsuarioPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getIDUsuario() {
		return idUsuario;
	}
	public void setIDUsuario(int idUsuario) {
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
		return apelido2;
	}

	public void setApellido2(String apellido2) {
		this.apelido2 = apelido2;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFotografia() {
		return fotografia;
	}

	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}
	
	public String getContrasenna() {
		return contrasenna;
	}

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}

	public Integer getTipoUsuarioId() {
		return tipoUsuarioId;
	}

	public void setTipoUsuarioId(Integer tipoUsuarioId) {
		this.tipoUsuarioId = tipoUsuarioId;
	}

}
