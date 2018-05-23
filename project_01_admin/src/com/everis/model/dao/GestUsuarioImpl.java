package com.everis.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.everis.model.dao.bean.Usuario;

/**
 * Implementación de los métodos que gestionan el bean Cuenta.
 * 
 * @author fpachecs
 *
 */
class GestUsuarioImpl implements GestUsuario {
	DataSource ds;

	public GestUsuarioImpl() {
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/refBanco");
		} catch (NamingException e) {
			System.err.println("Error al linkear DataSource.");
			e.printStackTrace();
		}
	}

	@Override
	public Usuario getUsuario(int id) {
		Usuario usuario = null;
		String sql = "SELECT * FROM Usuario WHERE id = ?";

		try (Connection cn = ds.getConnection();) {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				usuario = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
						rs.getString("dni"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return usuario;
	}

}
