package com.everis.model.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.everis.model.dao.bean.Cuenta;

/**
 * Implementación de los métodos que gestionan el bean Cuenta.
 * 
 * @author fpachecs
 *
 */
class GestCuentasImpl implements GestCuentas {
	DataSource ds;

	public GestCuentasImpl() {
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/refBanco");
		} catch (NamingException e) {
			System.err.println("Error al linkear DataSource.");
			e.printStackTrace();
		}
	}

	@Override
	public Cuenta getCuenta(int id) {
		Cuenta cuenta = null;
		String sql = "SELECT * FROM Cuenta WHERE id = ?";

		try (Connection cn = ds.getConnection();) {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cuenta = new Cuenta(rs.getInt("id"), rs.getInt("idUser"), rs.getString("numCuenta"),
						rs.getString("nomBanco"), rs.getBigDecimal("saldo"),
						(rs.getTimestamp("fechaDeAlta").toLocalDateTime()));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return cuenta;
	}

	@Override
	public Cuenta getCuentaPorUsuario(int idUser) {
		Cuenta cuenta = null;
		String sql = "SELECT * FROM Cuenta WHERE idUser = ?";

		try (Connection cn = ds.getConnection();) {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, idUser);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cuenta = new Cuenta(rs.getInt("id"), rs.getInt("idUser"), rs.getString("numCuenta"),
						rs.getString("nomBanco"), rs.getBigDecimal("saldo"),
						(rs.getTimestamp("fechaDeAlta").toLocalDateTime()));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return cuenta;
	}

	@Override
	public boolean actualizaSaldo(BigDecimal cantidad, int idCuenta) {
		boolean actualizado = false;
		String sql = "UPDATE Cuenta SET saldo = ? WHERE id = ?";

		try (Connection cn = ds.getConnection();) {
			// Obtener saldo actual y operar.
			BigDecimal saldo = obtenSaldoActual(idCuenta);
			saldo = saldo.add(cantidad);

			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setBigDecimal(1, saldo);
			ps.setInt(2, idCuenta);

			if (ps.executeUpdate() > 0) {
				actualizado = true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return actualizado;
	}

	@Override
	public BigDecimal obtenSaldoActual(int idCuenta) {
		BigDecimal saldo = null;
		String sql = "SELECT saldo FROM Cuenta WHERE id = ?";

		try (Connection cn = ds.getConnection();) {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, idCuenta);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				saldo = rs.getBigDecimal("saldo");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return saldo;
	}

}
