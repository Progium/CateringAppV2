package com.progium.catering.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progium.catering.repositories.EventoCateringRepository;
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
	public List<Eventocatering> getAll() {
		return (List<Eventocatering>) eventoCateringRepository.findAll(); 
	}
}
