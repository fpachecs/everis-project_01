package com.everis.controller.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.everis.model.dao.GestUsuario;
import com.everis.model.dao.GestUsuarioLogin;
import com.everis.model.dao.LibFactory;
import com.everis.model.dao.bean.Usuario;
import com.everis.model.dao.bean.UsuarioLogin;

/**
 * Verifica que una cuenta existe, de existir, se alamacena datos
 * correspondientes a la cuenta y se carga el menú principal.
 * <p>
 * Si se pone una cuenta que no existe, nos redirige a una página de eror.
 * 
 * @author fpachecs
 *
 */
@SuppressWarnings("serial")
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("_user");
		String pass = request.getParameter("_pass");

		HttpSession session = request.getSession();
		session.setAttribute("$user", user);
		session.setAttribute("$pass", pass);

		GestUsuarioLogin gul = LibFactory.getGestUsuarioLoginImpl();
		String url = "";

		UsuarioLogin usuarioLogin = gul.autenticar(user, pass);
		if (usuarioLogin != null) {
			// Buscamos usuario asociado y lo almacenamos en sesión.
			GestUsuario gu = LibFactory.getGestUsuarioImpl();
			Usuario usuario = gu.getUsuario(usuarioLogin.getIdUser());
			session.setAttribute("$usuario", usuario);
			// Envío a operaciones.html
			url = "Controller?_op=toOperaciones";
		} else {
			url = "errorEnLogin.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
