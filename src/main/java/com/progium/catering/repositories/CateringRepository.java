package com.progium.catering.repositories;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.progium.catering.ejb.Catering;

public interface CateringRepository extends CrudRepository<Catering,Integer> {
	
	public static final int PAGE_SIZE = 5;
	
	Page<Catering> findAll(Pageable pageable);
	
	List<Catering> findCateringByUsuario_idUsuario
	(Integer idAdministrador);
}
