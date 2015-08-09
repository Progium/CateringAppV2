package com.progium.catering.contracts;

/**
* Esta clase se encarga de setear las variables 
* para realizar peticiones al controlador.
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class CantonRequest extends BasePagingRequest {

	private int cantonId;
	private String nombre;
	private int provinciaId;

	
	public CantonRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public CantonRequest (int cantonId, String nombre,int provinciaId){
		super();
		this.setCantonId(cantonId);
		this.setNombre(nombre);
		this.setProvinciaId(provinciaId);
		// TODO Auto-generated constructor stub
	}
	
	public CantonRequest (int cantonId){
		super();
		this.setCantonId(cantonId);
		// TODO Auto-generated constructor stub
	}

	public int getCantonId() {
		return cantonId;
	}


	public void setCantonId(int cantonId) {
		this.cantonId = cantonId;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getProvinciaId() {
		return provinciaId;
	}


	public void setProvinciaId(int provinciaId) {
		this.provinciaId = provinciaId;
	}

}
