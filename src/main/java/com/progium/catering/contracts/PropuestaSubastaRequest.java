package com.progium.catering.contracts;

/**
* Esta clase se encarga de setear las variables 
* para realizar peticiones al controlador.
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/14
*/
public class PropuestaSubastaRequest extends BasePagingRequest {

	private int subastaId;
	private int paqueteId;
	private int tipoTransaccion;
	
	
	public PropuestaSubastaRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PropuestaSubastaRequest(int subastaId, int paqueteId, int tipoTransaccion) {
		super();
		this.setSubastaId(subastaId);
		this.setPaqueteId(paqueteId);
		this.setTipoTransaccion(tipoTransaccion);
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


	public int getTipoTransaccion() {
		return tipoTransaccion;
	}


	public void setTipoTransaccion(int tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}
	
}