package com.progium.catering.services;

import java.util.List;
import java.util.Date;

import org.springframework.stereotype.Service;
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
	
	//obtiene la subasta por el id usuario cliente
	Page<Subasta> getSubastaByUsuario(SubastaRequest sub, Integer idUsuario);
	
	//obtiene la subasta con fecha menor a la fecha actual y estado 0.
	List<Subasta> getSubastaByEstadoAndFechaEvento(Boolean estado, Date fechaEvento);
	
	//Obtiene una subasta por idSubasta
	Subasta getSubastaById(int idSubasta);
		
}
