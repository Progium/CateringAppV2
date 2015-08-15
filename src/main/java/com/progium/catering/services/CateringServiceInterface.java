package com.progium.catering.services;

import java.util.List;
import org.springframework.data.domain.Page;
import com.progium.catering.contracts.CateringRequest;
import com.progium.catering.ejb.Catering;

/**
* Esta clase se encarga de exponer las funcionalidades 
* implementadas por el servicio
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public interface CateringServiceInterface {

	Boolean saveCatering(Catering objCatering);
	//Obtiene un objeto catering
	Catering getCateringById(Integer idCatering);
	//Obtiene la lista de catering de un usuario
	List<Catering> getCateringByIdAdministrador(Integer idAdministrador);
	//Obtiene todos los catering
	List<Catering> getCaterigLista();
	//Obtiene todos los catering
	List<Catering> getCateringByEstado(Boolean estado);
	//Obtiene lista de catering
	Page<Catering> getAll(CateringRequest cr);
	//Obtiene los catering por id distrito
	Page<Catering> getCateringByIdDistrito(CateringRequest cateringRequest);
	//Obtiene lista de catering por nombre
	Page<Catering> getCateringByNombre(CateringRequest cr);
	
}
