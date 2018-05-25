package com.everis.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.everis.DAO.CuentasDao;
import com.everis.DAO.LibFactory;
import com.everis.DAO.MovimientosDao;
import com.everis.models.Cuenta;

@SuppressWarnings("serial")
@WebServlet("/OperacionesService")
public class OperacionesService extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException { 
		String operacion = request.getParameter("opc");
		CuentasDao cntd = LibFactory.getCuentasDaoImp();
		MovimientosDao movd = LibFactory.getMovimientosDaoImp();
		HttpSession session = request.getSession();
		Cuenta ctn = cntd.obtenerCuenta((int)session.getAttribute("iduser"));
		if (operacion.equals("Ingresar")) {			
			movd.ingresar(Integer.parseInt(request.getParameter("importe")), ctn.getId());
		}else if (operacion.equals("Extraer")) {
			movd.extraer(Integer.parseInt(request.getParameter("importe")), ctn.getId());
		}
		request.getRequestDispatcher("principal.jsp").forward(request, response);
	}
}
