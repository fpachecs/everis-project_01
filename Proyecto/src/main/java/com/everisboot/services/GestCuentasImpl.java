package com.everisboot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.everisboot.DAO.CuentaDAOImpl;
import com.everisboot.models.Cuenta;
@Controller
class GestCuentasImpl implements GestCuentas{	
	
	@Autowired
	CuentaDAOImpl implCuenta;	
	
    public GestCuentasImpl(){
    	
    }

	@Override
	public Cuenta autenticar(Integer numeroCuenta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizaSaldo(double cantidad, Integer numeroCuenta) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Iterable<Cuenta> listCuentas() {
		return implCuenta.findAll();
	}
	
	@Override
	public void saveCuentas(Cuenta cuent,Integer numerocuenta,String nombrecliente, Integer saldo) {
		implCuenta.save(cuent);

	}
	@Override
	public Cuenta getCuenta(Integer idCuenta){
		Cuenta result=null;
		if(implCuenta.findById(idCuenta).isPresent()) {
			result=implCuenta.findById(idCuenta).get();
		}				
		return result;
	}
	
	public List<Cuenta> getCuentaByUser(Integer idUser) {
		List<Cuenta> lista = new ArrayList<>();
		Iterable<Cuenta> todas = listCuentas();
		for (Cuenta cuenta : todas) {
			lista.add(cuenta);
		}
		lista=lista.stream().filter(c -> c.getIdUser()==idUser).collect(Collectors.toList());
		return lista;
	}
	
		
	public void deleteCuenta(Integer numerocuenta){
		implCuenta.deleteById(numerocuenta);

	}

}
