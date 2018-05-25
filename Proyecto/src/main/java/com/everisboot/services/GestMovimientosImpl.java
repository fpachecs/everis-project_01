package com.everisboot.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.everisboot.DAO.MovimientoDAOImpl;
import com.everisboot.models.Movimiento;
@Controller
class GestMovimientosImpl implements GestMovimientos{
	
	@Autowired
	MovimientoDAOImpl implMov;
	
    public GestMovimientosImpl(){    	
    }

	@Override
	public boolean ingresar(Movimiento mov) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean extraer(Movimiento mov) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Movimiento> dameMovimientos(int numCuenta) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Iterable<Movimiento> listMovimiento(){
		return implMov.findAll();
	}
	
	public void saveMovimiento(Movimiento mov,int idmovimiento,int numerocuenta, Date fecha,int cantidad,String operacion) {
		//Por hacer
	}
	
	public Optional<Movimiento> getMovimiento(int numerocuenta){
		return implMov.findById(numerocuenta);
	}
	
	public void deleteMovimiento(int idmovimiento) {
		implMov.deleteById(idmovimiento);
	}
	

}
