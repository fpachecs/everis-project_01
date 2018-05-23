package com.everis.model.dao;

import java.util.List;

import com.everis.model.dao.bean.Movimiento;

/**
 * M�todos de gesti�n relacionados con el bean Movimiento.
 * 
 * @author fpachecs
 *
 */
public interface GestMovimientos {

	/**
	 * Crea un Movimiento de ingreso en una cuenta. No actualiza su total.
	 * 
	 * @param mov
	 *            Objeto que contiene informaci�n sobre un movimiento de ingreso.
	 * @return true, si el registro se ha creado correctamente.<br>
	 *         false, en caso contrario.
	 */
	boolean ingresar(Movimiento mov);

	/**
	 * Crea un movimiento de extraci�n en una cuenta. No actualiza su total.
	 * 
	 * @param mov
	 *            Objeto que contiene informaci�n sobre un movimiento de extraci�n.
	 * @return true, si el registro se ha creado correctamente.<br>
	 *         false, en caso contrario.
	 */
	boolean extraer(Movimiento mov);

	/**
	 * Obtiene todos los movimientos existentes de una cuenta.
	 * 
	 * @param idCuenta
	 *            Identificador de cuenta.
	 * @return Una lista de todos los movimientos.
	 */
	List<Movimiento> getMovimientos(int idCuenta);

}
