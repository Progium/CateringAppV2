package com.progium.catering.services;

import java.util.List;

import com.progium.catering.ejb.Paquete;

public interface PaqueteServiceInterface {

	List<Paquete> findAll();
	
	Paquete getPaqueteById(int idPaquete);
	
}
