package com.progium.catering.contracts;

import java.util.List;

import com.progium.catering.pojo.SubastaPOJO;

public class SubastaResponse extends BaseResponse{
	
	private List<SubastaPOJO> subastas;
	private SubastaPOJO subasta;
	private int idSubasta;
	
	public SubastaResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubastaResponse(List<SubastaPOJO> subastas, SubastaPOJO subasta,
			int idSubasta) {
		super();
		this.subastas = subastas;
		this.subasta = subasta;
		this.idSubasta = idSubasta;
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
