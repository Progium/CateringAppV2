package com.progium.catering.contracts;

import java.util.Date;

/**
* Esta clase se encarga de setear las variables 
* para realizar peticiones al controlador.
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class SubastaRequest extends BasePagingRequest{
	private int idSubasta;
	private String nombre;
	private Date fechaEvento;
	private int cantidadPersonas;
	private double montoMaximo;
	private String descripcion;
	private boolean estado;
	private int tipoId;
	private int clienteId;
	
	public SubastaRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubastaRequest(int idSubasta, String nombre, Date fechaEvento,
			int cantidadPersonas, double montoMaximo, String descripcion,
			boolean estado, int tipoId, int clienteId) {
		super();
		this.idSubasta = idSubasta;
		this.nombre = nombre;
		this.fechaEvento = fechaEvento;
		this.cantidadPersonas = cantidadPersonas;
		this.montoMaximo = montoMaximo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.tipoId = tipoId;
		this.clienteId = clienteId;
	}

	public int getIdSubasta() {
		return idSubasta;
	}

	public void setIdSubasta(int idSubasta) {
		this.idSubasta = idSubasta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public int getCantidadPersonas() {
		return cantidadPersonas;
	}

	public void setCantidadPersonas(int cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}

	public double getMontoMaximo() {
		return montoMaximo;
	}

	public void setMontoMinimo(double montoMaximo) {
		this.montoMaximo = montoMaximo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public int getTipoId() {
		return tipoId;
	}

	public void setTipoId(int tipoId) {
		this.tipoId = tipoId;
	}
	
	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
}
