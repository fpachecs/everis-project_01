package com.everis.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.everis.models.Cuenta;
import com.everis.models.UsuarioLogin;

public class CuentasDaoImp implements CuentasDao{

	DataSource ds;
	
	public CuentasDaoImp() {
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/refBanco");
		} catch (NamingException e) {
			System.err.println("Error al linkear DataSource.");
			e.printStackTrace();
		}
	}

	@Override
	public Cuenta obtenerCuenta(int iduser) {
		String sql = "SELECT * FROM cuenta WHERE idUser = " + iduser;
		try (Connection cn = ds.getConnection();) {
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Cuenta ctn = new Cuenta(rs.getInt("id"), rs.getInt("idUser"), rs.getString("numCuenta"),
						rs.getString("nomBanco"), rs.getBigDecimal("saldo"),
						rs.getTimestamp("fechaDeAlta").toLocalDateTime());
			}			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
