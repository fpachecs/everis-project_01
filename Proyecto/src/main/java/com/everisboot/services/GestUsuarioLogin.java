package com.everisboot.services;

import java.util.Optional;

import com.everisboot.models.UsuarioLogin;

public interface GestUsuarioLogin {
	
	public Iterable<UsuarioLogin> listLogin();
	public void saveLogin(UsuarioLogin log,int id,String user, String password);
	public Optional<UsuarioLogin> getLogin(int id);
	public void deleteLogin(int id);
	public int devuelveId(String user, String password);

}
