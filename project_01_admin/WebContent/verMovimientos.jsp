<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Carrito</title>
<link rel="stylesheet" type="text/css" href="css\estilo.css"/>
</head>
<body>
	<c:set var="listaMov" value="${sessionScope.$listaMov}"/>
	<div class="header">
		<h1>Movimientos</h1>
	</div>
	<div class="main">
		<table>
			<tr>
				<th>Fecha</th>
				<th>Cantidad</th>
				<th>Operación</th>
			</tr>
			
			<c:forEach var="mov" items="${listaMov}">
			<tr>
            	<td>${mov.fechaOperacion}</td>
				<td>${mov.cantidad}</td>
				<td>${mov.tipoOperacion}</td>
			</tr>
            </c:forEach>
           
		</table>
		<br/><br/>
		<input class="botonMedio" type="submit" value="Volver" 
			onClick="window.location.href='Controller?_op=toOperaciones'"/>
	</div>		
</body>
</html>