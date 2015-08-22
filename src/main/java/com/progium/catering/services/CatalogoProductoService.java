package com.progium.catering.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import com.progium.catering.ejb.Catalogoproducto;
import com.progium.catering.ejb.Paquete;
import com.progium.catering.repositories.CatalogoProductoRepository;
import com.progium.catering.contracts.CatalogoProductoRequest;

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
	
	/**
	* Este  metodo se encarga de retornar el catalogo de producto de un catering
	*
	* @param  idCatering
	* 
	* @return List <Catalogoproducto>
	*
	*/
	@Override
	@Transactional
	public List<Catalogoproducto> getCatalogoProductoByIdCatering(Integer idCatering) {
		return catalogoProductoRepository.findCatalogoProductoByCatering_idCatering(idCatering);
	}
	
	/**
	* Este  metodo se encarga de retornar el catalogo de producto de un catering paginado
	*
	* @param  idCatering
	* 
	* @return Page<Catalogoproducto>
	*
	*/
	@Override
	@Transactional
	public Page<Catalogoproducto> getCatalogoProductoByIdCatering(CatalogoProductoRequest catalogoProductoRequest) {
		PageRequest pr;

		pr = new PageRequest(catalogoProductoRequest.getPageNumber(),
				catalogoProductoRequest.getPageSize());
		
		int cateringId = catalogoProductoRequest.getCateringId().get(0);

		Page<Catalogoproducto> result;
		
		result = catalogoProductoRepository.findCatalogoProductoByCatering_idCatering(cateringId, pr);
		
		return result;
	}
}
