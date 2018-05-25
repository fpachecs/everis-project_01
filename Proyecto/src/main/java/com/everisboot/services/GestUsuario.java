package com.everisboot.services;

import java.util.Optional;

import com.everisboot.models.Cuenta;
import com.everisboot.models.Usuario;

public interface GestUsuario {	
	public Iterable<Usuario> listUsuario();
	public void saveUsuario(Usuario usur,int id,String nombre, String apellido, int dni);
	public Optional<Usuario> getUsuario(int id);
	public void deleteUsuario(int id);

}
