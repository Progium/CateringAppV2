package com.progium.catering.pojo;

import com.progium.catering.ejb.Canton;

public class DistritoPOJO {
	
	private int idDistrito;
	private String nombre;
	private Canton canton;
	private int idCanton;

	
	public DistritoPOJO() {
		super();
	}

	public int getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(int idDistrito) {
		this.idDistrito = idDistrito;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCanton() {
		this.idCanton = this.canton.getIdCanton();
		return idCanton;
	}

	public void setCanton(Canton canton) {
		this.canton = canton;
		setIdCanton(this.canton);
	}

	public void setIdCanton(Canton canton) {
		this.idCanton = canton.getIdCanton();
	}
}