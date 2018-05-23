package com.everis.controller.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.everis.model.dao.GestCuentas;
import com.everis.model.dao.GestMovimientos;
import com.everis.model.dao.LibFactory;
import com.everis.model.dao.bean.Cuenta;
import com.everis.model.dao.bean.Movimiento;
import com.everis.model.dao.bean.Usuario;

/**
 * Muestra y obtiene todos los movimientos asociados a una cuenta.
 * 
 * @author fpachecs
 *
 */
@SuppressWarnings("serial")
@WebServlet("/MovimientoAction")
public class MovimientoAction extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("$usuario");

		// Obtener id de cuenta.
		GestCuentas gc = LibFactory.getGestionCuentas();
		Cuenta cuenta = gc.getCuentaPorUsuario(usuario.getId());
		//Obtener movimientos de cuenta.
		GestMovimientos gm = LibFactory.getGestMovimientos();
		List<Movimiento> listaMov = gm.getMovimientos(cuenta.getId());

		String url = "";
		if (listaMov.size() > 0) {
			session.setAttribute("$listaMov", listaMov);
			url = "verMovimientos.jsp";
		} else {
			url = "sinMovimientos.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
