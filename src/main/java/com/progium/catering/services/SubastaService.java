package com.progium.catering.services;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.progium.catering.contracts.SubastaRequest;
import com.progium.catering.repositories.SubastaRepository;
import com.progium.catering.ejb.Subasta;

/**
* Esta clase se encarga dar el comportamiento a las diferentes 
* funcioalidades 
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/

@Service
public class SubastaService implements SubastaServiceInterface{
	
	@Autowired
	SubastaRepository subastaRepository;
	
	/**
	* Este  metodo se encarga de registrar una subasta 
	*
	* @param  CatalogoProducto
	* 
	* @return Boolean
	*
	*/
	@Override
	public Boolean saveSubasta(Subasta objSubasta){
		Subasta objDBSubasta = subastaRepository.save(objSubasta);
		
		Boolean result = true;
		if(objDBSubasta == null){
			result = false;
		}
		return result;
	}
	
	/**
	* Este  metodo se encarga de retornar los todas las subastas dependiendo su estado 
	*
	* @param SubastaRequest
	* @param  Boolean
	* 
	* @return Page<Subasta>
	*
	*/
	@Override
	public Page<Subasta> getSubastaByEstado(SubastaRequest sub,Boolean estado) {
		
		PageRequest pr;
		pr = new PageRequest(sub.getPageNumber(),
				sub.getPageSize());
	
		Page<Subasta> result;
		
		result = subastaRepository.findSubastaByEstado(pr, estado); 
		
		return result;
	}
	
	/**
	* Este  metodo se encarga de retornar los todas las subastas del cliente
	*
	* @param SubastaRequest
	* @param Integer
	* 
	* @return Page<Subasta>
	*
	*/
	@Override
	public Page<Subasta> getSubastaByUsuario(SubastaRequest sub, Integer idUsuario) {
		
		PageRequest pr;
		pr = new PageRequest(sub.getPageNumber(),
				sub.getPageSize());
	
		Page<Subasta> result;
		
		result = subastaRepository.findSubastaByUsuario_idUsuario(pr, idUsuario); 
		
		return result;
	}
	
	/**
	* Este  metodo se encarga de retornar los todas las subastas con fecha evento menor a la fecha actual y estado 0
	*
	* @param  Boolean
	* 
	* @return List<Subasta>
	*
	*/
	@Override
	public List<Subasta> getSubastaByEstadoAndFechaEvento(Boolean estado, Date fechaEvento) {
		
		return subastaRepository.findSubastaByEstadoAndFechaEventoLessThan(estado, fechaEvento);
	}
	
	/**
	* Este  metodo retorna una subasta
	*
	* @param  idProducto
	* 
	* @return Producto
	*
	*/
	@Override
	@Transactional
	public Subasta getSubastaById(int idSubasta) {
		return subastaRepository.findOne(idSubasta);
	}
}
