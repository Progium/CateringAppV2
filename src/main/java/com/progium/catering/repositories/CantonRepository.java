package com.progium.catering.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.progium.catering.ejb.Canton;

public interface CantonRepository extends CrudRepository<Canton,Integer> {
	List<Canton> findAll();
	
	List<Canton> findCantonByProvincia(int provincia);
}
