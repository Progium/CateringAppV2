package com.progium.catering.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import com.progium.catering.contracts.CateringRequest;
import com.progium.catering.repositories.CateringRepository;
import com.progium.catering.ejb.Catering;

@Service
public class CateringService implements CateringServiceInterface{

	@Autowired
	CateringRepository cateringRepository;
	
	@Override
	public Boolean saveCatering(Catering objCatering) {
		Catering objDBCatering = cateringRepository.save(objCatering);
		
		Boolean result = true;
		if(objDBCatering == null){
			result = false;
		}
		return result;
		
	}
	
	@Override
	public Catering getCateringById(Integer idCatering){
		return cateringRepository.findOne(idCatering);
	}
	
	@Override
	public List<Catering> getCateringByIdAdministrador(Integer idAdministrador) {
		return cateringRepository.findCateringByUsuario_idUsuario(idAdministrador);
	}
	
	@Override
	public List<Catering> getCaterigLista() {
		return (List<Catering>) cateringRepository.findAll(); 
	}
	
	@Override
	public List<Catering> getCateringByEstado(Boolean estado) {
		return (List<Catering>) cateringRepository.findAll(); 
	}
	
	@Override
	@Transactional
	public Page<Catering> getAll(CateringRequest cateringRequest) {
	
		PageRequest pr;
		pr = new PageRequest(cateringRequest.getPageNumber(),
				cateringRequest.getPageSize());
	
		Page<Catering> result;
		
		result = cateringRepository.findAll(pr);
		
		return result;
		
	}
	
	@Override
	@Transactional
	public Page<Catering> getCateringByIdDistrito(CateringRequest cateringRequest) {
		
		PageRequest pr;
		pr = new PageRequest(cateringRequest.getPageNumber(),
				cateringRequest.getPageSize());
	
		Page<Catering> result;
		Integer distritoId = cateringRequest.getDistritoId();
		result = cateringRepository.findCateringByDistrito_idDistrito(distritoId, pr);
		
		return result;
		
	}

	
}
