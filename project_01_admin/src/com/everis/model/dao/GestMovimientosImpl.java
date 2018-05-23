package com.everis.model.dao;

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

import com.everis.model.dao.bean.Movimiento;

/**
 * Implementación de los métodos que gestionan el bean Movimiento.
 * 
 * @author fpachecs
 *
 */
class GestMovimientosImpl implements GestMovimientos {
	DataSource ds;

	public GestMovimientosImpl() {
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/refBanco");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean ingresar(Movimiento mov) {
		boolean resultado = false;
		String sql = "INSERT INTO Movimiento (idCuenta, fechaOperacion, cantidad, tipoOperacion) VALUES(?,?,?,?)";

		try (Connection cn = ds.getConnection();) {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, mov.getIdCuenta());
			ps.setTimestamp(2, Timestamp.valueOf(mov.getFechaOperacion()));
			ps.setBigDecimal(3, mov.getCantidad());
			ps.setString(4, mov.getTipoOperacion());

			if (ps.executeUpdate() > 0) {
				resultado = true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	@Override
	public boolean extraer(Movimiento mov) {
		boolean resultado = false;
		String sql = "INSERT INTO Movimiento (idCuenta, fechaOperacion, cantidad, tipoOperacion) VALUES(?,?,?,?)";

		try (Connection cn = ds.getConnection();) {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, mov.getIdCuenta());
			ps.setTimestamp(2, Timestamp.valueOf(mov.getFechaOperacion()));
			ps.setBigDecimal(3, mov.getCantidad());
			ps.setString(4, mov.getTipoOperacion());

			if (ps.executeUpdate() > 0) {
				resultado = true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	@Override
	public List<Movimiento> getMovimientos(int idCuenta) {
		ArrayList<Movimiento> listaMov = new ArrayList<>();
		String sql = "SELECT * FROM Movimiento WHERE idCuenta = ?";

		try (Connection cn = ds.getConnection();) {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, idCuenta);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Movimiento mov = new Movimiento(rs.getInt("id"), rs.getInt("idCuenta"),
						rs.getTimestamp("fechaOperacion").toLocalDateTime(), rs.getBigDecimal("cantidad"),
						rs.getString("tipoOperacion"));
				listaMov.add(mov);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return listaMov;
	}

}
