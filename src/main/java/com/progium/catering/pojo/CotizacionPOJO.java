package com.progium.catering.pojo;

/**
* Esta clase se encarga de crear el objeto cotizacion
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class CotizacionPOJO{
	
	private int idCotizacion;
	private String nombre;
	private String telefono;
	private String correo;
	private float montoTotal;
	private float descuento;
	
	public CotizacionPOJO() {
		super();
	}

	public int getIdCotizacion() {
		return idCotizacion;
	}

	public void setIdCotizacion(int idCotizacion) {
		this.idCotizacion = idCotizacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public float getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
}