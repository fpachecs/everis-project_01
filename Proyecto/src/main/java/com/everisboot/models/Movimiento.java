package com.everisboot.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movimiento")

@SuppressWarnings("serial")
public class Movimiento implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	public int id;
	public int idCuenta;
	public LocalDateTime fechaOperacion;
	public double cantidad;
	public String tipoOperacion;
	
	public Movimiento() {
		super();
	}

	public Movimiento(int id, int idCuenta, LocalDateTime fechaOperacion, double cantidad, String tipoOperacion) {
		super();
		this.id = id;
		this.idCuenta = idCuenta;
		this.fechaOperacion = fechaOperacion;
		this.cantidad = cantidad;
		this.tipoOperacion = tipoOperacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
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
