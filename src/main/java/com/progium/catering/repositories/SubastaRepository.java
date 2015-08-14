package com.progium.catering.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.progium.catering.ejb.Subasta;

/**
* Esta clase se encarga de manejar las operaciones de
* manipulacion de datos
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public interface SubastaRepository extends CrudRepository<Subasta,Integer> {
	public static final int PAGE_SIZE = 5;
	
	Page<Subasta> findAll(Pageable pageable);
	
	Page<Subasta> findSubastaByEstado(Pageable pageable, Boolean estado);
	
	Page<Subasta> findSubastaByUsuario_idUsuario(Pageable pageable, Integer idUsuario);

}
