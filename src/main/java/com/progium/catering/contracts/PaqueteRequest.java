package com.progium.catering.contracts;

import java.util.List;

/**
* Esta clase se encarga de setear las variables 
* para realizar peticiones al controlador.
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class PaqueteRequest extends BasePagingRequest {
	 
	private int idPaquete;
	private String nombre;
	private String descripcion;
	private int cantidadPersonas;
	private double precio;
	private int descuento;
	private double montoTotal;
	private List<Integer> catalogoProducto;
	private int cateringId;
	private int eventoId;
	public PaqueteRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	public PaqueteRequest(String nombre, String descripcion, int cantidadPersonas, double precio, int descuento, double montoTotal,
							List<Integer> catalogoProducto, int cateringId, int eventoId) {
		super();
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setCantidadPersonas(cantidadPersonas);
		this.setPrecio(precio);
		this.setDescuento(descuento);
		this.setMontoTotal(montoTotal);
		this.setCatalogoProducto(catalogoProducto);
		this.setCateringId(cateringId);
		this.setEventoId(eventoId);
	}
	
	public PaqueteRequest(int idPaquete) {
		super();
		this.setIdPaquete(idPaquete);
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public List<Integer> getCatalogoProducto() {
		return catalogoProducto;
	}

	public void setCatalogoProducto(List<Integer> catalogoProducto) {
		this.catalogoProducto = catalogoProducto;
	}

	public int getCateringId() {
		return cateringId;
	}

	public void setCateringId(int cateringId) {
		this.cateringId = cateringId;
	}

	public int getEventoId() {
		return eventoId;
	}

	public void setEventoId(int eventoId) {
		this.eventoId = eventoId;
	}


}