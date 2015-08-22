package com.progium.catering.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.progium.catering.ejb.Categoria;
import com.progium.catering.contracts.BaseResponse;
import com.progium.catering.contracts.CategoriaResponse;
import com.progium.catering.contracts.CategoriaRequest;
import com.progium.catering.services.GeneralServiceInterface;
import com.progium.catering.pojo.CategoriaPOJO;
import com.progium.catering.utils.PojoUtils;

/**
* Esta clase se encarga de crear el controlador
* para el manejo de las diferentes funcionalidades 
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
@RestController
@RequestMapping(value = "rest/protected/categoria")
public class CategoriaController {
	
	@Autowired
	GeneralServiceInterface generalService;
	
	/**
	* Este  metodo se encarga de retornar las categorias
	*
	* 
	* @return CantegoriaResponse
	*
	*/
	@RequestMapping(value ="/getAll", method = RequestMethod.GET)
	public CategoriaResponse getAll(){	
		
		CategoriaResponse categoria = new CategoriaResponse();
		
		List<Categoria> listaCategoria = generalService.getAllCategoria();
		List<CategoriaPOJO> listaCategoriaPojo = new ArrayList<CategoriaPOJO>();
		
		for (Categoria cat : listaCategoria){
			CategoriaPOJO nCategoria = new CategoriaPOJO();
			PojoUtils.pojoMappingUtility(nCategoria,cat);
			listaCategoriaPojo.add(nCategoria);
		}
		
		categoria.setCategorias(listaCategoriaPojo);
		
		return categoria;	
	}	
	
}