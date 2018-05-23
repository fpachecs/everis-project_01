package com.everis.model.dao;

import com.everis.model.dao.bean.UsuarioLogin;

/**
 * M�todos de gesti�n relacionados con el bean UsuarioLogin.
 * 
 * @author fpachecs
 *
 */
public interface GestUsuarioLogin {

	/**
	 * Verifica las credenciales de acceso. De acceder, actualizar la fecha de
	 * �ltimo acceso.
	 * 
	 * @param user
	 *            Nombre de usuario.
	 * @param pass
	 *            Contrase�a del usuario.
	 * @return Objeto UsuarioLogin con acceso a la aplicaci�n.<br>
	 *         null, en caso contrario.
	 */
	UsuarioLogin autenticar(String user, String pass);

	/**
	 * Actualiza informaci�n de un UsuarioLogin.
	 * <p>
	 * Actualmente solo actualiza la fecha de �ltimo acceso.
	 * 
	 * @param usuarioLogin
	 *            Objeto que contiene la informaci�n a actualizar.
	 * @return Objeto actualizado.
	 */
	UsuarioLogin updateUsuarioLogin(UsuarioLogin usuarioLogin);

}
