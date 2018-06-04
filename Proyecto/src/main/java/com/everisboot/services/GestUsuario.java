package com.everisboot.services;


import com.everisboot.models.Usuario;

public interface GestUsuario {	
	public Iterable<Usuario> listUsuario();
	public void saveUsuario(Usuario usur);
	public Usuario getUsuario(Integer idUsuario);
	public void deleteUsuario(Integer id);

}
