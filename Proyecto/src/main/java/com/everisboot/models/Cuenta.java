package com.everisboot.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cuenta")

@SuppressWarnings("serial")
public class Cuenta implements Serializable {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Id
	@Column(name="id")
	private Integer id;
	@Column(name="iduser")
	private Integer idUser;
	@Column(name="numcuenta")
	private String numCuenta;
	@Column(name="nombanco")
	private String nomBanco;
	@Column(name="saldo")
	private double saldo;
	@Column(name="fechadealta")
	private LocalDateTime fechaDeAlta;
	
	@OneToMany(orphanRemoval = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "idCuenta", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
	private List<Movimiento> movimientos;

	
	public Cuenta() {
		super();
	}

	public Cuenta(Integer id, Integer idUser, String numCuenta, String nomBanco, double saldo, LocalDateTime fechaDeAlta) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.numCuenta = numCuenta;
		this.nomBanco = nomBanco;
		this.saldo = saldo;
		this.fechaDeAlta = fechaDeAlta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
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

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public LocalDateTime getFechaDeAlta() {
		return fechaDeAlta;
	}

	public void setFechaDeAlta(LocalDateTime fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}
	

	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", idUser=" + idUser + ", numCuenta=" + numCuenta + ", nomBanco=" + nomBanco
				+ ", saldo=" + saldo + ", fechaDeAlta=" + fechaDeAlta + "]";
	}
	
	
	

}
