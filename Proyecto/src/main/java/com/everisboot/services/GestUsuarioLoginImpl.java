package com.everisboot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.everisboot.DAO.UsuarioLoginDAOImpl;
import com.everisboot.exception.ExceptionApp;
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
	public void saveLogin(UsuarioLogin log) {
		implLogin.save(log);

	}
	
	public Optional<UsuarioLogin> getLogin(Integer id){
		return implLogin.findById(id);
	}
	
	public void deleteLogin(Integer id){
		implLogin.deleteById(id);

	}
	
	public boolean existeUsuario(String user) {
		UsuarioLogin log= new UsuarioLogin();
		log.setUser(user);
		Iterable<UsuarioLogin>	Logeos = implLogin.findAll();
		for (UsuarioLogin usuarioLogin : Logeos) {
			if (log.getUser().equals(usuarioLogin.getUser())) {
				return true;
			}			
		}
		return false;
	}
	
	public boolean contraseñaCorrecta(String pass) {
		
		UsuarioLogin log=new UsuarioLogin();
		log.setPass(pass);
		Iterable<UsuarioLogin>	Logeos = implLogin.findAll();
		for (UsuarioLogin usuarioLogin : Logeos) {
			if(existeUsuario(log.getUser())) {				
			//if (log.getUser().equals(usuarioLogin.getUser())) {
				if (log.getPass().equals(usuarioLogin.getPass())) {
					
				}
				return true;
			}			
		}
		return false;
	}
	
	public int devuelveId(UsuarioLogin user) {
		int iduser=0;		
		Iterable<UsuarioLogin>	Logeos = implLogin.findAll();	
		for (UsuarioLogin login : Logeos) {
			if(user.getUser().equals(login.getUser())){				
				if (user.getPass().equals(login.getPass())) {
					iduser=login.getIdUser();
					return iduser;
				}
			}					
		}
		return iduser;
	}	
	
	public UsuarioLogin login(String user, String pass) throws ExceptionApp {
		UsuarioLogin result = new UsuarioLogin();
		Iterable<UsuarioLogin>	logeos = implLogin.findAll();
		List<UsuarioLogin> lista = new ArrayList<>();
		for (UsuarioLogin ul : logeos) {
			lista.add(ul);
		}
		
		try {
			UsuarioLogin usuarioLogin = lista.stream().filter(ul -> ul.getUser().equals(user)).findFirst().orElse(null);
			// Validar user
			if (usuarioLogin != null && validateUser(usuarioLogin, user)) {
				// Validar password
				if  (usuarioLogin.getPass().equals(pass)) {
					result = usuarioLogin;
				} else {
					throw new ExceptionApp("Credenciales incorrectas","La contraseña es incorrecta.");
				}
			} else {
				throw new ExceptionApp("Usuario sin acceso","El usuario no se encuentra en nuestra base de datos.");
			}
		return result;
			
		} catch (ExceptionApp e) {
			throw new ExceptionApp(e.getTitulo(),e.getMsg());
		}
	}

	private boolean validateUser(UsuarioLogin usuarioLogin, String user) {
		boolean result = false;

		if (usuarioLogin.getUser().equals(user)) {
			result = true;
		}			
		return result;
	}

}
