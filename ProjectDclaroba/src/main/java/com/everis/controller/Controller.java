package com.everis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/Controller")
public class Controller extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String opcion = request.getParameter("op");
		String url = "";
		switch (opcion) {
			case "login":
				url = "LoginService";
				break;
			case "operaciones":
				url = "OperacionesService" ;
				break;
			case "operacionescarga":
				url = "OperacionesCargaService" ;
				break;
			default:
				break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
