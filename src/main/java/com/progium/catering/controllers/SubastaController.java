package com.progium.catering.controllers;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.progium.catering.ejb.Subasta;
import com.progium.catering.ejb.Tipo;
import com.progium.catering.ejb.Usuario;
import com.progium.catering.contracts.BaseResponse;
import com.progium.catering.contracts.SubastaRequest;
import com.progium.catering.contracts.SubastaResponse;
import com.progium.catering.services.SubastaServiceInterface;
import com.progium.catering.services.GeneralServiceInterface;
import com.progium.catering.pojo.SubastaPOJO;
import com.progium.catering.utils.PojoUtils;

/**
* Esta clase se encarga de crear el controlador
* para el manejo de las diferentes funcionalidades 
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
@RestController
@RequestMapping(value = "rest/protected/subasta")
public class SubastaController {

	@Autowired
	SubastaServiceInterface subastaService;

	@Autowired
	GeneralServiceInterface generalService;

	@Autowired
	ServletContext servletContext;
	
	@Autowired
	HttpServletRequest request;	

	public SubastaController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	* Este  metodo se encarga de registrar una subasta.
	*
	* @param  subastaRequest
	* 
	* @return SubastaResponse
	*
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@Transactional
	public SubastaResponse create(@RequestBody SubastaRequest subastaRequest)throws NoSuchAlgorithmException {
		
			SubastaResponse cs = new SubastaResponse();
			Tipo objTipo = generalService.getTipoById(subastaRequest.getTipoId());
			Usuario objUsuario = generalService.getUsuarioById(subastaRequest.getClienteId());
			
			Subasta objSubasta = new Subasta();
			objSubasta.setNombre(subastaRequest.getNombre());
			objSubasta.setDescripcion(subastaRequest.getDescripcion());
			objSubasta.setCantidadPersonas(subastaRequest.getCantidadPersonas());
			objSubasta.setMontoMaximo(subastaRequest.getMontoMaximo());
			objSubasta.setFechaEvento(subastaRequest.getFechaEvento());
			objSubasta.setTipo(objTipo);
			objSubasta.setUsuario(objUsuario);
					
			Boolean state = subastaService.saveSubasta(objSubasta);
			
			if (state) {
				cs.setCode(200);
				cs.setCodeMessage("subasta created succesfully");

			}else{
				cs.setCode(401);
				cs.setErrorMessage("Unauthorized User");
			}
		
		return cs;
	}

	/**
	* Este metodo se encarga de mostrar la lista de subastas.
	* 
	* @param SubastaRequest
	* @return SubastaResponse
	*
	*/
	@RequestMapping(value ="/getSubastaLista", method = RequestMethod.POST)
	public SubastaResponse getSubastaLista(@RequestBody SubastaRequest subastaRequest){
		
		SubastaResponse subastaResponse = new SubastaResponse();
		
		subastaRequest.setPageNumber(subastaRequest.getPageNumber() - 1);
		
		Page<Subasta> listaSubasta = subastaService.getSubastaByEstado(subastaRequest, false);
		List<SubastaPOJO> listaSubastagPojo = new ArrayList<SubastaPOJO>();
		
		subastaResponse.setCode(200);
		subastaResponse.setCodeMessage("paquetes fetch success");
		subastaResponse.setTotalElements(listaSubasta.getTotalElements());
		subastaResponse.setTotalPages(listaSubasta.getTotalPages());
		
		//Recorre por cada subasta obtiene y setea los datos en el pojo.
		listaSubasta.getContent().forEach(subasta->{
			
			String fechaEvento = new SimpleDateFormat("MM-dd-yyyy").format(subasta.getFechaEvento());

			SubastaPOJO nSubasta = new SubastaPOJO();
			nSubasta.setIdSubasta(subasta.getIdSubasta());
			nSubasta.setNombre(subasta.getNombre());
			nSubasta.setFechaEvento(fechaEvento);
			nSubasta.setCantidadPersonas(subasta.getCantidadPersonas());
			nSubasta.setMontoMaximo(subasta.getMontoMaximo());
			nSubasta.setDescripcion(subasta.getDescripcion());
			nSubasta.setIdTipoEvento(subasta.getTipo().getIdTipo());
			nSubasta.setNombreTipoEvento(subasta.getTipo().getNombre());
			nSubasta.setClienteId(subasta.getUsuario().getIdUsuario());
			
			listaSubastagPojo.add(nSubasta);
		});
		
		subastaResponse.setSubastas(listaSubastagPojo);
		
		return subastaResponse;		
	}

}



