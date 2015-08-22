package com.progium.catering.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.progium.catering.ejb.Reservapaquete;
import com.progium.catering.repositories.ReservarPaqueteRepository;

/**
* Esta clase se encarga dar el comportamiento a las diferentes 
* funcionalidades 
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/16
*/

@Service
public class ReservarPaqueteService implements ReservarPaqueteServiceInterface{

	@Autowired
	ReservarPaqueteRepository reservarPaqueteRepository;
	
	/**
	* Este  metodo se encarga de registrar una reserva de un paquete 
	*
	* @param  Paquete
	* 
	* @return Boolean
	*
	*/
	@Override
	public Boolean saveReservaPaquete(Reservapaquete objReservaPaquete) {
		
		Reservapaquete objDBReservaPaquete = reservarPaqueteRepository.save(objReservaPaquete);
		
		Boolean result = true;
		if(objDBReservaPaquete == null){
			result = false;
		}
		return result;
		
	}
}
