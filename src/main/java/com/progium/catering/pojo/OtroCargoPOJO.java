package com.progium.catering.pojo;

public class OtroCargoPOJO {
	
	private int idOtroCargo;
	private String nombre;
	private double precio;
	private Integer cotizacionId;
	
	
	public OtroCargoPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdOtroCargo() {
		return idOtroCargo;
	}
	
	public void setIdOtroCargo(int idOtroCargo) {
		this.idOtroCargo = idOtroCargo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public Integer getCotizacionId() {
		return cotizacionId;
	}
	
	public void setCotizacionId(Integer cotizacionId) {
		this.cotizacionId = cotizacionId;
	}
	
}
