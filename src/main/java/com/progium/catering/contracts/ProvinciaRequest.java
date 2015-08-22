package com.progium.catering.contracts;

/**
* Esta clase se encarga de setear las variables 
* para realizar peticiones al controlador.
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class ProvinciaRequest extends BasePagingRequest {
	private int provinciaId;
	
	public ProvinciaRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProvinciaRequest(int provinciaId) {
		super();
		this.setProvinciaId(provinciaId);
	}
	
	public int getProvinciaId() {
		return provinciaId;
	}

	public void setProvinciaId(int provinciaId) {
		this.provinciaId = provinciaId;
	}
}
