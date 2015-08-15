package com.progium.catering.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.progium.catering.ejb.Propuestasubasta;

/**
* Esta clase se encarga de manejar las operaciones de
* manipulacion de datos
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/14
*/
public interface PropuestaSubastaRepository extends CrudRepository<Propuestasubasta,Integer> {

	public static final int PAGE_SIZE = 5;

	public List<Propuestasubasta> findAll();
	//Obtiene la lista de propuesta de una subasta
	List<Propuestasubasta> findPropuestaSubastaBySubasta_idSubasta
	(Integer idSubasta);
	
	//Obtiene la lista de propuesta de una subasta y el tipo sea estado 1
	List<Propuestasubasta> findPropuestaSubastaBytipoTransaccionAndSubasta_idSubasta
	(int tipoTransaccion, Integer idSubasta);
}
