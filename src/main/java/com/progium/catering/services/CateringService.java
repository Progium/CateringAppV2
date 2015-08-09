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

/**
* Esta clase se encarga dar el comportamiento a las diferentes 
* funcioalidades 
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/

@Service
public class CateringService implements CateringServiceInterface{

	@Autowired
	CateringRepository cateringRepository;
	
	/**
	* Este  metodo se encarga de registrar un catering 
	*
	* @param  Catering
	* 
	* @return Boolean
	*
	*/
	@Override
	public Boolean saveCatering(Catering objCatering) {
		Catering objDBCatering = cateringRepository.save(objCatering);
		
		Boolean result = true;
		if(objDBCatering == null){
			result = false;
		}
		return result;
	}
	
	/**
	* Este  metodo se encarga buscar un catering dado un determinado id
	*
	* @param  idCatering
	* 
	* @return Catering
	*
	*/
	@Override
	public Catering getCateringById(Integer idCatering){
		return cateringRepository.findOne(idCatering);
	}
	
	/**
	* Este metodo se encarga de retornar los catering de un determinado administrador 
	*
	* @param  Catering
	* 
	* @return List<Catering>
	*
	*/
	@Override
	public List<Catering> getCateringByIdAdministrador(Integer idAdministrador) {
		return cateringRepository.findCateringByUsuario_idUsuario(idAdministrador);
	}
	
	/**
	* Este  metodo se encarga de retornar todos los catering almacenados 
	*
	* @param  
	* 
	* @return List<Catering>
	*
	*/
	@Override
	public List<Catering> getCaterigLista() {
		return (List<Catering>) cateringRepository.findAll(); 
	}
	
	/**
	* Este  metodo se encarga de retornar los todos catering dependiendo su estado 
	*
	* @param  Boolean
	* 
	* @return List<Catering>
	*
	*/
	@Override
	public List<Catering> getCateringByEstado(Boolean estado) {
		return (List<Catering>) cateringRepository.findAll(); 
	}
	
	/**
	* Este  metodo se encarga de retornar los todos los catering almacenados 
	*
	* @param  CateringRequest
	* 
	* @return Page<Catering>
	*
	*/
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
	
	/**
	* Este  metodo se encarga de retornar los catering dado un determinado distrito 
	*
	* @param  CateringRequest
	* 
	* @return  Page<Catering>
	*
	*/
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
