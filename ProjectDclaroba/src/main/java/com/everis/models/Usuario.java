package com.everis.models;

import java.io.Serializable;

/**
 * Bean para gestionar registros de la tabla banco/Usuario.
 * 
 * @author fpachecs
 *
 */
@SuppressWarnings("serial")
public class Usuario implements Serializable {

	private int id;
	private String nombre;
	private String apellido;
	private String dni;

	public Usuario(int id, String nombre, String apellido, String dni) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [id=");
		builder.append(id);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellido=");
		builder.append(apellido);
		builder.append(", dni=");
		builder.append(dni);
		builder.append("]");
		return builder.toString();
	}

}
