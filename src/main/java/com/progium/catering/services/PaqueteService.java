package com.progium.catering.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.progium.catering.contracts.PaqueteRequest;
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
	
	/**
	* Este metodo se encarga de retornar los paquetes de un determinado administrador 
	*
	* @param  Paquete
	* 
	* @return Page<Paquete>
	*
	*/
	@Override
	public Page<Paquete> getPaqueteByCateringByIdAdministrador(PaqueteRequest paqueteRequest, Integer idAdministrador) {
		PageRequest pr;

		pr = new PageRequest(paqueteRequest.getPageNumber(),
				paqueteRequest.getPageSize());

		Page<Paquete> result;
		
		result = paqueteRepository.findPaqueteByCatering_Usuario_idUsuario(idAdministrador, pr);
		
		return result;
		
	}
	
	/**
	* Este metodo se encarga de retornar los paquetes de un determinado catering 
	*
	* @param  Paquete
	* 
	* @return List<Paquete>
	*
	*/
	@Override
	public List<Paquete> getPaqueteByCateringByIdCatering(Integer idCatering) {
		
		return paqueteRepository.findPaqueteByCatering_idCatering(idCatering);
		
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