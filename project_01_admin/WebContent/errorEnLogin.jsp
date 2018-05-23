<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fallo en login</title>
<link rel="stylesheet" type="text/css" href="css\estilo.css"/>
</head>
<body>
	<div class="header">
		<h1>Credenciales incorrectas</h1>
	</div>
	<div class="main">
		<c:set var="user" value="${sessionScope.$user}"/>
		<c:set var="pass" value="${sessionScope.$pass}"/>
		<p>El usuario <b>${user}</b> y conraseña <b>${pass}</b> son incorrectas.</p>
		<br/>
		<input class="botonMedio" type="submit" value="Volver"
			onClick="window.location.href='Controller?_op=toIndex'"/>
	</div>
</body>
</html>