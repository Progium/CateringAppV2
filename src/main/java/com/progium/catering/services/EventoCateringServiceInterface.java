package com.progium.catering.services;

import java.util.List;

import org.springframework.data.domain.Page;
import com.progium.catering.contracts.CateringRequest;
import com.progium.catering.ejb.Eventocatering;

public interface EventoCateringServiceInterface {

	Boolean saveEventoCatering(Eventocatering objEventoCatering);
	
	void deleteEventoCatering(Eventocatering objEventoCatering);
	//Obtiene todos los catering
	List<Eventocatering> getAll();
	
	//Obtiene la lista de eventos por catering
	List<Eventocatering> getEventoCateringByIdCatering(Integer idCatering);
	
	//Obtiene la lista de eventos por tipo
	Page<Eventocatering> getEventoCateringByIdTipoEvento(CateringRequest cr);
}
