package com.everis.DAO;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MovimientosDaoImp implements MovimientosDao{

	DataSource ds;
	
	public MovimientosDaoImp() {
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/refBanco");
		} catch (NamingException e) {
			System.err.println("Error al linkear DataSource.");
			e.printStackTrace();
		}
	}
	@Override
	public void ingresar(int cantidad, int idCuenta) {
		// TODO Auto-generated method stub
		
	}

}
