package com.progium.catering.contracts;

public class DistritoRequest extends BasePagingRequest {
	private int distritoId;
	
	public DistritoRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DistritoRequest(int distritoId) {
		super();
		this.setDistritoId(distritoId);
	}

	public int getDistritoId() {
		return distritoId;
	}

	public void setDistritoId(int distritoId) {
		this.distritoId = distritoId;
	}
}
