package com.progium.catering.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.progium.catering.ejb.Provincia;

public interface ProvinciaRepository  extends CrudRepository<Provincia,Integer> {
	List<Provincia> findAll();
}
