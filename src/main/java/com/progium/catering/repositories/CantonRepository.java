package com.progium.catering.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.progium.catering.ejb.Canton;

/**
* Esta clase se encarga de manejar las operaciones de
* manipulacion de datos
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public interface CantonRepository extends CrudRepository<Canton,Integer> {
	List<Canton> findAll();
	
	List<Canton> findCantonByProvincia(int provincia);
}
