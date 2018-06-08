package com.everisboot.services;

import java.util.List;

import com.everisboot.models.Cuenta;

public interface GestCuentas {
	
	Cuenta autenticar(Integer numeroCuenta);
	boolean actualizaSaldo(double cantidad, Integer numeroCuenta);
	public Iterable<Cuenta> listCuentas();
	public void saveCuentas(Cuenta cuent,Integer numerocuenta,String nombrecliente, Integer saldo);
	public Cuenta getCuenta(Integer idCuenta);
	public void deleteCuenta(Integer numerocuenta);
	public List<Cuenta> getCuentaByUser(Integer idUser);
	
}
