package com.everisboot.DAO;

import org.springframework.data.repository.CrudRepository;

import com.everisboot.models.Usuario;



public interface UsuarioDAOImpl extends CrudRepository<Usuario, Integer> {
	
	
}