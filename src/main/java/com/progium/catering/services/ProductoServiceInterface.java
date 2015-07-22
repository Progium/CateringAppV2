package com.progium.catering.services;

import java.util.List;
import com.progium.catering.ejb.Producto;

public interface ProductoServiceInterface {

	List<Producto> findAll();
	
	Producto getProductoById(int idProducto);
	
}
