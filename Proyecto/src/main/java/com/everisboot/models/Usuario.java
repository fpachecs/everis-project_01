package com.everisboot.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.everisboot.models.cfg.EntityCore;

@Entity
@Table(name = "usuario")

public class Usuario implements EntityCore<Integer> {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "dni")
	private String dni;
	
	

	/*@OneToOne(orphanRemoval = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "iduser", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
	private UsuarioLogin usuarioLogin;

	@OneToMany(orphanRemoval = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "iduser", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
	private List<Cuenta> cuentas;*/

	public Usuario() {
		super();
	}

	public Usuario(Integer id, String nombre, String apellido, String dni) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + "]";
	}

}
