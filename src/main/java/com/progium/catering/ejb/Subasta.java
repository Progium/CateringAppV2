package com.progium.catering.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the subasta database table.
 * 
 */
@Entity
@NamedQuery(name="Subasta.findAll", query="SELECT s FROM Subasta s")
public class Subasta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idSubasta;

	private int cantidadPersonas;

	private String descripcion;

	private byte estado;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHora;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaVencimiento;

	private BigDecimal montoMaximo;

	private String nombre;

	//bi-directional many-to-one association to Categoriasubasta
	@OneToMany(mappedBy="subasta")
	private List<Categoriasubasta> categoriasubastas;

	//bi-directional many-to-one association to Propuestasubasta
	@OneToMany(mappedBy="subasta")
	private List<Propuestasubasta> propuestasubastas;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="clienteId")
	private Usuario usuario;

	//bi-directional many-to-one association to Tipo
	@ManyToOne
	@JoinColumn(name="tipoEventoId")
	private Tipo tipo;

	public Subasta() {
	}

	public int getIdSubasta() {
		return this.idSubasta;
	}

	public void setIdSubasta(int idSubasta) {
		this.idSubasta = idSubasta;
	}

	public int getCantidadPersonas() {
		return this.cantidadPersonas;
	}

	public void setCantidadPersonas(int cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public Date getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Date getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public BigDecimal getMontoMaximo() {
		return this.montoMaximo;
	}

	public void setMontoMaximo(BigDecimal montoMaximo) {
		this.montoMaximo = montoMaximo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Categoriasubasta> getCategoriasubastas() {
		return this.categoriasubastas;
	}

	public void setCategoriasubastas(List<Categoriasubasta> categoriasubastas) {
		this.categoriasubastas = categoriasubastas;
	}

	public Categoriasubasta addCategoriasubasta(Categoriasubasta categoriasubasta) {
		getCategoriasubastas().add(categoriasubasta);
		categoriasubasta.setSubasta(this);

		return categoriasubasta;
	}

	public Categoriasubasta removeCategoriasubasta(Categoriasubasta categoriasubasta) {
		getCategoriasubastas().remove(categoriasubasta);
		categoriasubasta.setSubasta(null);

		return categoriasubasta;
	}

	public List<Propuestasubasta> getPropuestasubastas() {
		return this.propuestasubastas;
	}

	public void setPropuestasubastas(List<Propuestasubasta> propuestasubastas) {
		this.propuestasubastas = propuestasubastas;
	}

	public Propuestasubasta addPropuestasubasta(Propuestasubasta propuestasubasta) {
		getPropuestasubastas().add(propuestasubasta);
		propuestasubasta.setSubasta(this);

		return propuestasubasta;
	}

	public Propuestasubasta removePropuestasubasta(Propuestasubasta propuestasubasta) {
		getPropuestasubastas().remove(propuestasubasta);
		propuestasubasta.setSubasta(null);

		return propuestasubasta;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Tipo getTipo() {
		return this.tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

}