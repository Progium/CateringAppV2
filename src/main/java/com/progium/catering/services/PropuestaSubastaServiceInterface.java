package com.progium.catering.services;

import java.util.List;

import org.springframework.data.domain.Page;
import com.progium.catering.contracts.PaqueteRequest;
import com.progium.catering.ejb.Propuestasubasta;;

/**
* Esta clase se encarga de exponer las funcionalidades 
* implementadas por el servicio
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public interface PropuestaSubastaServiceInterface {

	
	Boolean savePropuestaSubasta(Propuestasubasta objPropuestaSubasta);
	
	
	
}
