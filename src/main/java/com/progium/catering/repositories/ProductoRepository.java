package com.progium.catering.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import com.progium.catering.ejb.Producto;

import com.progium.catering.ejb.Producto;


public interface ProductoRepository extends CrudRepository<Producto,Integer> {
	
	public static final int PAGE_SIZE = 5;

	public List<Producto> findAll();
	
	Producto findOne(Integer idProducto);
}