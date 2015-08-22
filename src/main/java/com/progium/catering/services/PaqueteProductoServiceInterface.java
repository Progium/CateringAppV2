package com.progium.catering.services;

import java.util.List;

import com.progium.catering.ejb.Paqueteproducto;

/**
* Esta clase se encarga de exponer las funcionalidades 
* implementadas por el servicio
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/11
*/
public interface PaqueteProductoServiceInterface {

	Boolean savePaqueteProducto(Paqueteproducto objPaqueteProducto);
	
	//Obtiene la lista de paquetes producto por paquete
	List<Paqueteproducto> getPaqueteProductoByIdPaquete(Integer idPaquete);
}
