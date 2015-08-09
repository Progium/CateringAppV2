package com.progium.catering.pojo;

/**
* Esta clase se encarga de crear el objeto reserva paquete
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class ReservaPaquetePOJO {
	
	private int idResevaPaquete;
	private Integer paqueteId;
	private Integer clienteId;
	
	public ReservaPaquetePOJO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdResevaPaquete() {
		return idResevaPaquete;
	}
	
	public void setIdResevaPaquete(int idResevaPaquete) {
		this.idResevaPaquete = idResevaPaquete;
	}
	
	public Integer getPaqueteId() {
		return paqueteId;
	}
	
	public void setPaqueteId(Integer paqueteId) {
		this.paqueteId = paqueteId;
	}
	
	public Integer getClienteId() {
		return clienteId;
	}
	
	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}
	
	
}
