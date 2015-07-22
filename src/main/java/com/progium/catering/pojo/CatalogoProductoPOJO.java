package com.progium.catering.pojo;

public class CatalogoProductoPOJO {
	
	private int idCatalogoProducto;
	private double precio;
	private boolean estado;
	private String fotografia;
	private Integer cateringId;
	private Integer productoId;
	
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
	
}
