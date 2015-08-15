package com.progium.catering.contracts;

import java.util.List;

import com.progium.catering.pojo.TipoPOJO;

/**
* Esta clase se encarga de setear las variables que
* se le envian al controlador de javascript.
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
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
