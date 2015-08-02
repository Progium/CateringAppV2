package com.progium.catering.contracts;


import java.util.List;

import com.progium.catering.pojo.ProvinciaPOJO;

public class ProvinciaResponse  extends BaseResponse{

	private List<ProvinciaPOJO> listaProvincia;
	private ProvinciaPOJO provincia;

	public ProvinciaResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<ProvinciaPOJO> getListaProvincia() {
		return listaProvincia;
	}

	public void setListaProvincia(List<ProvinciaPOJO> listaProvincia) {
		this.listaProvincia = listaProvincia;
	}

	public ProvinciaPOJO getProvincia() {
		return provincia;
	}

	public void setProvincia(ProvinciaPOJO provincia) {
		this.provincia = provincia;
	}

}
