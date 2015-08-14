package com.progium.catering.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import com.progium.catering.contracts.SubastaRequest;
import com.progium.catering.repositories.SubastaRepository;
import com.progium.catering.ejb.Catering;
import com.progium.catering.ejb.Subasta;

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
	* Este  metodo se encarga de retornar los todas las subastas dependiendo su estado 
	*
	* @param  Boolean
	* 
	* @return Page<Catering>
	*
	*/
	@Override
	public Page<Subasta> getSubastaByEstado(SubastaRequest sub,Boolean estado) {
		
		PageRequest pr;
		pr = new PageRequest(sub.getPageNumber(),
				sub.getPageSize());
	
		Page<Subasta> result;
		
		result = subastaRepository.findSubastaByEstado(pr, estado); 
		
		return result;
	}
	
}
