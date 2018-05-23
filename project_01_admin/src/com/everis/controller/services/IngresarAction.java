package com.everis.controller.services;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
 * Servicio especializado en hacer la operación de ingresar una cantidad de un
 * cuenta existente.
 * <p>
 * Realiza dos acciones:
 * <ul>
 * <li>Generar un nuevo registro Movimiento.</li>
 * <li>Actualizar el saldo de la Cuenta.</li>
 * </ul>
 * 
 * @author fpachecs
 *
 */
@SuppressWarnings("serial")
@WebServlet("/IngresarAction")
public class IngresarAction extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Cantidad
		String cantidadS = request.getParameter("_cantidad");
		BigDecimal cantidad = new BigDecimal(cantidadS);
		// Fecha de operación.
		LocalDateTime fechaOperacion = LocalDateTime.now();
		// Id de cuenta.
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("$usuario");
		GestCuentas gc = LibFactory.getGestionCuentas();
		Cuenta cuenta = gc.getCuentaPorUsuario(usuario.getId());
		// Operacion
		String tipoOperacion = "ingresa";

		// Crear movimiento.
		GestMovimientos gm = LibFactory.getGestMovimientos();
		Movimiento mov = new Movimiento(cuenta.getId(), fechaOperacion, cantidad, tipoOperacion);

		String url = "";
		if (gm.ingresar(mov) && gc.actualizaSaldo(cantidad, cuenta.getId())) {
			// Si todo fue correcto, se vuelve a mostrar la página.
			url = "ingresar.html";
		} else {
			url = "Controller?_op=toErrorMovimiento";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
