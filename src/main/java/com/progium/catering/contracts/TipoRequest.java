package com.progium.catering.contracts;

import java.util.List;

/**
* Esta clase se encarga de setear las variables 
* para realizar peticiones al controlador.
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
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
