package com.everisboot.services;

import java.util.Optional;

import com.everisboot.exception.ExceptionApp;
import com.everisboot.models.UsuarioLogin;

public interface GestUsuarioLogin {
	
	public Iterable<UsuarioLogin> listLogin();
	public void saveLogin(UsuarioLogin log,int id,String user, String password);
	public Optional<UsuarioLogin> getLogin(int id);
	public void deleteLogin(int id);
	public int devuelveId(UsuarioLogin user);
	//public boolean verificarUsuario(String user, String password);
	public boolean existeUsuario(String user);
	public boolean contraseñaCorrecta(String pass);
	public UsuarioLogin login(String user, String pass) throws ExceptionApp;

}
