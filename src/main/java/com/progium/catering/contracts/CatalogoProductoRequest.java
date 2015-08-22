package com.progium.catering.contracts;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
* Esta clase se encarga de setear las variables 
* para realizar peticiones al controlador.
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class CatalogoProductoRequest extends BasePagingRequest{
	
	private double precio;
	private String fotografia;
	private List<Integer> cateringId;
	private Integer productoId;
	private String needAccess;
	private MultipartFile file;
	private List<Integer> catalogoProducto;
	
	public CatalogoProductoRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CatalogoProductoRequest(double precio, String fotografia,
			List<Integer> cateringId, Integer productoId, String needAccess,
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


	public List<Integer> getCateringId() {
		return cateringId;
	}


	public void setCateringId(List<Integer> cateringId) {
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

	public List<Integer> getCatalogoProducto() {
		return catalogoProducto;
	}

	public void setCatalogoProducto(List<Integer> catalogoProducto) {
		this.catalogoProducto = catalogoProducto;
	}
	
}
