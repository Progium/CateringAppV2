package com.progium.catering.contracts;

/**
* Esta clase se encarga de setear las variables 
* para realizar peticiones al controlador.
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class DistritoRequest extends BasePagingRequest {
	private int distritoId;
	
	public DistritoRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DistritoRequest(int distritoId) {
		super();
		this.setDistritoId(distritoId);
	}

	public int getDistritoId() {
		return distritoId;
	}

	public void setDistritoId(int distritoId) {
		this.distritoId = distritoId;
	}
}
