package com.everis.model.dao;

import com.everis.model.dao.bean.Usuario;

/**
 * M�todos de gesti�n relacionados con el bean Usuario.
 * 
 * @author fpachecs
 *
 */
public interface GestUsuario {

	/**
	 * Obtiene una Usuario a partir de su id,
	 * 
	 * @param id
	 *            Identificador de Usuario.
	 * @return Un usuario encontrado.<br>
	 *         null, en caso contrario.
	 */
	Usuario getUsuario(int id);

}
