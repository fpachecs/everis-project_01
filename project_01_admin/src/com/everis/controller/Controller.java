package com.everis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controlador principal que atiende las peticiones de usuario.
 * 
 * @author fpachecs
 *
 */
@SuppressWarnings("serial")
@WebServlet("/Controller")
public class Controller extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("_op");
		String url = "";

		switch (op) {
		case "doLogin":
			url = "LoginAction";
			break;
		case "doExtrae":
			url = "ExtraerAction";
			break;
		case "doIngresa":
			url = "IngresarAction";
			break;
		case "doMovimiento":
			url = "MovimientoAction";
			break;

		case "toIndex":
			url = "index.html";
			break;
		case "toOperaciones":
			url = "operaciones.jsp";
			break;
		case "toErrorMovimiento":
			url = "errorEnMovimiento.jsp";
			break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
