package com.progium.catering.contracts;

import java.util.List;

/**
* Esta clase se encarga de setear las variables que
* se le envian al controlador de javascript.
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/

import com.progium.catering.pojo.UsuarioPOJO;

public class UsuarioResponse extends BaseResponse {

	private List<UsuarioPOJO> usuarios;
	private UsuarioPOJO usuario;
	private int idUsuario;
	private String nombre;
	
	public UsuarioResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<UsuarioPOJO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioPOJO> usuarios) {
		this.usuarios = usuarios;
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

	public UsuarioPOJO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioPOJO usuario) {
		this.usuario = usuario;
	}

	
}
