package com.progium.catering.pojo;

import com.progium.catering.ejb.Producto;

/**
* Esta clase se encarga de crear el objeto catalogo producto
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class CatalogoProductoPOJO {
	
	private int idCatalogoProducto;
	private double precio;
	private boolean estado;
	private String fotografia;
	private Integer cateringId;
	private Integer productoId;
	private Producto producto;
	
	public CatalogoProductoPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getIdCatalogoProducto() {
		return idCatalogoProducto;
	}
	
	public void setIdCatalogoProducto(int idCatalogoProducto) {
		this.idCatalogoProducto = idCatalogoProducto;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public boolean isEstado() {
		return estado;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public String getFotografia() {
		return fotografia;
	}
	
	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}
	
	public Integer getCateringId() {
		return cateringId;
	}
	
	public void setCateringId(Integer cateringId) {
		this.cateringId = cateringId;
	}
	
	public Integer getProductoId() {
		return productoId;
	}
	
	public void setProductoId(Integer productoId) {
		this.productoId = productoId;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
}
