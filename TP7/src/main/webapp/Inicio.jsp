<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="./Style.css">
<meta charset="UTF-8">
<title>INICIO</title>
</head>
<body>
	<header>
	<nav>
		<div class="logo">
			<img id="imgUtn" src="./logo-utn.png" alt="Logo UTN">
		</div>
		<div class="div-nav">
			<a href="./Inicio.jsp">INICIO</a> <br>
			<a href="./AgregarSeguro.jsp">AGREGAR SEGURO</a> <br>
			<a href="./ListarSeguros.jsp">LISTAR SEGUROS</a> <br>
		</div>
	</nav>
</header>

<main>
	<h1> Inicio </h1>
	
	<%! String Inicio = "Soy la página inicio"; %>
	
	<%= Inicio %>
	
</main>


</body>
</html>