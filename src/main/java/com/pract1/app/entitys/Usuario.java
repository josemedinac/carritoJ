package com.pract1.app.entitys;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "El nombre no puede estar vacío")
	@Column(name = "nombre", nullable = false, length = 30)
	private String nombre;

	@NotBlank(message = "El apellido no puede estar vacío")
	@Column(name = "apellido", nullable = false, length = 30)
	private String apellido;

	@NotNull
	@Column(name = "documento", nullable = false, length = 20)
	private int documento;

	@NotBlank
	@Column(name = "telefono", nullable = false, length = 25)
	private String tel;

	@NotBlank(message = "El email no puede estar vacío")
	@Email(message = "Debe ser un email válido")
	@Column(name = "email", nullable = false, length = 50)
	private String email;

	@NotBlank(message = "La contraseña no puede estar vacía")
	@Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
	@Column(name = "password", nullable = false, length = 50)
	private String password;

	@NotBlank
	@Column(name = "estado", nullable = false, length = 50)
	private String estado;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private List<Carrito> carrito;

	public Usuario(Long id, @NotBlank(message = "El nombre no puede estar vacío") String nombre,
			@NotBlank(message = "El apellido no puede estar vacío") String apellido, @NotNull int documento,
			@NotBlank String tel,
			@NotBlank(message = "El email no puede estar vacío") @Email(message = "Debe ser un email válido") String email,
			@NotBlank(message = "La contraseña no puede estar vacía") @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres") String password,
			List<Carrito> carrito) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.tel = tel;
		this.email = email;
		this.password = password;
		this.carrito = carrito;
	}

	public Usuario() {
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", documento=" + documento
				+ ", tel=" + tel + ", email=" + email + ", password=" + password + ", carrito=" + carrito + "]";
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Carrito> getCarrito() {
		return carrito;
	}

	public void setCarrito(List<Carrito> carrito) {
		this.carrito = carrito;
	}

}
