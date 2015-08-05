package com.progium.catering.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.progium.catering.ejb.Categoria;


public interface CategoriaRepository extends CrudRepository<Categoria,Integer>{
	
	public static final int PAGE_SIZE = 5;
	public List<Categoria> findAll();
	
}
