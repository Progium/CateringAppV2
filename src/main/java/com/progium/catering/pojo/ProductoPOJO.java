package com.progium.catering.pojo;

import com.progium.catering.ejb.Categoria;

/**
* Esta clase se encarga de crear el objeto producto
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class ProductoPOJO {
	
	private int idProducto;
	private String nombre;
	private Categoria categoria;
	private int  idCategoria;
	
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
	
	public int getCategoria() {
		this.idCategoria = this.categoria.getIdCategoria();
		return idCategoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
		setIdCategoria(this.categoria);
	}

	public void setIdCategoria(Categoria categoria) {
		this.idCategoria = categoria.getIdCategoria();
	}
	
	
}
