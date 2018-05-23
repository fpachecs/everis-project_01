package com.everis.model.dao.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Bean para gestionar registros de la tabla banco/Usuario.
 * 
 * @author fpachecs
 *
 */
@SuppressWarnings("serial")
public class UsuarioLogin implements Serializable {

	private int id;
	private String user;
	private String pass;
	private int idUser;
	private LocalDateTime ultimoAcceso;

	public UsuarioLogin(int id, String user, String pass, int idUser, LocalDateTime ultimoAcceso) {
		super();
		this.id = id;
		this.user = user;
		this.pass = pass;
		this.idUser = idUser;
		this.ultimoAcceso = ultimoAcceso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public LocalDateTime getUltimoAcceso() {
		return ultimoAcceso;
	}

	public void setUltimoAcceso(LocalDateTime ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsuarioLogin [id=");
		builder.append(id);
		builder.append(", user=");
		builder.append(user);
		builder.append(", pass=");
		builder.append(pass);
		builder.append(", idUser=");
		builder.append(idUser);
		builder.append(", ultimoAcceso=");
		builder.append(ultimoAcceso);
		builder.append("]");
		return builder.toString();
	}

}
