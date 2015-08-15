package com.progium.catering.pojo;

/**
* Esta clase se encarga de crear el objeto propuesta subasta
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class PropuestaSubastaPOJO{
	
	private int idPropuestaSubasta;
	private int tipoTransaccion;
	private int subastaId;
	private int paqueteId;

	
	public PropuestaSubastaPOJO() {
		super();
	}

	public int getIdPropuestaSubasta() {
		return idPropuestaSubasta;
	}

	public void setIdPropuestaSubasta(int idPropuestaSubasta) {
		this.idPropuestaSubasta = idPropuestaSubasta;
	}

	public int getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(int tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
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