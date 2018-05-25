package com.everisboot.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cuenta")

@SuppressWarnings("serial")
public class Cuenta implements Serializable {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Id
	public int id;
	public int idUser;
	public int numCuenta;
	public String nomBanco;
	public double saldo;
	public Date fechaDeAlta;
	
	public Cuenta() {
		super();
	}

	public Cuenta(int id, int idUser, int numCuenta, String nomBanco, double saldo, Date fechaDeAlta) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.numCuenta = numCuenta;
		this.nomBanco = nomBanco;
		this.saldo = saldo;
		this.fechaDeAlta = fechaDeAlta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(int numCuenta) {
		this.numCuenta = numCuenta;
	}

	public String getNomBanco() {
		return nomBanco;
	}

	public void setNomBanco(String nomBanco) {
		this.nomBanco = nomBanco;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Date getFechaDeAlta() {
		return fechaDeAlta;
	}

	public void setFechaDeAlta(Date fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}

	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", idUser=" + idUser + ", numCuenta=" + numCuenta + ", nomBanco=" + nomBanco
				+ ", saldo=" + saldo + ", fechaDeAlta=" + fechaDeAlta + "]";
	}
	
	
	

}
