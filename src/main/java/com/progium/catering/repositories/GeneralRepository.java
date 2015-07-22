package com.progium.catering.repositories;

import org.springframework.data.repository.CrudRepository;
import com.progium.catering.ejb.Tipo;

public interface GeneralRepository extends CrudRepository<Tipo,Integer> {
	
	public static final int PAGE_SIZE = 5;
}
