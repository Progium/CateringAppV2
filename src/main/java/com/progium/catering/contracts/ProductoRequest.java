package com.progium.catering.contracts;

import com.progium.catering.pojo.ProductoPOJO;

/**
* Esta clase se encarga de setear las variables 
* para realizar peticiones al controlador.
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
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
