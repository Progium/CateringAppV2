package com.progium.catering.contracts;

import java.util.List;

import com.progium.catering.pojo.DistritoPOJO;

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
