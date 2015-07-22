package com.progium.catering.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detallecotizacion database table.
 * 
 */
@Entity
@NamedQuery(name="Detallecotizacion.findAll", query="SELECT d FROM Detallecotizacion d")
public class Detallecotizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idDetalleCotizacion;

	//bi-directional many-to-one association to Cotizacion
	@ManyToOne
	@JoinColumn(name="cotizacionId")
	private Cotizacion cotizacion;

	//bi-directional many-to-one association to Catalogoproducto
	@ManyToOne
	@JoinColumn(name="productoId")
	private Catalogoproducto catalogoproducto;

	public Detallecotizacion() {
	}

	public int getIdDetalleCotizacion() {
		return this.idDetalleCotizacion;
	}

	public void setIdDetalleCotizacion(int idDetalleCotizacion) {
		this.idDetalleCotizacion = idDetalleCotizacion;
	}

	public Cotizacion getCotizacion() {
		return this.cotizacion;
	}

	public void setCotizacion(Cotizacion cotizacion) {
		this.cotizacion = cotizacion;
	}

	public Catalogoproducto getCatalogoproducto() {
		return this.catalogoproducto;
	}

	public void setCatalogoproducto(Catalogoproducto catalogoproducto) {
		this.catalogoproducto = catalogoproducto;
	}

}