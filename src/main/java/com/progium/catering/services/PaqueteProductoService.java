package com.progium.catering.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.progium.catering.ejb.Paqueteproducto;
import com.progium.catering.repositories.PaqueteProductoRepository;

/**
* Esta clase se encarga dar el comportamiento a las diferentes 
* funcioalidades 
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/11
*/

@Service
public class PaqueteProductoService implements PaqueteProductoServiceInterface{

	@Autowired
	PaqueteProductoRepository paqueteProductoRepository;
	
	/**
	* Este  metodo se encarga de registrar el producto del paquete 
	*
	* @param  Paquete
	* 
	* @return Boolean
	*
	*/
	@Override
	public Boolean savePaqueteProducto(Paqueteproducto objPaqueteproducto) {
		Paqueteproducto objDBPaqueteProducto = paqueteProductoRepository.save(objPaqueteproducto);
		
		Boolean result = true;
		if(objDBPaqueteProducto == null){
			result = false;
		}
		return result;
		
	}
	
	/**
	* Este  metodo se encarga de retornar la lista de productos del paquete
	*
	* @param  idPaquete
	* 
	* @return List <Paqueteproducto>
	*
	*/
	@Override
	@Transactional
	public List<Paqueteproducto> getPaqueteProductoByIdPaquete(Integer idPaquete) {
		return paqueteProductoRepository.findPaqueteProductoByPaquete_idPaquete(idPaquete);
	}
}
