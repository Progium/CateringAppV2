package com.progium.catering.contracts;

public class CantonRequest extends BasePagingRequest {

	private int idCanton;
	private String nombre;
	private int provinciaId;

	
	public CantonRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public CantonRequest (int idCanton, String nombre,int provinciaId){
		super();
		this.setIdCanton(idCanton);
		this.setNombre(nombre);
		this.setProvinciaId(provinciaId);
		// TODO Auto-generated constructor stub
	}
	
	public CantonRequest (int idCanton){
		super();
		this.setIdCanton(idCanton);
		// TODO Auto-generated constructor stub
	}

	public int getIdCanton() {
		return idCanton;
	}


	public void setIdCanton(int idCanton) {
		this.idCanton = idCanton;
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
