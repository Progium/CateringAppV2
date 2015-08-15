package com.progium.catering.services;

import java.util.List;

import com.progium.catering.ejb.Propuestasubasta;

/**
* Esta clase se encarga de exponer las funcionalidades 
* implementadas por el servicio
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/14
*/
public interface PropuestaSubastaServiceInterface {
	//Registra una propuesta subasta
	Boolean savePropuestaSubasta(Propuestasubasta objPropuestaSubasta);
}
