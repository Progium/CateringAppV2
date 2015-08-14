package com.progium.catering.contracts;

/**
* Esta clase se encarga de setear las variables 
* para realizar peticiones al controlador.
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class PropuestaRequest {

	private  int subastaId;
	private int paqueteId;
	
	
	public PropuestaRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PropuestaRequest(int subastaId, int paqueteId) {
		super();
		this.subastaId = subastaId;
		this.paqueteId = paqueteId;
	}


	public int getSubastaId() {
		return subastaId;
	}


	public void setSubastaId(int subastaId) {
		this.subastaId = subastaId;
	}


	public int getPaqueteId() {
		return paqueteId;
	}


	public void setPaqueteId(int paqueteId) {
		this.paqueteId = paqueteId;
	}
	
}
