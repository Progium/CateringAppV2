package com.progium.catering.contracts;

import java.util.List;
import com.progium.catering.pojo.PaquetePOJO;


public class PaqueteResponse extends BaseResponse{
	
	private List<PaquetePOJO> paquetes;
	
	
	public PaqueteResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<PaquetePOJO> getPaquetes() {
		return paquetes;
	}

	public void setPaquetes(List<PaquetePOJO> paquetes) {
		this.paquetes = paquetes;
	}

}