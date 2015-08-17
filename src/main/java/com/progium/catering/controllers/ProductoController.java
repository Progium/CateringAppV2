package com.progium.catering.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.progium.catering.ejb.Producto;
import com.progium.catering.contracts.ProductoResponse;
import com.progium.catering.contracts.ProductoRequest;
import com.progium.catering.services.ProductoServiceInterface;
import com.progium.catering.pojo.ProductoPOJO;
import com.progium.catering.utils.PojoUtils;

/**
* Esta clase se encarga de crear el controlador
* para el manejo de las diferentes funcionalidades 
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
@RestController
@RequestMapping(value = "rest/protected/producto")
public class ProductoController {
	
	@Autowired
	ProductoServiceInterface productoService;
	
	@Autowired
	HttpServletRequest request;	
	
	/**
	* Este  metodo se encarga de retornar todos los productos.
	*
	* @return ProductoResponse
	*
	*/
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@Transactional
	public ProductoResponse getAll(){	
		
		ProductoResponse entityResponse = new ProductoResponse();
		List<Producto> productos = productoService.findAll();
		
		if(productos != null){
			entityResponse.setCode(200);
			entityResponse.setCodeMessage("productos fetch success");
			List<ProductoPOJO> productosPOJO = new ArrayList<ProductoPOJO>();
			
			for(Producto producto : productos){
				ProductoPOJO productoPojo = new ProductoPOJO();
				PojoUtils.pojoMappingUtility(productoPojo, producto);
				productosPOJO.add(productoPojo);
			}
			entityResponse.setProductos(productosPOJO);
		}else{
			entityResponse.setCode(400);
			entityResponse.setErrorMessage("productos could not be retrieved");
		}
		return entityResponse;
	}	
	
	/**
	* Este  metodo se encarga de retornar un producto de un determinado idproducto.
	*
	* @param  productoRequest
	* 
	* @return ProductoResponse
	*
	*/
	@RequestMapping(value = "/getProducto", method = RequestMethod.POST)
	@Transactional
	public ProductoResponse getProducto(@RequestBody ProductoRequest productoRequest)throws NoSuchAlgorithmException {	
		
		ProductoResponse productoResponse = new ProductoResponse();
		
		Producto producto = productoService.getProductoById(productoRequest.getIdProducto());
		ProductoPOJO productoPojo = new ProductoPOJO();
		
		productoPojo.setIdProducto(producto.getIdProducto());
		productoPojo.setNombre(producto.getNombre());
		productoPojo.setCategoria(producto.getCategoria());
		productoPojo.setNombreCategoria(producto.getCategoria().getNombre());
		
		productoResponse.setProducto(productoPojo);
		
		return productoResponse;
		
	}	
}