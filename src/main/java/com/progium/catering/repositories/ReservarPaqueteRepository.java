package com.progium.catering.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.progium.catering.ejb.Reservapaquete;

/**
* Esta clase se encarga de manejar las operaciones de
* manipulacion de datos
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/16
*/
public interface ReservarPaqueteRepository  extends CrudRepository<Reservapaquete,Integer> {
	public static final int PAGE_SIZE = 5;

	public List<Reservapaquete> findAll();
}
