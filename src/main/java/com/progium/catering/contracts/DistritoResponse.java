package com.progium.catering.contracts;

import java.util.List;

import com.progium.catering.pojo.DistritoPOJO;

/**
* Esta clase se encarga de setear las variables que
* se le envian al controlador de javascript.
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class DistritoResponse extends BaseResponse{

	private List<DistritoPOJO> listaDistrito;
	private DistritoPOJO distrito;

	public DistritoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<DistritoPOJO> getListaDistrito() {
		return listaDistrito;
	}

	public void setListaDistrito(List<DistritoPOJO> listaDistrito) {
		this.listaDistrito = listaDistrito;
	}

	public DistritoPOJO getDistrito() {
		return distrito;
	}

	public void setDistrito(DistritoPOJO distrito) {
		this.distrito = distrito;
	}
}
