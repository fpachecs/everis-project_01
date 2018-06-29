package com.everisboot.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "movimiento")

@SuppressWarnings("serial")
public class Movimiento implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="idcuenta")
	private Integer idCuenta;
	@Column(name="fechaoperacion")
	private LocalDateTime fechaOperacion;
	@Column(name="cantidad")
	private double cantidad;
	@Column(name="tipooperacion")
	private String tipoOperacion;
	
	@OneToOne(orphanRemoval = false, cascade = CascadeType.ALL)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "idcuenta", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
	private Cuenta cuenta;
	
	public Movimiento() {
		super();
	}

	public Movimiento(Integer id, Integer idCuenta, LocalDateTime fechaOperacion, double cantidad, String tipoOperacion) {
		super();
		this.id = id;
		this.idCuenta = idCuenta;
		this.fechaOperacion = fechaOperacion;
		this.cantidad = cantidad;
		this.tipoOperacion = tipoOperacion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Integer idCuenta) {
		this.idCuenta = idCuenta;
	}

	public LocalDateTime getFechaOperacion() {
		return fechaOperacion;
	}

	public void setFechaOperacion(LocalDateTime fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public String getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	@Override
	public String toString() {
		return "Movimiento [id=" + id + ", idCuenta=" + idCuenta + ", fechaOperacion=" + fechaOperacion + ", cantidad="
				+ cantidad + ", tipoOperacion=" + tipoOperacion + "]";
	}
	
	
	
	
}
