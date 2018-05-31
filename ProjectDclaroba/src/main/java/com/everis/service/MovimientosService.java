package com.everis.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.everis.DAO.CuentasDao;
import com.everis.DAO.LibFactory;
import com.everis.DAO.MovimientosDao;
import com.everis.models.Movimiento;

@SuppressWarnings("serial")
@WebServlet("/MovimientosService")
public class MovimientosService extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException { 
		HttpSession session = request.getSession();
		CuentasDao cntd = LibFactory.getCuentasDaoImp();
		MovimientosDao movd = LibFactory.getMovimientosDaoImp();
		List<Movimiento> movimientos = movd.obtenerMovimientosCuenta((int)session.getAttribute("idCuenta"));
		request.setAttribute("movimientos", movimientos);
		request.setAttribute("cuenta", cntd.obtenerCuenta((int)session.getAttribute("iduser"), session.getAttribute("numCuenta").toString()));
		request.setAttribute("fecha", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		request.setAttribute("hora", DateTimeFormatter.ofPattern("HH:mm"));
		request.getRequestDispatcher("movimientos.jsp").forward(request, response);
	}
}
