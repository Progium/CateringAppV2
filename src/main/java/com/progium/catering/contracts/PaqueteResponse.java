package com.progium.catering.contracts;

import java.util.List;
import com.progium.catering.pojo.PaquetePOJO;

/**
* Esta clase se encarga de setear las variables que
* se le envian al controlador de javascript.
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
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