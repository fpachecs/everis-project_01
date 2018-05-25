package com.everis.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Bean para gestionar registros de la tabla banco/Movimiento.
 * 
 * @author fpachecs
 *
 */
@SuppressWarnings("serial")
public class Movimiento implements Serializable {

	private int id;
	private int idCuenta;
	private LocalDateTime fechaOperacion;
	private BigDecimal cantidad;
	private String tipoOperacion;

	public Movimiento(int idCuenta, LocalDateTime fechaOperacion, BigDecimal cantidad, String tipoOperacion) {
		super();
		this.idCuenta = idCuenta;
		this.fechaOperacion = fechaOperacion;
		this.cantidad = cantidad;
		this.tipoOperacion = tipoOperacion;
	}

	public Movimiento(int id, int idCuenta, LocalDateTime fechaOperacion, BigDecimal cantidad, String tipoOperacion) {
		this(idCuenta, fechaOperacion, cantidad, tipoOperacion);
		this.id = id;
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

	public BigDecimal getCantidad() {
		return cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
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
		StringBuilder builder = new StringBuilder();
		builder.append("Movimiento [id=");
		builder.append(id);
		builder.append(", idCuenta=");
		builder.append(idCuenta);
		builder.append(", fechaOperacion=");
		builder.append(fechaOperacion);
		builder.append(", cantidad=");
		builder.append(cantidad);
		builder.append(", tipoOperacion=");
		builder.append(tipoOperacion);
		builder.append("]");
		return builder.toString();
	}

}
