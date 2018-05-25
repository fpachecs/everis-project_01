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

@SuppressWarnings("serial")
@WebServlet("/IngresarService")
public class IngresarService extends HttpServlet{
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			CuentasDao cntd = LibFactory.getCuentasDaoImp();
			MovimientosDao movd = LibFactory.getMovimientosDaoImp();
			HttpSession session = request.getSession();
			session.getAttribute("iduser");	
		}
}
