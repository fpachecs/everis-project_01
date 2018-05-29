<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Operaciones</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

<link rel="shortcut icon" href="img/bank.ico" />
</head>
<body>
<header>
		<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<div class="row">
			<div class="col-sm-2">
				<a class="navbar-brand" href="index.jsp"><img src="img/Inversis.png" class="img-fluid" ></a>
			</div>
			<div class="col-sm-8"></div>
			<ul class="navbar-nav col-lg-2">
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${Nombre} ${Apellido}</a>
					<div class="dropdown-menu" aria-labelledby="dropdown01" id="despegable">
			              <a class="dropdown-item" href="#">Perfil</a>
			              <a class="dropdown-item" href="#">Movimientos</a>
			              <a class="dropdown-item" href="operacion.jsp">Operaciones</a>
			              <a class="dropdown-item" href="#">Salir</a>
		            </div>
		        </li>
			</ul>
		</div>			
		</nav>
	</header>
	<form action="Controller?op=operaciones" method="post">
		<div class="container" style="text-align:center;">		
			<div class="form-group row">
				<div class="col-sm-5">
				</div>
				<div class="col-sm-2">
					<input type="text" class="form-control"	id="importe" placeholder="Importe" name="importe">
				</div>
				<div class="col-sm-5">
				</div>
			</div>
			<div class="btn-group-vertical">
	  			<button class="btn btn-lg btn-succes btn-block" type="submit" name="opc" value="Ingresar">Ingresar</button>
				<button class="btn btn-lg btn-danger btn-block" type="submit" name="opc" value="Extraer">Extraer</button>
			</div>	
		</div>		
	</form>
</body>
</html>