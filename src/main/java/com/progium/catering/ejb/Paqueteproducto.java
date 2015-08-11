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
@Table(name="paqueteproductos")
@NamedQuery(name="Paqueteproducto.findAll", query="SELECT p FROM Paqueteproducto p")
public class Paqueteproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPaqueteProductos;

	//bi-directional many-to-one association to Catalogoproducto
	@ManyToOne
	@JoinColumn(name="productoId")
	private Catalogoproducto catalogoproducto;
	
	//bi-directional many-to-one association to Paquete
	@ManyToOne
	@JoinColumn(name="paqueteId")
	private Paquete paquete;

	public Paqueteproducto() {
	}

	public int getIdPaqueteProductos() {
		return this.idPaqueteProductos;
	}

	public void setIdPaqueteProductos(int idPaqueteProductos) {
		this.idPaqueteProductos = idPaqueteProductos;
	}

	public Catalogoproducto getCatalogoproducto() {
		return this.catalogoproducto;
	}

	public void setCatalogoproducto(Catalogoproducto catalogoproducto) {
		this.catalogoproducto = catalogoproducto;
	}

	public Paquete getPaquete() {
		return this.paquete;
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}
}