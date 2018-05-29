<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" >
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<title>Principal</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
<script defer src="https://use.fontawesome.com/releases/v5.0.13/js/all.js" integrity="sha384-xymdQtn1n3lH2wcu0qhcdaOpQwyoarkgLVxC/wZ5q7h9gHtxICrpcaSUfygqZGOe" crossorigin="anonymous"></script>
<link rel="shortcut icon" href="img/bank.ico" />
<link rel="stylesheet" type="text/css" href="css\estilo.css"/>
</head>
<body>
<header>
		<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<div class="row">
			<div class="col-sm-2">
				<a class="navbar-brand" href="index.jsp"><img src="img/Inversis.png" class="img-fluid" ></a>
			</div>
			<div class="col-sm-8"></div>
			<ul class="navbar-nav col-sm-2">
				<li class="nav-item active"><a class="nav-link" href="#" id="dropdown01">${Nombre} ${Apellido}</a></li>
			</ul>
		</div>			
		</nav>
	</header>
	<div class="container" style="text-align:center;">
	<div class="row">
		<div class="col-lg-3">
			
		</div>	
		<div class="col-lg-6">
			<h2>Cuentas disponibles</h2>
			<ul class="list-group">
                <c:forEach var="cuenta" items="${cuentasList}">
                    <li class="list-group-item" >
	                    <div class="row">
		                    <div class="col-lg-6">
								<a href="Controller?op=operacionesCarga&numCuenta=${cuenta.numCuenta}">${cuenta.numCuenta}</a>
							</div>
							<div class="col-lg-3">
								
							</div>
							<div class="col-lg-3">
								${cuenta.saldo} <i class="fab fa-bitcoin"></i>
							</div>
						</div>                    	
                    </li>
                </c:forEach>
            </ul>
		</div>		
		<div class="col-lg-3">
			
		</div>
	</div>
	</div>
</body>
</html>