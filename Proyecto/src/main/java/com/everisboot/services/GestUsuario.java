package com.everisboot.services;


import com.everisboot.models.Usuario;

public interface GestUsuario {	
	public Iterable<Usuario> listUsuario();
	public void saveUsuario(Usuario usur,int id,String nombre, String apellido, int dni);
	public Usuario getUsuario(int id);
	public void deleteUsuario(int id);

}
