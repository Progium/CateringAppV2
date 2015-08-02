package com.progium.catering.contracts;

public class ProvinciaRequest extends BasePagingRequest {
	private int provinciaId;
	
	public ProvinciaRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProvinciaRequest(int provinciaId) {
		super();
		this.setProvinciaId(provinciaId);
	}
	
	public int getProvinciaId() {
		return provinciaId;
	}

	public void setProvinciaId(int provinciaId) {
		this.provinciaId = provinciaId;
	}
}
