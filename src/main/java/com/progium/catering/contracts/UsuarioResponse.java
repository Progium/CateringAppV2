package com.progium.catering.contracts;

import java.util.List;

import com.progium.catering.ejb.Usuario;

public class UsuarioResponse extends BaseResponse {

	private List<Usuario> usuarios;
	private int idUsuario;
	private int nombre;
	
	public UsuarioResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	
}
