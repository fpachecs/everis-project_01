package com.everisboot.security;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.everisboot.models.UsuarioLogin;

public class SesionUsuario implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UsuarioLogin usuarioLogin;
 
    public SesionUsuario(UsuarioLogin usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// ROLES
		return new LinkedList<>();
	}

	@Override
	public String getPassword() {
		return usuarioLogin.getPass();
	}

	@Override
	public String getUsername() {
		return usuarioLogin.getUser();
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}