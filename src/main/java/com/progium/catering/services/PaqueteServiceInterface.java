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
	//Obtiene todos los paquetes
	List<Paquete> findAll();
	//Registra un paquete
	Boolean savePaquete(Paquete objPaquete);
	
	//Obtiene el paquete por un id paquete
	Paquete getPaqueteById(int idPaquete);
	
	//Obtiene los paquetes registrados por un determinado administrador
	Page<Paquete> getPaqueteByCateringByIdAdministrador(PaqueteRequest pr, Integer idAdministrador);
	
	//Obtiene los paqutes por el id del catering
	List<Paquete> getPaqueteByCateringByIdCatering(Integer idCatering);
	
}
