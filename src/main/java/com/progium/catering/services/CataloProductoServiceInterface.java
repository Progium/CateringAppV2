package com.progium.catering.services;

import java.util.List;
import org.springframework.data.domain.Page;
import com.progium.catering.ejb.Catalogoproducto;
import com.progium.catering.contracts.CatalogoProductoRequest;

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

		//Obtiene el catalogo de producto del catering
		List<Catalogoproducto> getCatalogoProductoByIdCatering(Integer idCatering);
		
		//Obtiene el catalogo de producto del catering
		Page<Catalogoproducto> getCatalogoProductoByIdCatering(CatalogoProductoRequest catalogoProductoRequest);
}
