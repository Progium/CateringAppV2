package com.progium.catering.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.progium.catering.ejb.Distrito;

public interface  DistritoReposity extends CrudRepository<Distrito,Integer> {
	List<Distrito> findAll();

}
