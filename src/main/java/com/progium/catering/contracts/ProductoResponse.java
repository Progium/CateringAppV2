package com.progium.catering.contracts;

import java.util.List;
import com.progium.catering.pojo.ProductoPOJO;

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
