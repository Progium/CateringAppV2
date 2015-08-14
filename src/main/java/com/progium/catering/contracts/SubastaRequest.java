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
public class SubastaRequest extends BasePagingRequest {
	private int subastaId;
	private String nombre;
	private Date fechaHora;
	private int cantidadPersonas;
	private float montoMinimo;
	private String descripcion;
	
	public SubastaRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SubastaRequest(int subastaId, String nombre, Date fechaHora,
			int cantidadPersonas, float montoMinimo, String descripcion) {
		super();
		this.subastaId = subastaId;
		this.nombre = nombre;
		this.fechaHora = fechaHora;
		this.cantidadPersonas = cantidadPersonas;
		this.montoMinimo = montoMinimo;
		this.descripcion = descripcion;
	}

	public int getSubastaId() {
		return subastaId;
	}

	public void setSubastaId(int subastaId) {
		this.subastaId = subastaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public int getCantidadPersonas() {
		return cantidadPersonas;
	}

	public void setCantidadPersonas(int cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}

	public float getMontoMinimo() {
		return montoMinimo;
	}

	public void setMontoMinimo(float montoMinimo) {
		this.montoMinimo = montoMinimo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
}
