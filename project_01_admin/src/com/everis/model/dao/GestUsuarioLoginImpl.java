package com.everis.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.everis.model.dao.bean.UsuarioLogin;

/**
 * Implementación de los métodos que gestionan el bean Cuenta.
 * 
 * @author fpachecs
 *
 */
class GestUsuarioLoginImpl implements GestUsuarioLogin {
	DataSource ds;

	public GestUsuarioLoginImpl() {
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/refBanco");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public UsuarioLogin autenticar(String user, String pass) {
		UsuarioLogin usuarioLogin = null;
		String sql = "SELECT * FROM UsuarioLogin WHERE user = ? AND pass = ?";

		try (Connection cn = ds.getConnection();) {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				// Crear fecha actual de acceso.
				LocalDateTime ultimoAcceso = LocalDateTime.now();
				usuarioLogin = new UsuarioLogin(rs.getInt("id"), rs.getString("user"), rs.getString("pass"),
						rs.getInt("idUser"), ultimoAcceso);
				// Actualizar registro.
				usuarioLogin = updateUsuarioLogin(usuarioLogin);

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return usuarioLogin;
	}

	@Override
	public UsuarioLogin updateUsuarioLogin(UsuarioLogin usuarioLogin) {
		UsuarioLogin userLogin = null;
		String sql = "UPDATE UsuarioLogin SET ultimoAcceso = ? WHERE id = ?";

		try (Connection cn = ds.getConnection();) {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setTimestamp(1, Timestamp.valueOf(usuarioLogin.getUltimoAcceso()));
			ps.setInt(2, usuarioLogin.getId());
			int result = ps.executeUpdate();
			if (result > 0) {
				userLogin = usuarioLogin;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return userLogin;
	}

}
