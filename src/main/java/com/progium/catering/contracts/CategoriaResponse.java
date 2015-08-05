package com.progium.catering.contracts;

import java.util.List;

import com.progium.catering.pojo.CategoriaPOJO;

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
