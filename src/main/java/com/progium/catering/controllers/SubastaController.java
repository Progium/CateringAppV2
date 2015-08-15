package com.progium.catering.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.text.DateFormat;
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
import com.progium.catering.ejb.Paquete;
import com.progium.catering.ejb.Usuario;
import com.progium.catering.ejb.Propuestasubasta;
import com.progium.catering.contracts.SubastaRequest;
import com.progium.catering.contracts.SubastaResponse;
import com.progium.catering.contracts.PropuestaSubastaRequest;
import com.progium.catering.contracts.PropuestaSubastaResponse;
import com.progium.catering.services.PaqueteServiceInterface;
import com.progium.catering.services.SubastaServiceInterface;
import com.progium.catering.services.PropuestaSubastaServiceInterface;
import com.progium.catering.services.GeneralServiceInterface;
import com.progium.catering.services.UsuarioServiceInterface;
import com.progium.catering.pojo.SubastaPOJO;
import com.progium.catering.utils.SendEmail;

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
	UsuarioServiceInterface usuarioService;

	@Autowired
	GeneralServiceInterface generalService;
	
	@Autowired
	PaqueteServiceInterface paqueteService;
	
	@Autowired
	PropuestaSubastaServiceInterface propuestaSubastaService;

	@Autowired
	ServletContext servletContext;
	
	@Autowired
	HttpServletRequest request;	

	public SubastaController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	* Este metodo se encarga de obetener todos los administradores de catering del sistema
	* y enviarles un correo cuando se crea la subasta.
	* 
	* @param 
	* @return 
	*
	*/
	private void EnviarCorreoAdministradores(){
		
		List<Usuario> listaAdministradores = usuarioService.findByTipoUsuario(2);
		String correo;
		for (Usuario usu : listaAdministradores){
			correo = usu.getCorreo();
			String mensaje = "Se le informa que se ha creado una nueva subasta, en la cual puede entrar a participar ";
			SendEmail.sendEmail("Notificación de subasta",
									correo, "Usuario", 
									"Subasta", mensaje);
		}
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
				EnviarCorreoAdministradores();
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
		
		cambiarEstadoSubasta();
		
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

	/**
	* Este metodo se encarga de mostrar la lista de subastas.
	* 
	* @param SubastaRequest
	* @return SubastaResponse
	*
	*/
	@RequestMapping(value ="/getSubastaByUsuario", method = RequestMethod.POST)
	public SubastaResponse getSubastaByUsuario(@RequestBody SubastaRequest subastaRequest){
		
		SubastaResponse subastaResponse = new SubastaResponse();
		
		subastaRequest.setPageNumber(subastaRequest.getPageNumber() - 1);
		
		HttpSession currentSession = request.getSession();
		int idUsuario = (int) currentSession.getAttribute("idUsuario");	
		
		Page<Subasta> listaSubasta = subastaService.getSubastaByUsuario(subastaRequest, idUsuario);
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
	
	/**
	* Este metodo se encarga de cambiar de estado a todos las subastas que tienen fecha evento 
	* menor a la fecha actual y estado 0
	* 
	* @param 
	* @return 
	*
	*/
	private void cambiarEstadoSubasta(){
	   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	   //get current date time with Date()
	   Date date = new Date();
	   System.out.println(dateFormat.format(date));
	   
	   List<Subasta> listaSubasta = subastaService.getSubastaByEstadoAndFechaEvento(false, date);
		
		//Recorre por cada paquete obtiene y setea los datos en el pojo.
		for (Subasta subasta : listaSubasta){
			subasta.setEstado(true);	
			Boolean state = subastaService.saveSubasta(subasta);
			
		}
	}
	
	/**
	* Este  metodo se encarga de registrar una subasta.
	*
	* @param  PropuestaSubastaRequest
	* 
	* @return PropuestaSubastaResponse
	*
	*/
	@RequestMapping(value = "/createPropuestaSubasta", method = RequestMethod.POST)
	@Transactional
	public PropuestaSubastaResponse createPropuestaSubasta(@RequestBody PropuestaSubastaRequest propuestaSubastaRequest)throws NoSuchAlgorithmException {
		
		PropuestaSubastaResponse ps = new PropuestaSubastaResponse();
		Paquete objPaquete = paqueteService.getPaqueteById(propuestaSubastaRequest.getPaqueteId());
		Subasta objSubasta = subastaService.getSubastaById(propuestaSubastaRequest.getSubastaId());
		
		Propuestasubasta objNuevaPropuesta = new Propuestasubasta();
		objNuevaPropuesta.setTipoTransaccion(0);
		objNuevaPropuesta.setPaquete(objPaquete);
		objNuevaPropuesta.setSubasta(objSubasta);
						
		Boolean state = propuestaSubastaService.savePropuestaSubasta(objNuevaPropuesta);
			
		if (state) {
			ps.setCode(200);
			ps.setCodeMessage("propuesta subasta created succesfully");
			String correo = objPaquete.getCatering().getUsuario().getCorreo();
			String catering = objPaquete.getCatering().getNombre();
			String fechaEvento = new SimpleDateFormat("MM-dd-yyyy").format(objSubasta.getFechaEvento());

			String mensaje = "Se le informa que el catering " + catering + " ha creado una nueva propuesta para la subasta con la fecha de evento " + fechaEvento +  ", por lo que puede entrar a ver la nueva propuesta. ";
			SendEmail.sendEmail("Notificación de nueva propuesta de subasta",
									correo, "Usuario", 
									"Subasta", mensaje);
		}else{
			ps.setCode(401);
			ps.setErrorMessage("Unauthorized User");
		}
		
		return ps;
	}
}



