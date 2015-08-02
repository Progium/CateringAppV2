package com.progium.catering.contracts;

import org.springframework.web.multipart.MultipartFile;

public class CatalogoProductoRequest extends BasePagingRequest{
	
	private double precio;
	private String fotografia;
	private Integer cateringId;
	private Integer productoId;
	private String needAccess;
	private MultipartFile file;
	
	
	public CatalogoProductoRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CatalogoProductoRequest(double precio, String fotografia,
			Integer cateringId, Integer productoId, String needAccess,
			MultipartFile file) {
		super();
		this.precio = precio;
		this.fotografia = fotografia;
		this.cateringId = cateringId;
		this.productoId = productoId;
		this.needAccess = needAccess;
		this.file = file;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
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


	public String getNeedAccess() {
		return needAccess;
	}


	public void setNeedAccess(String needAccess) {
		this.needAccess = needAccess;
	}


	public MultipartFile getFile() {
		return file;
	}


	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
}
