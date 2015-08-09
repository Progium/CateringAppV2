package com.progium.catering.repositories;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.progium.catering.ejb.Catering;

/**
* Esta clase se encarga de manejar las operaciones de
* manipulacion de datos
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public interface CateringRepository extends CrudRepository<Catering,Integer> {
	
	public static final int PAGE_SIZE = 5;
	
	Page<Catering> findAll(Pageable pageable);
	
	Page<Catering> findCateringByEstado(Pageable pageable, Boolean estado);
	
	List<Catering> findCateringByUsuario_idUsuario
	(Integer idAdministrador);
	
	Page<Catering> findCateringByDistrito_idDistrito(Integer distritoId, Pageable pageable);
	
	Page<Catering> findByNombreContaining(Pageable pageable, String nombre);
	
}
