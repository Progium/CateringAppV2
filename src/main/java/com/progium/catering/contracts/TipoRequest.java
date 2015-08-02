package com.progium.catering.contracts;

import java.util.List;

public class TipoRequest extends BasePagingRequest {
	private int idTipo;
	private List<Integer> tipoEvento;
	
	public TipoRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoRequest(List<Integer> tipoEvento) {
		super();
		this.setTipoEvento(tipoEvento);
	}
	
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public List<Integer> getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(List<Integer> tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

}
