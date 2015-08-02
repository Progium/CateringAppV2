package com.progium.catering.contracts;

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
