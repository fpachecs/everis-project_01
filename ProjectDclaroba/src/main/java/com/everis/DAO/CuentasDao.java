package com.everis.DAO;

import java.util.List;

import com.everis.models.Cuenta;

public interface CuentasDao {

	public Cuenta obtenerCuenta(int iduser, String numCuenta);
	public List<Cuenta> obtenerCuentasUsuario(int iduser);
}
