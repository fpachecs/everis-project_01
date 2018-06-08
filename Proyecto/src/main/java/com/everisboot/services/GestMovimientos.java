package com.everisboot.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.everisboot.models.Movimiento;

public interface GestMovimientos {
	
	boolean ingresar(Movimiento mov);
	boolean extraer(Movimiento mov);
	//List<Movimiento> dameMovimientos(Integer numCuenta);
	public List<Movimiento> dameMovimientos(Integer numCuenta);
	public Iterable<Movimiento> listMovimiento();
	public void saveMovimiento(Movimiento mov,Integer idmovimiento,Integer numerocuenta, Date fecha,Integer cantidad,String operacion);
	public Optional<Movimiento> getMovimiento(Integer idmovimiento);
	public void deleteMovimiento(Integer idmovimiento);
	
}
