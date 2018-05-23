<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Operaciones</title>
	<link rel="stylesheet" type="text/css" href="css\estilo.css"/>
</head>
<body>
	<c:set var="nomCliente" value="${sessionScope.$usuario.nombre}"/>
	<div class="header">
		<h1>Operaciones disponibles</h1>
		<p class="headerInfo">Logueado como: <b>${nomCliente}</b></p>
	</div>
	<div class="main">
		<p>Seleccione una opción:</p>	
		<br/>
		<input class="botonMedio" type="submit" value="Ingresar" 
			onClick="window.location.href='ingresar.html'"/>
		<br/><br/>
		<input class="botonMedio" type="submit" value="Extraer" 
			onClick="window.location.href='extraer.html'"/>
		<br/><br/>
		<input class="botonMedio" type="submit" value="Movimientos"
			onClick="window.location.href='Controller?_op=doMovimiento'"/>
	</div>
</body>
</html>