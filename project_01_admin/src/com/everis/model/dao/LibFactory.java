package com.everis.model.dao;

/**
 * Clase factoría que nos da acceso a los DAO.
 * 
 * @author fpachecs
 *
 */
public class LibFactory {
	
	public static GestUsuarioImpl getGestUsuarioImpl() {
		return new GestUsuarioImpl();
	}
	
	public static GestUsuarioLoginImpl getGestUsuarioLoginImpl() {
		return new GestUsuarioLoginImpl();
	}

	public static GestCuentas getGestionCuentas() {
		return new GestCuentasImpl();
	}

	public static GestMovimientos getGestMovimientos() {
		return new GestMovimientosImpl();
	}

}
