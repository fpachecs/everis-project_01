package com.everis.model.dao;

import java.math.BigDecimal;

import com.everis.model.dao.bean.Cuenta;

/**
 * Métodos de gestión relacionados con el bean Cuenta.
 * 
 * @author fpachecs
 *
 */
public interface GestCuentas {

	/**
	 * Obtiene una Cuenta a partir de su id,
	 * 
	 * @param id
	 *            Identificador de Cuenta.
	 * @return Una cuenta encontrada.<br>
	 *         null, en caso contrario.
	 */
	Cuenta getCuenta(int id);

	/**
	 * Obtiene todas las cuentas asociadas a un usuario.
	 * 
	 * @param idUser
	 *            Identificador de usuario.
	 * @return Lista de todas las cuentas disponibles.
	 */
	Cuenta getCuentaPorUsuario(int idUser);

	/**
	 * Actualiza el saldo total de una cuenta.
	 * 
	 * @param cantidad
	 *            Cantidad positiva o negativa.
	 * @param numeroCuenta
	 *            Número de cuenta a actualizar.
	 * @return true, si la actualización ha sido correcta.<br>
	 *         false, en caso contrario.
	 */
	boolean actualizaSaldo(BigDecimal cantidad, int idCuenta);

	/**
	 * Obtiene el saldo total actual de una cuenta.
	 * 
	 * @param numeroCuenta
	 *            Número de cuenta a consultar.
	 * @return El saldo actual.<br>
	 * 		null, en caso de error.
	 */
	BigDecimal obtenSaldoActual(int idCuenta);

}
