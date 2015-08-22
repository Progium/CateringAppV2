package com.progium.catering.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
* Esta clase contiene las anotaciones para
* crear la entidad en
* la base de datos
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/09
*/

@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idUsuario;

	private String apellido2;

	private String apellido1;

	private String contrasenna;
	
	@Column(name = "correo", unique = true)
	private String correo;

	private String fotografia;

	private String nombre;

	private String telefono1;

	private String telefono2;

	//bi-directional many-to-one association to Catering
	@OneToMany(mappedBy="usuario")
	private List<Catering> caterings;

	//bi-directional many-to-one association to Cotizacion
	@OneToMany(mappedBy="usuario")
	private List<Cotizacion> cotizacions;

	//bi-directional many-to-one association to Reservapaquete
	@OneToMany(mappedBy="usuario")
	private List<Reservapaquete> reservapaquetes;

	//bi-directional many-to-one association to Subasta
	@OneToMany(mappedBy="usuario")
	private List<Subasta> subastas;

	//bi-directional many-to-one association to Tipo
	@ManyToOne
	@JoinColumn(name="tipoUsuarioId")
	private Tipo tipo;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getContrasenna() {
		return this.contrasenna;
	}

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFotografia() {
		return this.fotografia;
	}

	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public List<Catering> getCaterings() {
		return this.caterings;
	}

	public void setCaterings(List<Catering> caterings) {
		this.caterings = caterings;
	}

	public Catering addCatering(Catering catering) {
		getCaterings().add(catering);
		catering.setUsuario(this);

		return catering;
	}

	public Catering removeCatering(Catering catering) {
		getCaterings().remove(catering);
		catering.setUsuario(null);

		return catering;
	}

	public List<Cotizacion> getCotizacions() {
		return this.cotizacions;
	}

	public void setCotizacions(List<Cotizacion> cotizacions) {
		this.cotizacions = cotizacions;
	}

	public Cotizacion addCotizacion(Cotizacion cotizacion) {
		getCotizacions().add(cotizacion);
		cotizacion.setUsuario(this);

		return cotizacion;
	}

	public Cotizacion removeCotizacion(Cotizacion cotizacion) {
		getCotizacions().remove(cotizacion);
		cotizacion.setUsuario(null);

		return cotizacion;
	}

	public List<Reservapaquete> getReservapaquetes() {
		return this.reservapaquetes;
	}

	public void setReservapaquetes(List<Reservapaquete> reservapaquetes) {
		this.reservapaquetes = reservapaquetes;
	}

	public Reservapaquete addReservapaquete(Reservapaquete reservapaquete) {
		getReservapaquetes().add(reservapaquete);
		reservapaquete.setUsuario(this);

		return reservapaquete;
	}

	public Reservapaquete removeReservapaquete(Reservapaquete reservapaquete) {
		getReservapaquetes().remove(reservapaquete);
		reservapaquete.setUsuario(null);

		return reservapaquete;
	}

	public List<Subasta> getSubastas() {
		return this.subastas;
	}

	public void setSubastas(List<Subasta> subastas) {
		this.subastas = subastas;
	}

	public Subasta addSubasta(Subasta subasta) {
		getSubastas().add(subasta);
		subasta.setUsuario(this);

		return subasta;
	}

	public Subasta removeSubasta(Subasta subasta) {
		getSubastas().remove(subasta);
		subasta.setUsuario(null);

		return subasta;
	}

	public Tipo getTipo() {
		return this.tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

}