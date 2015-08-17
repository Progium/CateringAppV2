package com.progium.catering.contracts;

/**
* Esta clase se encarga de setear las variables 
* para realizar peticiones al controlador.
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/16
*/
public class ReservaPaqueteRequest extends BasePagingRequest {

	private int idReservaPaquete;
	private int usuarioId;
	private int paqueteId;
	
	public ReservaPaqueteRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ReservaPaqueteRequest(int usuarioId, int paqueteId) {
		super();
		this.setUsuarioId(usuarioId);
		this.setPaqueteId(paqueteId);
	}

	public ReservaPaqueteRequest(int paqueteId) {
		super();
		this.setPaqueteId(paqueteId);
	}
	
	public int getIdReservaPaquete() {
		return idReservaPaquete;
	}


	public void setIdReservaPaquete(int idReservaPaquete) {
		this.idReservaPaquete = idReservaPaquete;
	}


	public int getUsuarioId() {
		return usuarioId;
	}


	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}


	public int getPaqueteId() {
		return paqueteId;
	}


	public void setPaqueteId(int paqueteId) {
		this.paqueteId = paqueteId;
	}

}
