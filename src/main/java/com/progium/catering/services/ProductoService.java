package com.progium.catering.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.progium.catering.contracts.ProductoResponse;
import com.progium.catering.ejb.Producto;
import com.progium.catering.repositories.ProductoRepository;

/**
* Esta clase se encarga dar el comportamiento a las diferentes 
* funcioalidades 
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/

@Service
public class ProductoService implements ProductoServiceInterface{

	@Autowired
	ProductoRepository productoRepository;
	
	
	@Override
	public List<Producto> findAll() {
		return productoRepository.findAll(); 
	}
	
	/**
	* Este  metodo retorna un producto
	*
	* @param  idProducto
	* 
	* @return Producto
	*
	*/
	@Override
	@Transactional
	public Producto getProductoById(int idProducto) {
		return productoRepository.findOne(idProducto);
	}
}