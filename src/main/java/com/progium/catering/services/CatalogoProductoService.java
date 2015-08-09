package com.progium.catering.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.progium.catering.ejb.Catalogoproducto;
import com.progium.catering.ejb.Catering;
import com.progium.catering.repositories.CatalogoProductoRepository;

/**
* Esta clase se encarga dar el comportamiento a las diferentes 
* funcioalidades 
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/

@Service
public class CatalogoProductoService implements CataloProductoServiceInterface{
	
	@Autowired
	CatalogoProductoRepository catalogoProductoRepository;
	
	/**
	* Este  metodo se encarga de registrar un catalogo producto 
	*
	* @param  CatalogoProducto
	* 
	* @return Boolean
	*
	*/
	@Override
	public Boolean saveCatalogoProducto(Catalogoproducto objCatalogoProducto) {
		Catalogoproducto objDBCatalogoProducto = catalogoProductoRepository.save(objCatalogoProducto);
		
		Boolean result = true;
		if(objDBCatalogoProducto == null){
			result = false;
		}
		return result;
	}
	
	/**
	* Este  metodo se encarga de retornar el catalogo de producto de un determinado idCatalogoProducto 
	*
	* @param  idCatalogoProducto
	* 
	* @return Boolean
	*
	*/
	public Catalogoproducto getCatalogoProductoById(Integer idCatalogoProducto){
		return catalogoProductoRepository.findOne(idCatalogoProducto);
	}
	
}
