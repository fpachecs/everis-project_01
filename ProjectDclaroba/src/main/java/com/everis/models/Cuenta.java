package com.everis.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Bean para gestionar registros de la tabla banco/Cuenta.
 * 
 * @author fpachecs
 *
 */
@SuppressWarnings("serial")
public class Cuenta implements Serializable {

	private int id;
	private int idUser;
	private String numCuenta;
	private String nomBanco;
	private BigDecimal saldo;
	private LocalDateTime fechaDeAlta;

	public Cuenta(int id, int idUser, String numCuenta, String nomBanco, BigDecimal saldo, LocalDateTime fechaDeAlta) {
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

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	public String getNomBanco() {
		return nomBanco;
	}

	public void setNomBanco(String nomBanco) {
		this.nomBanco = nomBanco;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public LocalDateTime getFechaDeAlta() {
		return fechaDeAlta;
	}

	public void setFechaDeAlta(LocalDateTime fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cuenta [id=");
		builder.append(id);
		builder.append(", idUser=");
		builder.append(idUser);
		builder.append(", numCuenta=");
		builder.append(numCuenta);
		builder.append(", nomBanco=");
		builder.append(nomBanco);
		builder.append(", saldo=");
		builder.append(saldo);
		builder.append(", fechaDeAlta=");
		builder.append(fechaDeAlta);
		builder.append("]");
		return builder.toString();
	}
	
}
