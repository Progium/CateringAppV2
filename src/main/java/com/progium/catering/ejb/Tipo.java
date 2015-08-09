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
@NamedQuery(name="Tipo.findAll", query="SELECT t FROM Tipo t")
public class Tipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTipo;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Cotizacion
	@OneToMany(mappedBy="tipo")
	private List<Cotizacion> cotizacions;

	//bi-directional many-to-one association to Eventocatering
	@OneToMany(mappedBy="tipo")
	private List<Eventocatering> eventocaterings;

	//bi-directional many-to-one association to Paquete
	@OneToMany(mappedBy="tipo")
	private List<Paquete> paquetes;

	//bi-directional many-to-one association to Propuestasubasta
	@OneToMany(mappedBy="tipo")
	private List<Propuestasubasta> propuestasubastas;

	//bi-directional many-to-one association to Subasta
	@OneToMany(mappedBy="tipo")
	private List<Subasta> subastas;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="tipo")
	private List<Usuario> usuarios;

	public Tipo() {
	}

	public int getIdTipo() {
		return this.idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cotizacion> getCotizacions() {
		return this.cotizacions;
	}

	public void setCotizacions(List<Cotizacion> cotizacions) {
		this.cotizacions = cotizacions;
	}

	public Cotizacion addCotizacion(Cotizacion cotizacion) {
		getCotizacions().add(cotizacion);
		cotizacion.setTipo(this);

		return cotizacion;
	}

	public Cotizacion removeCotizacion(Cotizacion cotizacion) {
		getCotizacions().remove(cotizacion);
		cotizacion.setTipo(null);

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
		eventocatering.setTipo(this);

		return eventocatering;
	}

	public Eventocatering removeEventocatering(Eventocatering eventocatering) {
		getEventocaterings().remove(eventocatering);
		eventocatering.setTipo(null);

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
		paquete.setTipo(this);

		return paquete;
	}

	public Paquete removePaquete(Paquete paquete) {
		getPaquetes().remove(paquete);
		paquete.setTipo(null);

		return paquete;
	}

	public List<Propuestasubasta> getPropuestasubastas() {
		return this.propuestasubastas;
	}

	public void setPropuestasubastas(List<Propuestasubasta> propuestasubastas) {
		this.propuestasubastas = propuestasubastas;
	}

	public Propuestasubasta addPropuestasubasta(Propuestasubasta propuestasubasta) {
		getPropuestasubastas().add(propuestasubasta);
		propuestasubasta.setTipo(this);

		return propuestasubasta;
	}

	public Propuestasubasta removePropuestasubasta(Propuestasubasta propuestasubasta) {
		getPropuestasubastas().remove(propuestasubasta);
		propuestasubasta.setTipo(null);

		return propuestasubasta;
	}

	public List<Subasta> getSubastas() {
		return this.subastas;
	}

	public void setSubastas(List<Subasta> subastas) {
		this.subastas = subastas;
	}

	public Subasta addSubasta(Subasta subasta) {
		getSubastas().add(subasta);
		subasta.setTipo(this);

		return subasta;
	}

	public Subasta removeSubasta(Subasta subasta) {
		getSubastas().remove(subasta);
		subasta.setTipo(null);

		return subasta;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setTipo(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setTipo(null);

		return usuario;
	}

}