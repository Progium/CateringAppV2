package com.progium.catering.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCategoria;

	private String nombre;

	//bi-directional many-to-one association to Categoriasubasta
	@OneToMany(mappedBy="categoria")
	private List<Categoriasubasta> categoriasubastas;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="categoria")
	private List<Producto> productos;

	public Categoria() {
	}

	public int getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
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
		categoriasubasta.setCategoria(this);

		return categoriasubasta;
	}

	public Categoriasubasta removeCategoriasubasta(Categoriasubasta categoriasubasta) {
		getCategoriasubastas().remove(categoriasubasta);
		categoriasubasta.setCategoria(null);

		return categoriasubasta;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setCategoria(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setCategoria(null);

		return producto;
	}

}