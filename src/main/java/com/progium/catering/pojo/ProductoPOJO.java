package com.progium.catering.pojo;

public class ProductoPOJO {
	
	private int idProducto;
	private String nombre;
	private int  categoriaId;
	
	public ProductoPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getIdProducto() {
		return idProducto;
	}
	
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getCategoriaId() {
		return categoriaId;
	}
	
	public void setCategoriaId(int categoriaId) {
		this.categoriaId = categoriaId;
	}
	
	
}
