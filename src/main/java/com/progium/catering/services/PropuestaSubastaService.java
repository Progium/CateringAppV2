package com.progium.catering.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.progium.catering.contracts.PropuestaSubastaRequest;
import com.progium.catering.ejb.Propuestasubasta;
//import com.progium.catering.repositories.PropuestaSubastaRepository;

/**
* Esta clase se encarga dar el comportamiento a las diferentes 
* funcioalidades 
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/

@Service
public class PropuestaSubastaService implements PropuestaSubastaServiceInterface{

	@Autowired
	//PropuestaSubastaRepository propuestaSubastaRepository;
	
	/**
	* Este  metodo se encarga de registrar una propuesta de Subasta
	*
	* @param  Paquete
	* 
	* @return Boolean
	*
	*/
	@Override
	public Boolean savePropuestaSubasta(Propuestasubasta objPropuesta) {
		//Propuestasubasta objDBPropuestaSubasta = propuestaSubastaRepository.save(objPropuesta);
		
		Boolean result = true;
		if(objPropuesta == null){
			result = false;
		}
		return result;
		
	}
	
}