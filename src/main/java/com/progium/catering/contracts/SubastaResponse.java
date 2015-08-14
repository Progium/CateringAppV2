package com.progium.catering.contracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.progium.catering.pojo.SubastaPOJO;

/**
* Esta clase se encarga de setear las variables que
* se le envian al controlador de javascript.
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class SubastaResponse extends BaseResponse {

	private List<SubastaPOJO> subastas;
	private SubastaPOJO subasta;
	private int idSubasta;

	public SubastaResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<SubastaPOJO> getSubastas() {
		return subastas;
	}

	public void setSubastas(List<SubastaPOJO> subastas) {
		this.subastas = subastas;
	}

	public SubastaPOJO getSubasta() {
		return subasta;
	}

	public void setSubasta(SubastaPOJO subasta) {
		this.subasta = subasta;
	}

	public int getIdSubasta() {
		return idSubasta;
	}

	public void setIdSubasta(int idSubasta) {
		this.idSubasta = idSubasta;
	}

}
