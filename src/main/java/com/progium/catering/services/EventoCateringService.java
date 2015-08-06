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

@Service
public class EventoCateringService implements EventoCateringServiceInterface{

	@Autowired
	EventoCateringRepository eventoCateringRepository;
	
	@Override
	public Boolean saveEventoCatering(Eventocatering objEventoCatering) {
		Eventocatering objDBEventoCatering = eventoCateringRepository.save(objEventoCatering);
		
		Boolean result = true;
		if(objDBEventoCatering == null){
			result = false;
		}
		return result;
		
	}
	
	
	@Override
	public void deleteEventoCatering(Eventocatering objEventoCatering) {
		eventoCateringRepository.delete(objEventoCatering);	
	}
	
	
	@Override
	@Transactional
	public List<Eventocatering> getAll() {
		return (List<Eventocatering>) eventoCateringRepository.findAll(); 
	}
	
	@Override
	@Transactional
	public List<Eventocatering> getEventoCateringByIdCatering(Integer idCatering) {
		return eventoCateringRepository.findEventoCateringByCatering_idCatering(idCatering);
	}
	
	
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
