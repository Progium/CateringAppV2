package com.progium.catering.services;

import com.progium.catering.ejb.Catalogoproducto;

/**
* Esta clase se encarga de exponer las funcionalidades 
* implementadas por el servicio
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public interface CataloProductoServiceInterface {
	
		Boolean saveCatalogoProducto(Catalogoproducto objCatalogoProducto);
		Catalogoproducto getCatalogoProductoById(Integer idCatalogoProducto);
}
