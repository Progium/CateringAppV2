package com.progium.catering.contracts;

import java.util.List;

import com.progium.catering.pojo.TipoPOJO;

public class TipoResponse extends BaseResponse{

	private List<TipoPOJO> tipos;
	
	public TipoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<TipoPOJO> getTipos() {
		return tipos;
	}

	public void setTipos(List<TipoPOJO> tipos) {
		this.tipos = tipos;
	}
	
}
