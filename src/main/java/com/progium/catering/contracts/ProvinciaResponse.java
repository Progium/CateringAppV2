package com.progium.catering.contracts;


import java.util.List;

import com.progium.catering.pojo.ProvinciaPOJO;

public class ProvinciaResponse  extends BaseResponse{

	private List<ProvinciaPOJO> listaProvincia;

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

}
