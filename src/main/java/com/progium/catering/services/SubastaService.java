package com.progium.catering.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.progium.catering.ejb.Subasta;
import com.progium.catering.repositories.SubastaRepository;

/**
* Esta clase se encarga dar el comportamiento a las diferentes 
* funcioalidades 
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/

@Service
public class SubastaService implements SubastaServiceInterface{
	
	@Autowired
	SubastaRepository subastaRepository;
	
	/**
	* Este  metodo se encarga de registrar una subasta 
	*
	* @param  CatalogoProducto
	* 
	* @return Boolean
	*
	*/
	@Override
	public Boolean saveSubasta(Subasta objSubasta){
		Subasta objDBSubasta = subastaRepository.save(objSubasta);
		
		Boolean result = true;
		if(objDBSubasta == null){
			result = false;
		}
		return result;
	}
	
}
