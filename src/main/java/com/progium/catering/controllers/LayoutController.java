package com.progium.catering.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* Esta clase se encarga de crear el controlador
* para el manejo de las diferentes funcionalidades 
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
@Controller
@RequestMapping(value = "/modulos")
public class LayoutController {			

	//-------------------------------------------------------
	//Catering
	//-------------------------------------------------------
	@RequestMapping(value = "/catering-admin")
	public String getCateringAdmin()
	{
		return "modulos/catering/cateringAdmin";
	}
	
	@RequestMapping(value = "/catering-buscar")
	public String getCateringBuscar()
	{
		return "modulos/catering/cateringBuscar";
	}
	
	@RequestMapping(value = "/catering-listar")
	public String getCateringListar()
	{
		return "modulos/catering/cateringListar";
	}
	
	@RequestMapping(value = "/catering-mostrar-detalle")
	public String getCateringMostrarDetalle()
	{
		return "modulos/catering/cateringMostrarDetalle";
	}
	//-------------------------------------------------------
	//Compartido
	//-------------------------------------------------------
	@RequestMapping(value = "/menu-administrador")
	public String getMenuAdministrador()
	{
		return "modulos/compartido/menuAdministrador";
	}
	
	@RequestMapping(value = "/menu-cliente")
	public String getMenuCliente()
	{
		return "modulos/compartido/menuCliente";
	}

	@RequestMapping(value = "/no-encontrado")
	public String getNoEncontrado()
	{
		return "modulos/compartido/noEncontrado";
	}
	//-------------------------------------------------------
	//Cotizacion
	//-------------------------------------------------------
	@RequestMapping(value = "/cotizacion-registrar")
	public String getCotizacionRegistrar()
	{
		return "modulos/cotizacion/cotizacionRegistrar";
	}
	
	//-------------------------------------------------------
	//Catalago de productos
	//-------------------------------------------------------
	@RequestMapping(value = "/producto-registrar")
	public String getProductoRegistrar()
	{
		return "modulos/producto/productoRegistrar";
	}
	
	@RequestMapping(value = "/producto-agregar")
	public String getProductoAgregar()
	{
		return "modulos/producto/productoAgregar";
	}
	//-------------------------------------------------------
	// Paquete
	// -------------------------------------------------------
	@RequestMapping(value = "/paquete-registrar")
	public String getPaqueteRegistrar() {
		return "modulos/paquete/paqueteRegistrar";
	}
	
	@RequestMapping(value = "/paquete-listar")
	public String getPaqueteListar() {
		return "modulos/paquete/paqueteListar";
	}

	@RequestMapping(value = "/paquete-mostrar-detalle")
	public String getPaqueteMostrarDetalle()
	{
		return "modulos/paquete/paqueteMostrarDetalle";
	}
	//-------------------------------------------------------
	//Seguridad
	//-------------------------------------------------------
	@RequestMapping(value = "/seguridad-iniciar-sesion")
	public String getSeguridadIniciarSesion()
	{
		return "modulos/seguridad/inicioSesion";
	}
	
	@RequestMapping(value = "/seguridad-usuario-admin")
	public String getSeguridadUsuarioAdmin()
	{
		return "modulos/seguridad/usuarioAdmin";
	}
	
	@RequestMapping(value = "/seguridad-usuario-perfil")
	public String getSeguridadUsuarioPerfil()
	{
		return "modulos/seguridad/usuarioPerfil";
	}
	
	@RequestMapping(value = "/seguridad-usuario-olvidar")
	public String getSeguridadOlvidoContrasenna()
	{
		return "modulos/seguridad/olvidoContrasenna";
	}
	
	//-------------------------------------------------------
	//Subasta
	//-------------------------------------------------------
	@RequestMapping(value = "/subasta-registrar")
	public String getSubastaRegistrar()
	{
		return "modulos/subasta/subastaRegistrar";
	}
	
	@RequestMapping(value = "/subasta-listar")
	public String getSubastaListar()
	{
		return "modulos/subasta/subastaListar";
	}
}
