package com.progium.catering.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.progium.catering.ejb.Eventocatering;

public interface EventoCateringRepository  extends CrudRepository<Eventocatering,Integer> {
public static final int PAGE_SIZE = 5;
	
	Page<Eventocatering> findAll(Pageable pageable);
	
	List<Eventocatering> findEventoCateringByCatering_idCatering
	(Integer idCatering);
	
	Page<Eventocatering> findEventoCateringByTipo_idTipo
	(Integer eventoId, Pageable pageable);
	
}
