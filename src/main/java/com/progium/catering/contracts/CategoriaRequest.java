package com.progium.catering.contracts;


public class CategoriaRequest extends BasePagingRequest{
	private int idCategoria;
	private String nombre;
	
	public CategoriaRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoriaRequest(int idCategoria, String nombre) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
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