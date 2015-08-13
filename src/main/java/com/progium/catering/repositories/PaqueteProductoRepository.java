package com.progium.catering.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.progium.catering.ejb.Paqueteproducto;

/**
* Esta clase se encarga de manejar las operaciones de
* manipulacion de datos
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public interface PaqueteProductoRepository extends CrudRepository<Paqueteproducto,Integer> {
	
	public static final int PAGE_SIZE = 5;

	public List<Paqueteproducto> findAll();
	


}