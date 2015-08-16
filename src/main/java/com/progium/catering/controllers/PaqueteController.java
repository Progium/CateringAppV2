package com.progium.catering.controllers;

import java.security.NoSuchAlgorithmException;
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

import com.progium.catering.ejb.Catering;
import com.progium.catering.ejb.Paqueteproducto;
import com.progium.catering.ejb.Paquete;
import com.progium.catering.ejb.Reservapaquete;
import com.progium.catering.ejb.Usuario;
import com.progium.catering.ejb.Tipo;
import com.progium.catering.ejb.Catalogoproducto;
import com.progium.catering.contracts.PaqueteResponse;
import com.progium.catering.contracts.PaqueteRequest;
import com.progium.catering.contracts.ReservaPaqueteRequest;
import com.progium.catering.contracts.ReservaPaqueteResponse;
import com.progium.catering.services.CateringServiceInterface;
import com.progium.catering.services.GeneralServiceInterface;
import com.progium.catering.services.PaqueteServiceInterface;
import com.progium.catering.services.PaqueteProductoServiceInterface;
import com.progium.catering.services.CataloProductoServiceInterface;
import com.progium.catering.services.ReservarPaqueteServiceInterface;
import com.progium.catering.services.UsuarioServiceInterface;
import com.progium.catering.utils.SendEmail;
import com.progium.catering.pojo.PaquetePOJO;

/**
* Esta clase se encarga de crear el controlador
* para el manejo de las diferentes funcionalidades 
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
@RestController
@RequestMapping(value = "rest/protected/paquete")
public class PaqueteController {
	
	@Autowired
	PaqueteServiceInterface paqueteService;
	
	@Autowired
	PaqueteProductoServiceInterface paqueteProductoService;
	
	@Autowired
	GeneralServiceInterface generalService;
		
	@Autowired
	CateringServiceInterface cateringService;
	
	@Autowired
	CataloProductoServiceInterface catalogoProductoService;
	
	@Autowired
	UsuarioServiceInterface usuarioService;
	
	@Autowired
	ReservarPaqueteServiceInterface reservaPaqueteService;
	
	@Autowired
	HttpServletRequest request;	
	
	/**
	* Este  metodo se encarga de registrar un paquete de evento 
	*
	* @param  PaqueteRequest
	* 
	* @return PaqueteResponse
	*
	*/
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	@Transactional
	public PaqueteResponse registrar(@RequestBody PaqueteRequest paqueteRequest)throws NoSuchAlgorithmException {
		//Crea un nuevo usuario response le setea los datos y le pasa el objeto de catering al servicio de usuario
		PaqueteResponse pr = new PaqueteResponse();
		Catering objCatering = cateringService.getCateringById(paqueteRequest.getCateringId());
		Tipo objTipo = generalService.getTipoById(paqueteRequest.getEventoId());
		
		Paquete objNuevoPaquete = new Paquete();
		objNuevoPaquete.setNombre(paqueteRequest.getNombre());
		objNuevoPaquete.setDescripcion(paqueteRequest.getDescripcion());
		objNuevoPaquete.setDescripcion(paqueteRequest.getDescripcion());
		objNuevoPaquete.setCantidadPersonas(paqueteRequest.getCantidadPersonas());
		objNuevoPaquete.setPrecio(paqueteRequest.getPrecio());
		objNuevoPaquete.setDescuento(paqueteRequest.getDescuento());
		objNuevoPaquete.setMontoTotal(paqueteRequest.getMontoTotal());
		objNuevoPaquete.setCatering(objCatering);
		objNuevoPaquete.setTipo(objTipo);
		
		Boolean state = paqueteService.savePaquete(objNuevoPaquete);
		
		if (state) {
			pr.setCode(200);
			for(int i = 0; i < paqueteRequest.getCatalogoProducto().size(); i++){
				Paqueteproducto objNuevoPaqueteProducto = new Paqueteproducto();
				Catalogoproducto objCatalogoProducto = catalogoProductoService.getCatalogoProductoById(paqueteRequest.getCatalogoProducto().get(i));
				objNuevoPaqueteProducto.setPaquete(objNuevoPaquete);
				objNuevoPaqueteProducto.setCatalogoproducto(objCatalogoProducto);
				
				Boolean statePaqueteProducto = paqueteProductoService.savePaqueteProducto(objNuevoPaqueteProducto);
			}
			pr.setCodeMessage("catering created succesfully");

		}else{
			pr.setCode(401);
			pr.setErrorMessage("Unauthorized User");
		}
		return pr;
	}
	
	/**
	* Este metodo se encarga de mostrar la lista de paquetes por administrador
	* 
	* @return PaqueteResponse
	*
	*/
	@RequestMapping(value ="/getPaqueteByAdministrador", method = RequestMethod.POST)
	public PaqueteResponse getPqueteByAdministrador(@RequestBody PaqueteRequest paqueteRequest){
		
		PaqueteResponse paqueteResponse = new PaqueteResponse();
		
		HttpSession currentSession = request.getSession();
		int idUsuario = (int) currentSession.getAttribute("idUsuario");	
		
		paqueteRequest.setPageNumber(paqueteRequest.getPageNumber() - 1);
		//Le pasa el catering request y obtiene todo los tipos de evento con el criterio de tipo de evento
		Page<Paquete> paquetes =   paqueteService.getPaqueteByCateringByIdAdministrador(paqueteRequest,idUsuario);

		List<PaquetePOJO> listaPaquetePojo = new ArrayList<PaquetePOJO>();
		
		paqueteResponse.setCode(200);
		paqueteResponse.setCodeMessage("paquetes fetch success");
		paqueteResponse.setTotalElements(paquetes.getTotalElements());
		paqueteResponse.setTotalPages(paquetes.getTotalPages());
		//Recorre por cada paquete obtiene y setea los datos en el pojo.
		paquetes.getContent().forEach(paquete->{
			
			PaquetePOJO nPaquete = new PaquetePOJO();
			
			nPaquete.setIdPaquete(paquete.getIdPaquete());
			nPaquete.setNombre(paquete.getNombre());
			nPaquete.setDescripcion(paquete.getDescripcion());
			nPaquete.setCantidadPersonas(paquete.getCantidadPersonas());
			nPaquete.setIdCatering(paquete.getCatering().getIdCatering());
			nPaquete.setNombreCatering(paquete.getCatering().getNombre());
			nPaquete.setIdTipoEvento(paquete.getTipo().getIdTipo());
			nPaquete.setNombreTipoEvento(paquete.getTipo().getNombre());
			nPaquete.setPrecio(paquete.getPrecio());
			nPaquete.setDescuento(paquete.getDescuento());
			nPaquete.setMontoTotal(paquete.getMontoTotal());
			
			//Obtiene el id del catalogo del producto del paquete producto por paquete de evento
			List<Paqueteproducto> paqueteProductos =  paqueteProductoService.getPaqueteProductoByIdPaquete(paquete.getIdPaquete());
			List<Integer> idCatalogoProductos = new ArrayList<Integer>();
			for(int i = 0; i < paqueteProductos.size(); i++){
				idCatalogoProductos.add(paqueteProductos.get(i).getCatalogoproducto().getIdCatalogoProducto());
			}
			
			nPaquete.setCatalogoProducto(idCatalogoProductos);
			
			listaPaquetePojo.add(nPaquete);
		});
		
		paqueteResponse.setPaquetes(listaPaquetePojo);
		
		return paqueteResponse;	
		
	}
	
	/**
	* Este metodo se encarga de mostrar la lista de paquetes por catering
	* 
	* @return PaqueteResponse
	*
	*/
	@RequestMapping(value ="/getPaqueteByCatering", method = RequestMethod.POST)
	public PaqueteResponse getPqueteByCatering(@RequestBody PaqueteRequest paqueteRequest){
		
		PaqueteResponse paqueteResponse = new PaqueteResponse();
		
		//Le pasa el catering request y obtiene todo los tipos de evento con el criterio de tipo de evento
		List<Paquete> listaPaquete =   paqueteService.getPaqueteByCateringByIdCatering(paqueteRequest.getCateringId());

		List<PaquetePOJO> listaPaquetePojo = new ArrayList<PaquetePOJO>();
		
		paqueteResponse.setCode(200);
		paqueteResponse.setCodeMessage("paquetes fetch success");
		
		//Recorre por cada paquete obtiene y setea los datos en el pojo.
		for (Paquete paquete : listaPaquete){
			
			PaquetePOJO nPaquete = new PaquetePOJO();
			
			nPaquete.setIdPaquete(paquete.getIdPaquete());
			nPaquete.setNombre(paquete.getNombre());
			nPaquete.setDescripcion(paquete.getDescripcion());
			nPaquete.setCantidadPersonas(paquete.getCantidadPersonas());
			nPaquete.setIdCatering(paquete.getCatering().getIdCatering());
			nPaquete.setNombreCatering(paquete.getCatering().getNombre());
			nPaquete.setIdTipoEvento(paquete.getTipo().getIdTipo());
			nPaquete.setNombreTipoEvento(paquete.getTipo().getNombre());
			nPaquete.setPrecio(paquete.getPrecio());
			nPaquete.setDescuento(paquete.getDescuento());
			nPaquete.setMontoTotal(paquete.getMontoTotal());
			
			//Obtiene el id del catalogo del producto del paquete producto por paquete de evento
			List<Paqueteproducto> paqueteProductos =  paqueteProductoService.getPaqueteProductoByIdPaquete(paquete.getIdPaquete());
			List<Integer> idCatalogoProductos = new ArrayList<Integer>();
			for(int i = 0; i < paqueteProductos.size(); i++){
				idCatalogoProductos.add(paqueteProductos.get(i).getCatalogoproducto().getIdCatalogoProducto());
			}
			
			nPaquete.setCatalogoProducto(idCatalogoProductos);
			
			listaPaquetePojo.add(nPaquete);
		};
		
		paqueteResponse.setPaquetes(listaPaquetePojo);
		
		return paqueteResponse;	
		
	}
	
	/**
	* Este metodo se encarga de obtener los datos de un paquete de un determinado id
	* 
	* @return PaqueteResponse
	*
	*/
	@RequestMapping(value ="/getPaqueteById", method = RequestMethod.POST)
	public PaqueteResponse getPaqueteById(@RequestBody PaqueteRequest paqueteRequest){
		
		PaqueteResponse paqueteResponse = new PaqueteResponse();
		
		//Obtiene el paquete de evento de un id determinado
		Paquete paquete =   paqueteService.getPaqueteById(paqueteRequest.getIdPaquete());

		PaquetePOJO paquetePojo = new PaquetePOJO();
		
		paqueteResponse.setCode(200);
		paqueteResponse.setCodeMessage("paquetes fetch success");
		
		//Setea los datos del paquete en el pojo
		paquetePojo.setIdPaquete(paquete.getIdPaquete());
		paquetePojo.setNombre(paquete.getNombre());
		paquetePojo.setDescripcion(paquete.getDescripcion());
		paquetePojo.setCantidadPersonas(paquete.getCantidadPersonas());
		paquetePojo.setIdCatering(paquete.getCatering().getIdCatering());
		paquetePojo.setNombreCatering(paquete.getCatering().getNombre());
		paquetePojo.setIdTipoEvento(paquete.getTipo().getIdTipo());
		paquetePojo.setNombreTipoEvento(paquete.getTipo().getNombre());
		paquetePojo.setPrecio(paquete.getPrecio());
		paquetePojo.setDescuento(paquete.getDescuento());
		paquetePojo.setMontoTotal(paquete.getMontoTotal());
		
		//Obtiene el id del catalogo del producto del paquete producto por paquete de evento
		List<Paqueteproducto> paqueteProductos =  paqueteProductoService.getPaqueteProductoByIdPaquete(paquete.getIdPaquete());
		List<Integer> idCatalogoProductos = new ArrayList<Integer>();
		for(int i = 0; i < paqueteProductos.size(); i++){
			idCatalogoProductos.add(paqueteProductos.get(i).getCatalogoproducto().getIdCatalogoProducto());
		}
		
		paquetePojo.setCatalogoProducto(idCatalogoProductos);

		paqueteResponse.setPaquete(paquetePojo);
		
		return paqueteResponse;	
		
	}
	
	/**
	* Este  metodo se encarga de registrar una reserva de paqute.
	*
	* @param  reservarPaqueteRequest
	* 
	* @return ReservaPaqueteResponse
	*
	*/
	@RequestMapping(value = "/createReservaPaquete", method = RequestMethod.POST)
	@Transactional
	public ReservaPaqueteResponse createReservaPaquete(@RequestBody ReservaPaqueteRequest reservarPaqueteRequest)throws NoSuchAlgorithmException {
		
		ReservaPaqueteResponse rs = new ReservaPaqueteResponse();
		
		HttpSession currentSession = request.getSession();
		int idUsuario = (int) currentSession.getAttribute("idUsuario");	
		
		Usuario objUsuario = usuarioService.getUsuarioById(idUsuario);
		Paquete objPaquete = paqueteService.getPaqueteById(reservarPaqueteRequest.getPaqueteId());
		
		Reservapaquete objNuevaReservaPaquete = new Reservapaquete();
		objNuevaReservaPaquete.setPaquete(objPaquete);
		objNuevaReservaPaquete.setUsuario(objUsuario);
						
		Boolean state = reservaPaqueteService.saveReservaPaquete(objNuevaReservaPaquete);
			
		if (state) {
			rs.setCode(200);
			rs.setCodeMessage("reserva paquete created succesfully");
			String correo = objPaquete.getCatering().getUsuario().getCorreo();
			String catering = objPaquete.getCatering().getNombre();
			String nombrePaquete = objPaquete.getNombre();
			String cliente = objUsuario.getNombre();

			String mensaje = "Se le informa que el cliente " + cliente + " reservo el paquete " + nombrePaquete +  ", del catering " + catering + ". ";
			SendEmail.sendEmail("Notificación reserva de un paquete",
									correo, "Usuario", 
									"Paquete", mensaje);
		}else{
			rs.setCode(401);
			rs.setErrorMessage("Unauthorized User");
		}
		
		return rs;
	}
}