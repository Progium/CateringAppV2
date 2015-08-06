package com.progium.catering.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import com.progium.catering.ejb.Paquete;

public interface PaqueteRepository extends CrudRepository<Paquete,Integer> {
	
	public static final int PAGE_SIZE = 5;

	public List<Paquete> findAll();
	
	Paquete findOne(Integer idPaquete);
}
