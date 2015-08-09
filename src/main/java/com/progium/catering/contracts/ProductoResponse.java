package com.progium.catering.contracts;

import java.util.List;
import com.progium.catering.pojo.ProductoPOJO;

/**
* Esta clase se encarga de setear las variables que
* se le envian al controlador de javascript.
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class ProductoResponse extends BaseResponse{
	
	private List<ProductoPOJO> productos;
	
	public ProductoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<ProductoPOJO> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoPOJO> productos) {
		this.productos = productos;
	}
	
	
}
