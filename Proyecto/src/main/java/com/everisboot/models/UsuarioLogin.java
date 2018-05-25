package com.everisboot.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuariologin")

public class UsuarioLogin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	public int id;
	public String user;
	public String pass;
	public int idUser;
	public LocalDateTime ultimoAcceso;
	
	public UsuarioLogin() {
		super();
	}

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
		return "Login [id=" + id + ", user=" + user + ", pass=" + pass + ", idUser=" + idUser + ", ultimoAcceso="
				+ ultimoAcceso + "]";
	}

	
	

}
