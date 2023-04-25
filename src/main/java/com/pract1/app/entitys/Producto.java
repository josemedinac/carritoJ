package com.pract1.app.entitys;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(name = "nombre", nullable = false, length = 50)
	String nombre;

	@Column(name = "descripcion", nullable = true, length = 100)
	String descripcion;

	@NotNull
	@Column(name = "precio", nullable = false, length = 10)
	Double precio;

	@NotNull
	@Column(name = "stock", nullable = false, length = 10)
	Double stock;

	@Column(name = "iva", nullable = true, length = 10)
	Double iva;

	@NotBlank
	@Column(name = "estado", nullable = false, length = 50)
	private String estado;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "item_productos", joinColumns = @JoinColumn(name = "id_producto_fk", nullable = false, referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_itemcarrito_fk", nullable = false, referencedColumnName = "id"))
	private List<ItemCarrito> itemCarrito;

	public Producto(Long id, @NotEmpty String nombre, @NotEmpty String descripcion, @NotNull Double precio, Double iva,
			@NotNull Double stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.iva = iva;
	}

	public Producto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getStock() {
		return stock;
	}

	public void setStock(Double stock) {
		this.stock = stock;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<ItemCarrito> getItemCarrito() {
		return itemCarrito;
	}

	public void setItemCarrito(List<ItemCarrito> itemCarrito) {
		this.itemCarrito = itemCarrito;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", stock=" + stock + "]";
	}
}