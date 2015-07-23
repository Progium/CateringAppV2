package com.progium.catering.services;

import java.util.List;

import com.progium.catering.ejb.Catering;

public interface CateringServiceInterface {

	Boolean saveCatering(Catering objCatering);
	//Obtiene un objeto catering
	Catering getCateringById(Integer idCatering);
	//Obtiene la lista de catering de un usuario
	List<Catering> getCateringByIdAdministrador(Integer idAdministrador);
	//Obtiene todos los catering
	List<Catering> getAll();
	
}
