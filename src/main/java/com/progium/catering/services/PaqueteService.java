package com.progium.catering.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.progium.catering.ejb.Paquete;
import com.progium.catering.repositories.PaqueteRepository;

/**
* Esta clase se encarga dar el comportamiento a las diferentes 
* funcioalidades 
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/

@Service
public class PaqueteService implements PaqueteServiceInterface{

	@Autowired
	PaqueteRepository paqueteRepository;
	
	/**
	* Este  metodo se encarga de registrar un paquete 
	*
	* @param  Paquete
	* 
	* @return Boolean
	*
	*/
	@Override
	public Boolean savePaquete(Paquete objPaquete) {
		Paquete objDBPaquete = paqueteRepository.save(objPaquete);
		
		Boolean result = true;
		if(objDBPaquete == null){
			result = false;
		}
		return result;
		
	}
	
	@Override
	public List<Paquete> findAll() {
		return paqueteRepository.findAll(); 
	}
	
	@Override
	@Transactional
	public Paquete getPaqueteById(int idPaquete) {
		return paqueteRepository.findOne(idPaquete);
	}
}