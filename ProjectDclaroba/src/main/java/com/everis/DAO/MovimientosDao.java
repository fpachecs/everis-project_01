package com.everis.DAO;

import java.util.List;

import com.everis.models.Movimiento;

public interface MovimientosDao {
	public void ingresar(int cantidad, int idCuenta);
	public void extraer(int cantidad, int idCuenta);
	public List<Movimiento> obtenerMovimientosCuenta(int idCuenta);
	public List<Movimiento> obtenerMovimientosCuentaPag(int idCuenta, int paginaActual, int registroXPag);
}
