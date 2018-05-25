package com.everis.DAO;

public interface MovimientosDao {
	public void ingresar(int cantidad, int idCuenta);
	public void extraer(int cantidad, int idCuenta);
}
