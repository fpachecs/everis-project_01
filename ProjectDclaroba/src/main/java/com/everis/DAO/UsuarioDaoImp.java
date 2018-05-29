package com.everis.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.everis.models.Usuario;
import com.everis.models.UsuarioLogin;

public class UsuarioDaoImp implements UsuarioDao{

	DataSource ds;
	
	public UsuarioDaoImp() {
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/refBanco");
		} catch (NamingException e) {
			System.err.println("Error al linkear DataSource.");
			e.printStackTrace();
		}
	}
	@Override
	public Usuario obtenerUsuario(int idUser) {
		String sql = "SELECT * FROM usuario WHERE id = " + idUser;
		try(Connection cn = ds.getConnection();) {
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Usuario user = new Usuario(
						rs.getInt("id"), 
						rs.getString("Nombre"), 
						rs.getString("apellido"),
						rs.getString("dni"));
				return user;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
