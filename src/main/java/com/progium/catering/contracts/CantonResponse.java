package com.progium.catering.contracts;

import java.util.List;

import com.progium.catering.pojo.CantonPOJO;

/**
* Esta clase se encarga de setear las variables que
* se le envian al controlador de javascript.
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class CantonResponse extends BaseResponse{

	private List<CantonPOJO> listaCanton;
	private CantonPOJO canton;
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

	public CantonPOJO getCanton() {
		return canton;
	}

	public void setCanton(CantonPOJO canton) {
		this.canton = canton;
	}


}
