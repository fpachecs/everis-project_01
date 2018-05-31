<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<title>Login</title>

<script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js" integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30=" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
<script>
$(document).ready(function() {
	var frase = "${frase}";
	if (frase != "") {
		$('#dialog').dialog({close: function() {$('#formulario').css("opacity","1");}});
		$('#formulario').css("opacity","0.3");
	}
	
});
</script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<link rel="stylesheet" type="text/css" href="css\estilo.css"/>
<link rel="stylesheet" type="text/css" href="css\theme.css"/>
<link rel="shortcut icon" href="img/bank.ico" />
</head>
<body>

	<form id="formulario" class="form-signin" name="formLogin" action="Controller?op=login" method="post">
		<img src="img/Inversis.png" class="img-fluid" >
		<div class="form-label-group">
			<input type="text" id="inputEmail" class="form-control" placeholder="Usuario" required autofocus name="user"> 
			<label for="inputEmail" >Usuario</label>		
		</div>
		<div class="form-label-group">
			<input type="password" id="inputPassword" class="form-control" placeholder="Contraseña" required autofocus name="contrasena">
			<label for="inputPassword">Contraseña</label> 		
		</div>
		<button class="btn btn-lg btn-secondary btn-block" type="submit">Login</button>		
	</form>
	<div id="dialog" title="Error en el Login">
	  <p>${frase}</p>
	</div>
</body>
</html>