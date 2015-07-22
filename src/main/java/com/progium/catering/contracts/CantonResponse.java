package com.progium.catering.contracts;

import java.util.List;

import com.progium.catering.pojo.CantonPOJO;

public class CantonResponse extends BaseResponse{

	private List<CantonPOJO> listaCanton;
	private int idCanton;
	private String nombre;
	private int provinciaId;

	public CantonResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<CantonPOJO> getListaCanton() {
		return listaCanton;
	}

	public void setListaCanton(List<CantonPOJO> listaCanton) {
		this.listaCanton = listaCanton;
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
