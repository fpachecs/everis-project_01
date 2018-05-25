<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Principal</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

<link rel="shortcut icon" href="img/bank.ico" />
</head>
<body>
<header>
		<nav class="navbar navbar-expand-md navbar-dark bg-dark">
			<a class="navbar-brand" href="index.html">Inversis</a>
			<button class="navbar-toggler" type="button"
				data-toggle="collapse" data-target="#navbarCollapse"
				aria-controls="navbarCollapse" aria-expanded="true"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="navbar-collapse collapse" id="navbarCollapse">
				<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
					<li class="nav-item active"><a class="nav-link" href="Controller?op=ingresar">Ingresar</a></li>
					<li class="nav-item active"><a class="nav-link" href="#">Extraer</a></li>
					<li class="nav-item active"><a class="nav-link" href="#">Movimientos</a></li>
				</ul>
			</div>
			<ul class="navbar-nav px-3">
				<li class="nav-item active"><a class="nav-link" href="#" name="user">${user_S}</a></li>
			</ul>
		</nav>
	</header>
	<div class="container" style="text-align:center;">
	<div class="row">
		<div class="col-lg-4">
			<a href="Controller?op=ingresar"><img class="rounded-circle" src="img/movimientos.jpg" width="140" height="140"></a>
			<h2>Ingresar</h2>
		</div>	
		<div class="col-lg-4">
			<a href="#"><img class="rounded-circle" src="img/movimientos.jpg" width="140" height="140"></a>
			<h2>Retirar</h2>
		</div>
		<div class="col-lg-4">
			<a href="#"><img class="rounded-circle" src="img/movimientos.jpg" width="140" height="140"></a>
			<h2>Movimientos</h2>
		</div>
	</div>
	</div>
</body>
</html>