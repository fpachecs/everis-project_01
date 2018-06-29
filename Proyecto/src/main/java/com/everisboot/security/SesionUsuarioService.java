package com.everisboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.everisboot.exception.ExceptionApp;
import com.everisboot.models.UsuarioLogin;
import com.everisboot.services.GestUsuarioLogin;
@Service
public class SesionUsuarioService implements UserDetailsService {

	@Autowired
	private GestUsuarioLogin gestUsuarioLogin;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		try {
			UsuarioLogin usuarioLogin = gestUsuarioLogin.login(username);
			if (usuarioLogin == null) {
				throw new UsernameNotFoundException(username);
			}
			return new SesionUsuario(usuarioLogin);
		} catch (ExceptionApp ex) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
	}
}
