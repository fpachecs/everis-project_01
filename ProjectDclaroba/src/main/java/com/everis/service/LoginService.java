package com.everis.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.everis.DAO.LibFactory;
import com.everis.DAO.UsuarioLoginDao;
import com.everis.models.UsuarioLogin;

@SuppressWarnings("serial")
@WebServlet("/LoginService")
public class LoginService extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		String url = "";
		String user = request.getParameter("user").toString();
		String contrasena = request.getParameter("contrasena");
		HttpSession session = request.getSession();
		session.setAttribute("user_S", user);
		UsuarioLoginDao uld = LibFactory.getUsuarioLoginDaoImp();
		if (uld.existe(user)) {
			if (uld.correcto(user, contrasena)) {
				//Usuario y contraseña correctos
				UsuarioLogin usrLog = uld.obtenerUsuarioLogin(user, contrasena);
				session.setAttribute("iduser", usrLog.getId());
				url = "principal.jsp";
			}else {
				//Usuario existe pero contraseña esta mal
				request.setAttribute("frase", "El usuario " + user + " no coincide con la contraseña " + contrasena);
				url ="fallida.jsp";
			}			
		}else {
			//Usuario no existe, posibilidad de logearse
			request.setAttribute("frase", "El usuario " + user + " no existe ");
			url = "fallida.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
