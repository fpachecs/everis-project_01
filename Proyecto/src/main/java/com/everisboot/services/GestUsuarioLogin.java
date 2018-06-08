package com.everisboot.services;

import java.util.List;
import java.util.Optional;

import com.everisboot.exception.ExceptionApp;
import com.everisboot.models.UsuarioLogin;

public interface GestUsuarioLogin {
	
	public Iterable<UsuarioLogin> listLogin();
	public void saveLogin(UsuarioLogin log);
	public Optional<UsuarioLogin> getLogin(Integer id);
	public void deleteLogin(Integer id);
	public int devuelveId(UsuarioLogin user);
	//public boolean verificarUsuario(String user, String password);
	public boolean existeUsuario(String user);
	public boolean contraseñaCorrecta(String pass);
	public UsuarioLogin login(String user, String pass) throws ExceptionApp;
}
