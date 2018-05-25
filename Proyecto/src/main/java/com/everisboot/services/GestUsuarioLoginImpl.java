package com.everisboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.everisboot.DAO.UsuarioLoginDAOImpl;
import com.everisboot.models.UsuarioLogin;
@Controller
class GestUsuarioLoginImpl implements GestUsuarioLogin{
	
	@Autowired
	UsuarioLoginDAOImpl implLogin;
	
	
	
    public GestUsuarioLoginImpl(){
    	
    }
    
	public Iterable<UsuarioLogin> listLogin() {
		return implLogin.findAll();
	}
	
	@Override
	public void saveLogin(UsuarioLogin log,int id,String user, String password) {
		implLogin.save(log);

	}
	
	public Optional<UsuarioLogin> getLogin(int id){
		return implLogin.findById(id);
	}
	
	public void deleteLogin(int id){
		implLogin.deleteById(id);

	}
	
	public int devuelveId(String user, String pass) {
		int iduser=0;		
		UsuarioLogin log= new UsuarioLogin();
		log.setUser(user);
		log.setPass(pass);
		Iterable<UsuarioLogin>	Logeos = implLogin.findAll();	
		for (UsuarioLogin login : Logeos) {
			if(log.getUser()==login.getUser()) {
				iduser=login.getId();	
				return iduser;
			}					
		}
		return iduser;
	}

}
