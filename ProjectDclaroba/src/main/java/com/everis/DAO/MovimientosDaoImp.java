package com.everis.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.everis.models.Cuenta;
import com.everis.models.Movimiento;

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
		Timestamp fecha = new Timestamp(System.currentTimeMillis());
		String sql = "INSERT INTO movimiento (id, idCuenta, fechaOperacion, cantidad, tipoOperacion) VALUES (NULL,'" + idCuenta + "', '" + fecha + "', '"+ cantidad + "', 'ingresar')";
		try(Connection cn = ds.getConnection();) {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	@Override
	public void extraer(int cantidad, int idCuenta) {
		Timestamp fecha = new Timestamp(System.currentTimeMillis());
		String sql = "INSERT INTO movimiento (id, idCuenta, fechaOperacion, cantidad, tipoOperacion) VALUES (NULL,'" + idCuenta + "', '" + fecha + "', '"+ cantidad + "', 'extraer')";
		try(Connection cn = ds.getConnection();) {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	@Override
	public List<Movimiento> obtenerMovimientosCuenta(int idCuenta) {
		String sql = "SELECT * FROM movimiento WHERE idCuenta = " + idCuenta;
		List<Movimiento> movimientos = new ArrayList<Movimiento>();
		try (Connection cn = ds.getConnection();) {
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Movimiento mv = new Movimiento(
						rs.getInt("id"),
						rs.getInt("idCuenta"), 
						rs.getTimestamp("fechaOperacion").toLocalDateTime(),
						rs.getBigDecimal("cantidad"), 
						rs.getString("tipoOperacion"));
				movimientos.add(mv);				
			}
			return movimientos;			
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
