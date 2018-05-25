package com.everis.DAO;

import com.everis.models.UsuarioLogin;

public interface UsuarioLoginDao {
	
	public Boolean existe(String usuario);
	public Boolean correcto(String usuario, String contrasena);
	public UsuarioLogin obtenerUsuarioLogin(String usuario, String contrasena);
}
