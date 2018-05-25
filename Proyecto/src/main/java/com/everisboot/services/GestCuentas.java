package com.everisboot.services;

import java.util.Optional;

import com.everisboot.models.Cuenta;

public interface GestCuentas {
	
	Cuenta autenticar(int numeroCuenta);
	boolean actualizaSaldo(double cantidad, int numeroCuenta);
	public Iterable<Cuenta> listCuentas();
	public void saveCuentas(Cuenta cuent,int numerocuenta,String nombrecliente, int saldo);
	public Optional<Cuenta> getCuenta(int numerocuenta);
	public void deleteCuenta(int numerocuenta);
	
}
