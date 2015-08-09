package com.progium.catering.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
* Esta clase con anotaciones para la crear la entidadad en
* la base de datos
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
@Entity
@NamedQuery(name="Catering.findAll", query="SELECT c FROM Catering c")
public class Catering implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCatering;

	private int cantonId;

	private String cedulaJuridica;

	private String direccion;

	private boolean estado;

	private String fotografia;

	private String horario;

	private String nombre;

	private int provinciaId;

	private String telefono1;

	private String telefono2;

	//bi-directional many-to-one association to Catalogoproducto
	@OneToMany(mappedBy="catering")
	private List<Catalogoproducto> catalogoproductos;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="administradorId")
	private Usuario usuario;

	//bi-directional many-to-one association to Distrito
	@ManyToOne
	@JoinColumn(name="distritoId")
	private Distrito distrito;

	//bi-directional many-to-one association to Cotizacion
	@OneToMany(mappedBy="catering")
	private List<Cotizacion> cotizacions;

	//bi-directional many-to-one association to Eventocatering
	@OneToMany(mappedBy="catering")
	private List<Eventocatering> eventocaterings;

	//bi-directional many-to-one association to Paquete
	@OneToMany(mappedBy="catering")
	private List<Paquete> paquetes;

	public Catering() {
	}

	public int getIdCatering() {
		return this.idCatering;
	}

	public void setIdCatering(int idCatering) {
		this.idCatering = idCatering;
	}

	public int getCantonId() {
		return this.cantonId;
	}

	public void setCantonId(int cantonId) {
		this.cantonId = cantonId;
	}

	public String getCedulaJuridica() {
		return this.cedulaJuridica;
	}

	public void setCedulaJuridica(String cedulaJuridica) {
		this.cedulaJuridica = cedulaJuridica;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean getEstado() {
		return this.estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getFotografia() {
		return this.fotografia;
	}

	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}

	public String getHorario() {
		return this.horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getProvinciaId() {
		return this.provinciaId;
	}

	public void setProvinciaId(int provinciaId) {
		this.provinciaId = provinciaId;
	}

	public String getTelefono1() {
		return this.telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return this.telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public List<Catalogoproducto> getCatalogoproductos() {
		return this.catalogoproductos;
	}

	public void setCatalogoproductos(List<Catalogoproducto> catalogoproductos) {
		this.catalogoproductos = catalogoproductos;
	}

	public Catalogoproducto addCatalogoproducto(Catalogoproducto catalogoproducto) {
		getCatalogoproductos().add(catalogoproducto);
		catalogoproducto.setCatering(this);

		return catalogoproducto;
	}

	public Catalogoproducto removeCatalogoproducto(Catalogoproducto catalogoproducto) {
		getCatalogoproductos().remove(catalogoproducto);
		catalogoproducto.setCatering(null);

		return catalogoproducto;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Distrito getDistrito() {
		return this.distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public List<Cotizacion> getCotizacions() {
		return this.cotizacions;
	}

	public void setCotizacions(List<Cotizacion> cotizacions) {
		this.cotizacions = cotizacions;
	}

	public Cotizacion addCotizacion(Cotizacion cotizacion) {
		getCotizacions().add(cotizacion);
		cotizacion.setCatering(this);

		return cotizacion;
	}

	public Cotizacion removeCotizacion(Cotizacion cotizacion) {
		getCotizacions().remove(cotizacion);
		cotizacion.setCatering(null);

		return cotizacion;
	}

	public List<Eventocatering> getEventocaterings() {
		return this.eventocaterings;
	}

	public void setEventocaterings(List<Eventocatering> eventocaterings) {
		this.eventocaterings = eventocaterings;
	}

	public Eventocatering addEventocatering(Eventocatering eventocatering) {
		getEventocaterings().add(eventocatering);
		eventocatering.setCatering(this);

		return eventocatering;
	}

	public Eventocatering removeEventocatering(Eventocatering eventocatering) {
		getEventocaterings().remove(eventocatering);
		eventocatering.setCatering(null);

		return eventocatering;
	}

	public List<Paquete> getPaquetes() {
		return this.paquetes;
	}

	public void setPaquetes(List<Paquete> paquetes) {
		this.paquetes = paquetes;
	}

	public Paquete addPaquete(Paquete paquete) {
		getPaquetes().add(paquete);
		paquete.setCatering(this);

		return paquete;
	}

	public Paquete removePaquete(Paquete paquete) {
		getPaquetes().remove(paquete);
		paquete.setCatering(null);

		return paquete;
	}

}