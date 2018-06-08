package com.everisboot.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
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
	@Column(name="id")
	private Integer id;
	@Column(name="user")
	private String user;
	@Column(name="pass")
	private String pass;
	@Column(name="iduser")
	private Integer idUser;
	@Column(name="ultimoacceso")
	private LocalDateTime ultimoAcceso;
	
	public UsuarioLogin() {
		super();
	}

	public UsuarioLogin(Integer id, String user, String pass, Integer idUser, LocalDateTime ultimoAcceso) {
		super();
		this.id = id;
		this.user = user;
		this.pass = pass;
		this.idUser = idUser;
		this.ultimoAcceso = ultimoAcceso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
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
