package com.progium.catering.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.progium.catering.ejb.Catalogoproducto;
import com.progium.catering.ejb.Catering;
import com.progium.catering.repositories.CatalogoProductoRepository;

@Service
public class CatalogoProductoService implements CataloProductoServiceInterface{
	
	@Autowired
	CatalogoProductoRepository catalogoProductoRepository;
	
	@Override
	public Boolean saveCatalogoProducto(Catalogoproducto objCatalogoProducto) {
		Catalogoproducto objDBCatalogoProducto = catalogoProductoRepository.save(objCatalogoProducto);
		
		Boolean result = true;
		if(objDBCatalogoProducto == null){
			result = false;
		}
		return result;
	}
	
	public Catalogoproducto getCatalogoProductoById(Integer idCatalogoProducto){
		return catalogoProductoRepository.findOne(idCatalogoProducto);
	}
	
}
