package com.everis.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.everis.DAO.CuentasDao;
import com.everis.DAO.LibFactory;
import com.everis.DAO.UsuarioDao;
import com.everis.DAO.UsuarioLoginDao;
import com.everis.models.Cuenta;
import com.everis.models.Usuario;
import com.everis.models.UsuarioLogin;

@SuppressWarnings("serial")
@WebServlet("/LoginService")
public class LoginService extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		String url = "";
		String frase = "";
		String user = request.getParameter("user").toString();
		String contrasena = request.getParameter("contrasena");
		HttpSession session = request.getSession();
		UsuarioLoginDao uld = LibFactory.getUsuarioLoginDaoImp();
		UsuarioDao ud = LibFactory.getUsuarioDaoImp();
		CuentasDao ctnd = LibFactory.getCuentasDaoImp();
		if (uld.existe(user)) {
			if (uld.correcto(user, contrasena)) {
				//Usuario y contraseña correctos
				UsuarioLogin usrLog = uld.obtenerUsuarioLogin(user, contrasena);
				session.setAttribute("iduser", usrLog.getIdUser());				
				Usuario usuario = ud.obtenerUsuario(usrLog.getIdUser());
				session.setAttribute("Nombre", usuario.getNombre());
				session.setAttribute("Apellido", usuario.getApellido());
				List<Cuenta> cuentas = ctnd.obtenerCuentasUsuario(usuario.getId());
				request.setAttribute("cuentasList", cuentas);
				frase = "Bienvenido " + usuario.getNombre();
				url = "principal.jsp";
			}else {
				//Usuario existe pero contraseña esta mal
				frase = "El usuario " + user + " no coincide con la contraseña " + contrasena;
				url = "index.jsp";
			}			
		}else {
			//Usuario no existe, posibilidad de logearse
			frase = "El usuario " + user + " no existe ";
			url = "index.jsp";
		}
		request.setAttribute("frase", frase);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
