package com.progium.catering.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.progium.catering.repositories.EventoCateringRepository;
import com.progium.catering.contracts.CateringRequest;
import com.progium.catering.ejb.Eventocatering;

/**
* Esta clase se encarga dar el comportamiento a las diferentes 
* funcioalidades 
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/

@Service
public class EventoCateringService implements EventoCateringServiceInterface{

	@Autowired
	EventoCateringRepository eventoCateringRepository;
	
	/**
	* Este  metodo se encarga de registrar un evento catering
	*
	* @param  EventoCatering
	* 
	* @return Boolean
	*
	*/
	@Override
	public Boolean saveEventoCatering(Eventocatering objEventoCatering) {
		Eventocatering objDBEventoCatering = eventoCateringRepository.save(objEventoCatering);
		
		Boolean result = true;
		if(objDBEventoCatering == null){
			result = false;
		}
		return result;
		
	}
	
	/**
	* Este  metodo elimina un evento catering
	*
	* @param  EventoCatering
	*
	*/
	@Override
	public void deleteEventoCatering(Eventocatering objEventoCatering) {
		eventoCateringRepository.delete(objEventoCatering);	
	}
	
	/**
	* Este  metodo se encarga de retornar todos los eventoCatering
	*
	* 
	* @return List <EventoCatering>
	*
	*/
	@Override
	@Transactional
	public List<Eventocatering> getAll() {
		return (List<Eventocatering>) eventoCateringRepository.findAll(); 
	}
	
	/**
	* Este  metodo se encarga de retornar una lista evento catering
	*
	* @param  idCatering
	* 
	* @return List <Eventocatering>
	*
	*/
	@Override
	@Transactional
	public List<Eventocatering> getEventoCateringByIdCatering(Integer idCatering) {
		return eventoCateringRepository.findEventoCateringByCatering_idCatering(idCatering);
	}
	
	/**
	* Este  metodo se encarga de retornar eventocatering por id tipo evento
	*
	* @param  cateringRequest
	* 
	* @return Page<Eventocatering>
	*
	*/
	@Override
	@Transactional
	public Page<Eventocatering> getEventoCateringByIdTipoEvento(CateringRequest cateringRequest) {
	
		PageRequest pr;
		pr = new PageRequest(cateringRequest.getPageNumber(),
				cateringRequest.getPageSize());
	
		int tipoEvento = cateringRequest.getTipoEvento().get(0);
		
		Page<Eventocatering> result;
		
		result = eventoCateringRepository.findEventoCateringByTipo_idTipo(tipoEvento, pr);
		
		return result;
		
	}
	
}
