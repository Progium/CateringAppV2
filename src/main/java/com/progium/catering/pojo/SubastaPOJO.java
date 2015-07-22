package com.progium.catering.pojo;

import java.util.Date;

public class SubastaPOJO{
	
	private int idSubasta;
	private String nombre;
	private Date fechaHora;
	private int cantidadPersonas;
	private float montoMinimo;
	private String descripcion;
	private boolean estado;
	private Date fechaVencimiento;
	
	
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
	
	public boolean isEstado() {
		return estado;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	
	
}	