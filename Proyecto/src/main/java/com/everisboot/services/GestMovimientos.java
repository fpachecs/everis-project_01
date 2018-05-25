package com.everisboot.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.everisboot.models.Movimiento;

public interface GestMovimientos {
	
	boolean ingresar(Movimiento mov);
	boolean extraer(Movimiento mov);
	//List<Movimiento> dameMovimientos(int numCuenta);
	public List<Movimiento> dameMovimientos(int numCuenta);
	public Iterable<Movimiento> listMovimiento();
	public void saveMovimiento(Movimiento mov,int idmovimiento,int numerocuenta, Date fecha,int cantidad,String operacion);
	public Optional<Movimiento> getMovimiento(int idmovimiento);
	public void deleteMovimiento(int idmovimiento);
	
}
