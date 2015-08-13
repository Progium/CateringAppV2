package com.progium.catering.services;

import java.util.List;

import org.springframework.data.domain.Page;
import com.progium.catering.contracts.PaqueteRequest;
import com.progium.catering.ejb.Paquete;

/**
* Esta clase se encarga de exponer las funcionalidades 
* implementadas por el servicio
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public interface PaqueteServiceInterface {

	List<Paquete> findAll();
	
	Boolean savePaquete(Paquete objPaquete);
	
	Paquete getPaqueteById(int idPaquete);
	
	Page<Paquete> getPaqueteByCateringByIdAdministrador(PaqueteRequest pr, Integer idAdministrador);
	
	List<Paquete> getPaqueteByCateringByIdCatering(Integer idCatering);
	
}
