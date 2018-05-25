package com.everis.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.everis.models.UsuarioLogin;

public class UsuarioLoginDaoImp implements UsuarioLoginDao {
	DataSource ds;
	
	public UsuarioLoginDaoImp() {
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/refBanco");
		} catch (NamingException e) {
			System.err.println("Error al linkear DataSource.");
			e.printStackTrace();
		}
	}
	
	@Override
	public Boolean existe(String usuario) {
		List<UsuarioLogin> userlogList = this.listar();
		for (UsuarioLogin usuarioLogin : userlogList) {
			if (usuarioLogin.getUser().equals(usuario)) {
				return true;
			}			 
		}
		return false;
	}

	@Override
	public Boolean correcto(String usuario, String contrasena) {
		List<UsuarioLogin> userlogList = this.listar();
		for (UsuarioLogin usuarioLogin : userlogList) {
			if (usuarioLogin.getUser().equals(usuario) && usuarioLogin.getPass().equals(contrasena)) {
				return true;
			}
		}
		return false;
	}
	public List<UsuarioLogin> listar(){
		List<UsuarioLogin> userlogList = new ArrayList<UsuarioLogin>();
		String sql = "SELECT * FROM usuariologin";
		try(Connection cn = ds.getConnection();) {
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UsuarioLogin userlog = new UsuarioLogin(
						rs.getInt("id"), 
						rs.getString("user"), 
						rs.getString("pass"),
						rs.getInt("idUser"), 
						LocalDateTime.now());
				userlogList.add(userlog);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return userlogList;
	}

	@Override
	public UsuarioLogin obtenerUsuarioLogin(String usuario, String contrasena) {
		List<UsuarioLogin> userlogList = this.listar();
		for (UsuarioLogin usuarioLogin : userlogList) {
			if (usuarioLogin.getUser().equals(usuario) && usuarioLogin.getPass().equals(contrasena)) {
				return usuarioLogin;
			}
		}
		return null;
	}

}
