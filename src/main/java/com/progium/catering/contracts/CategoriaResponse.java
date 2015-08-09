package com.progium.catering.contracts;

import java.util.List;

import com.progium.catering.pojo.CategoriaPOJO;

/**
* Esta clase se encarga de setear las variables que
* se le envian al controlador de javascript.
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class CategoriaResponse extends BaseResponse{
	
	private List<CategoriaPOJO> categorias;
	
	public CategoriaResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<CategoriaPOJO> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<CategoriaPOJO> categorias) {
		this.categorias = categorias;
	}
}
