package com.everis.model.dao;

import com.everis.model.dao.bean.UsuarioLogin;

/**
 * Métodos de gestión relacionados con el bean UsuarioLogin.
 * 
 * @author fpachecs
 *
 */
public interface GestUsuarioLogin {

	/**
	 * Verifica las credenciales de acceso. De acceder, actualizar la fecha de
	 * último acceso.
	 * 
	 * @param user
	 *            Nombre de usuario.
	 * @param pass
	 *            Contraseña del usuario.
	 * @return Objeto UsuarioLogin con acceso a la aplicación.<br>
	 *         null, en caso contrario.
	 */
	UsuarioLogin autenticar(String user, String pass);

	/**
	 * Actualiza información de un UsuarioLogin.
	 * <p>
	 * Actualmente solo actualiza la fecha de último acceso.
	 * 
	 * @param usuarioLogin
	 *            Objeto que contiene la información a actualizar.
	 * @return Objeto actualizado.
	 */
	UsuarioLogin updateUsuarioLogin(UsuarioLogin usuarioLogin);

}
