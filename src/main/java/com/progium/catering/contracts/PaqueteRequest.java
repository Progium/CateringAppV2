package com.progium.catering.contracts;

/**
* Esta clase se encarga de setear las variables 
* para realizar peticiones al controlador.
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class PaqueteRequest extends BaseResponse {
	 
	private int idPaquete;
	private String nombre;
	private String descripcion;
	private int cantidadPersonas;
	private float precio;
	private int descuento;
	private float montoTotal;

	public PaqueteRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	public PaqueteRequest(String nombre, String descripcion, int cantidadPersonas, float precio, int descuento, float montoTotal) {
		super();
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setCantidadPersonas(cantidadPersonas);
		this.setPrecio(precio);
		this.setDescuento(descuento);
		this.setMontoTotal(montoTotal);
	}
	
	public int getIdPaquete() {
		return idPaquete;
	}

	public void setIdPaquete(int idPaquete) {
		this.idPaquete = idPaquete;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidadPersonas() {
		return cantidadPersonas;
	}

	public void setCantidadPersonas(int cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public float getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}


}