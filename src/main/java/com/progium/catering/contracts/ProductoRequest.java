package com.progium.catering.contracts;

import com.progium.catering.pojo.ProductoPOJO;

public class ProductoRequest extends BaseResponse {
	 private ProductoPOJO producto;

	 
	 
	 public ProductoRequest() {
		super();
		// TODO Auto-generated constructor stub
	 }

	public ProductoPOJO getProducto() {
		return producto;
	 }

	 public void setProducto(ProductoPOJO producto) {
		this.producto = producto;
	 }

	

	

	 
	 
}
