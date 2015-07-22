package com.progium.catering.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.progium.catering.ejb.Tipo;

public interface TipoRepository extends CrudRepository<Tipo,Integer> {

	List<Tipo> findAll();
	
	List<Tipo> findTipoByDescripcion(String descripcion);
}
