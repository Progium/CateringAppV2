package com.progium.catering.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
* Esta clase con anotaciones para la crear la entidadad en
* la base de datos
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
@Entity
@NamedQuery(name="Propuestasubasta.findAll", query="SELECT p FROM Propuestasubasta p")
public class Propuestasubasta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPropuestaSubasta;
	
	private int tipoTransaccionId;
	
	//bi-directional many-to-one association to Subasta
	@ManyToOne
	@JoinColumn(name="subastaId")
	private Subasta subasta;

	//bi-directional many-to-one association to Paquete
	@ManyToOne
	@JoinColumn(name="paqueteId")
	private Paquete paquete;

	public Propuestasubasta() {
	}

	public int getIdPropuestaSubasta() {
		return this.idPropuestaSubasta;
	}

	public void setIdPropuestaSubasta(int idPropuestaSubasta) {
		this.idPropuestaSubasta = idPropuestaSubasta;
	}

	public Subasta getSubasta() {
		return this.subasta;
	}

	public void setSubasta(Subasta subasta) {
		this.subasta = subasta;
	}

	public Paquete getPaquete() {
		return this.paquete;
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}

	public int getTipoTransaccionId() {
		return tipoTransaccionId;
	}

	public void setTipoTransaccionId(int tipoTransaccionId) {
		this.tipoTransaccionId = tipoTransaccionId;
	}

}