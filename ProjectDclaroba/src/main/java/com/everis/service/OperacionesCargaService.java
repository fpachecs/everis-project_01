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
import com.everis.models.Cuenta;

@SuppressWarnings("serial")
@WebServlet("/OperacionesCargaService")
public class OperacionesCargaService extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		CuentasDao cntd = LibFactory.getCuentasDaoImp();
		HttpSession session = request.getSession();
		Cuenta cuenta = cntd.obtenerCuenta((int)session.getAttribute("iduser"),request.getParameter("numCuenta").toString());
		request.setAttribute("cuenta", cuenta);
		session.setAttribute("cuenta", cuenta);
		session.setAttribute("numCuenta", cuenta.getNumCuenta());
		request.getRequestDispatcher("cuenta.jsp").forward(request, response);
	}
}
