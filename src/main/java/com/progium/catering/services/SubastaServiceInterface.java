package com.progium.catering.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Page;
import com.progium.catering.contracts.SubastaRequest;
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
public interface SubastaServiceInterface {
	Boolean saveSubasta(Subasta objSubasta);
	
	//obtiene la subasta por el estado
	Page<Subasta> getSubastaByEstado(SubastaRequest sub,Boolean estado);
		
}
