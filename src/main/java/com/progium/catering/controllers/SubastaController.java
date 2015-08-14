package com.progium.catering.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.progium.catering.contracts.SubastaResponse;
import com.progium.catering.contracts.SubastaRequest;
import com.progium.catering.services.GeneralServiceInterface;
import com.progium.catering.services.UsuarioServiceInterface;
import com.progium.catering.services.SubastaServiceInterface;
import com.progium.catering.services.EventoCateringServiceInterface;
import com.progium.catering.utils.GeneradorContrasennaUtil;
import com.progium.catering.utils.SendEmail;
import com.progium.catering.utils.Utils;
import com.progium.catering.utils.PojoUtils;
import com.progium.catering.ejb.Subasta;
import com.progium.catering.pojo.SubastaPOJO;

/**
 * Handles requests for the application home page.
 */

/**
* Esta clase se encarga de crear el controlador
* para el manejo de las diferentes funcionalidades 
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/11
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
	* Este metodo se encarga de mostrar la lista de subastas.
	* 
	* @param SubastaRequest
	* @return SubastaResponse
	*
	*/
	@RequestMapping(value ="/getSubastaLista", method = RequestMethod.POST)
	public SubastaResponse getSubastaLista(@RequestBody SubastaRequest subastaRequest){
		
		SubastaResponse subastaResponse = new SubastaResponse();
		
		HttpSession currentSession = request.getSession();
		
		subastaRequest.setPageNumber(subastaRequest.getPageNumber() - 1);
		
		Page<Subasta> listaSubasta = subastaService.getSubastaByEstado(subastaRequest, false);
		List<SubastaPOJO> listaSubastagPojo = new ArrayList<SubastaPOJO>();
		
		subastaResponse.setCode(200);
		subastaResponse.setCodeMessage("paquetes fetch success");
		subastaResponse.setTotalElements(listaSubasta.getTotalElements());
		subastaResponse.setTotalPages(listaSubasta.getTotalPages());
		
		//Recorre por cada subasta obtiene y setea los datos en el pojo.
		listaSubasta.getContent().forEach(subasta->{
			
			SubastaPOJO nSubasta = new SubastaPOJO();
			
			nSubasta.setIdSubasta(subasta.getIdSubasta());
			nSubasta.setNombre(subasta.getNombre());
			nSubasta.setFechaEvento(subasta.getFechaEvento());
			nSubasta.setCantidadPersonas(subasta.getCantidadPersonas());
			nSubasta.setMontoMaximo(subasta.getMontoMaximo());
			nSubasta.setDescripcion(subasta.getDescripcion());
			nSubasta.setIdTipoEvento(subasta.getTipo().getIdTipo());
			nSubasta.setNombreTipoEvento(subasta.getTipo().getNombre());
			
			listaSubastagPojo.add(nSubasta);
		});
		
		subastaResponse.setSubastas(listaSubastagPojo);
		
		return subastaResponse;		
	}
	
	
}