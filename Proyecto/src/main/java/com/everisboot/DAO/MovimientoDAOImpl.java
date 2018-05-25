package com.everisboot.DAO;

import org.springframework.data.repository.CrudRepository;

import com.everisboot.models.Movimiento;



public interface MovimientoDAOImpl extends CrudRepository<Movimiento, Integer> {
	
	
}