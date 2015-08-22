package com.progium.catering.pojo;

/**
* Esta clase se encarga de crear el objeto categoria
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class CategoriaPOJO {

	private int idCategoria;
	private String nombre;
	
	public CategoriaPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
