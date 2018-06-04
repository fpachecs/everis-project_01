package com.everisboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.everisboot.DAO.UsuarioDAOImpl;
import com.everisboot.models.Usuario;
@Controller
class GestUsuarioImpl implements GestUsuario {
	
	@Autowired
	UsuarioDAOImpl implUsuario;
	
	public Iterable<Usuario> listUsuario(){
		return implUsuario.findAll();
	}
	@Override
	public void saveUsuario(Usuario usur) {
		implUsuario.save(usur);
	}
	@Override
	public Usuario getUsuario(Integer idUsuario){
		Usuario result=null;
		if(implUsuario.findById(idUsuario).isPresent()) {
			result=implUsuario.findById(idUsuario).get();
		}				
		return result;
	}
	public void deleteUsuario(Integer id) {
		implUsuario.deleteById(id);
	}

}
