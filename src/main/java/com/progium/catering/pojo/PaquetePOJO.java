package com.progium.catering.pojo;

import java.util.List;

/**
* Esta clase se encarga de crear el objeto paquete
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class PaquetePOJO{
	
	private int idPaquete;
	private String nombre;
	private String descripcion;
	private int cantidadPersonas;
	private double precio;
	private int descuento;
	private double montoTotal;
	private int idCatering;
	private String nombreCatering;
	private int idTipoEvento;
	private String nombreTipoEvento;
	private List<Integer> catalogoProducto;
	
	
	public PaquetePOJO() {
		super();
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

	public int getIdCatering() {
		return idCatering;
	}

	public void setIdCatering(int idCatering) {
		this.idCatering = idCatering;
	}

	public String getNombreCatering() {
		return nombreCatering;
	}

	public void setNombreCatering(String nombreCatering) {
		this.nombreCatering = nombreCatering;
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

	public List<Integer> getCatalogoProducto() {
		return catalogoProducto;
	}

	public void setCatalogoProducto(List<Integer> catalogoProducto) {
		this.catalogoProducto = catalogoProducto;
	}

}