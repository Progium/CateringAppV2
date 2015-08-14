package com.progium.catering.pojo;

import java.util.Date;

/**
* Esta clase se encarga de crear el objeto subasta
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class SubastaPOJO{
	
	private int idSubasta;
	private String nombre;
	private Date fechaEvento;
	private int cantidadPersonas;
	private double montoMaximo;
	private String descripcion;
	private boolean estado;
	private int idTipoEvento;
	private String nombreTipoEvento;
	
	public SubastaPOJO() {
		super();
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
	
	public void setMontoMaximo(double montoMaximo) {
		this.montoMaximo = montoMaximo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public boolean isEstado() {
		return estado;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getIdTipoEvento() {
		return idTipoEvento;
	}

	public void setIdTipoEvento(int idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}

	public String getNombreTipoEvento() {
		return nombreTipoEvento;
	}

	public void setNombreTipoEvento(String nombreTipoEvento) {
		this.nombreTipoEvento = nombreTipoEvento;
	}
	
}	