package com.progium.catering.contracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

//import com.progium.catering.ejb.Catering;
import com.progium.catering.pojo.CateringPOJO;

public class CateringResponse extends BaseResponse {

	private List<CateringPOJO> caterings;
	private CateringPOJO catering;
	private int idCatering;

	public CateringResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<CateringPOJO> getCaterings() {
		return caterings;
	}

	public void setCaterings(List<CateringPOJO> caterings) {
		this.caterings = caterings;
	}

	public int getIdCatering() {
		return idCatering;
	}

	public void setIdCatering(int idCatering) {
		this.idCatering = idCatering;
	}
	
	public CateringPOJO getCatering() {
		return catering;
	}

	public void setCatering(CateringPOJO catering) {
		this.catering = catering;
	}

}
