package com.progium.catering.contracts;

import java.util.List;

public class TipoRequest extends BasePagingRequest {
	private int idTipo;
	private List<Integer> tipo;
	
	public TipoRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoRequest(List<Integer> tipoEvento) {
		super();
		this.setTipo(tipoEvento);
	}
	
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public List<Integer> getTipo() {
		return tipo;
	}
	public void setTipo(List<Integer> tipoEvento) {
		this.tipo = tipoEvento;
	}

}
