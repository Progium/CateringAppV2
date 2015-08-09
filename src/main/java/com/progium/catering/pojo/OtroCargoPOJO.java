package com.progium.catering.pojo;

/**
* Esta clase se encarga de crear el objeto otro cargo
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
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
