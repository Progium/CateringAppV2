package com.progium.catering.services;

import java.util.List;

import com.progium.catering.ejb.Eventocatering;

public interface EventoCateringServiceInterface {

	Boolean saveEventoCatering(Eventocatering objEventoCatering);
	//Obtiene todos los catering
	List<Eventocatering> getAll();
	
	//Obtiene la lista de eventos por catering
	List<Eventocatering> getEventoCateringByIdCatering(Integer idCatering);
	
}
