package com.everisboot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.everisboot.DAO.UsuarioDAOImpl;
import com.everisboot.models.Usuario;

class GestUsuarioImpl implements GestUsuario {
	
	@Autowired
	UsuarioDAOImpl implUsuario;
	
	public Iterable<Usuario> listUsuario(){
		return implUsuario.findAll();
	}
	@Override
	public void saveUsuario(Usuario usur,int id,String nombre, String apellido, int dni) {
		implUsuario.save(usur);
	}
	public Optional<Usuario> getUsuario(int id){
		return implUsuario.findById(id);
	}
	public void deleteUsuario(int id) {
		implUsuario.deleteById(id);
	}

}
