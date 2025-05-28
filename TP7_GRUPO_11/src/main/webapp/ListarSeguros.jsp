<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./Style.css">
<meta charset="UTF-8">
<title>LISTAR SEGUROS</title>
</head>
<body>
<header>
	<nav>
		<div class="logo">
			<img id="imgUtn" src="https://yt3.googleusercontent.com/ytc/AIdro_mZP2hpO8WadOGddr0YsETHdLRTUq2NhcBKzgpzfXgnGLU=s900-c-k-c0x00ffffff-no-rj" alt="Logo UTN">
		</div>
		<div class="div-nav">
			<a href="./Inicio.jsp">Inicio</a> <br>
			<a href="./AgregarSeguro.jsp">Agregar Seguro</a> <br>
			<a href="./ListarSeguros.jsp">Listar Seguros</a> <br>
		</div>
	</nav>
</header>

<main>
	<h1> "Tipos de seguros de la base de datos" </h1>
</main>
<br> <br>

<form action="Filtrar" method="get">
<label> Busqueda por tipo de Seguros </label>
<select name="filtro">

<!-- Ejemplo de opciones -->
		<option value="1">Automotor</option>
		<option value="2">Hogar</option>
		<option value="3">Vida</option>

</select> 
<input type="submit" name="btnFiltrar" value="Filtrar"/>
</form>
<br><br>
<table border="1">
	<tr>
		<th>ID Seguro</th>
		<th>Descripcion Seguro</th>
		<th>Descripcion Tipo Seguro</th>
		<th>Costo Contratacion</th>
		<th>Costo Maximo Asegurado</th>
	</tr>
	<tr>
		<td>"1234"</td>
		<td>"seguro para algo"</td>
		<td>"seguro de pc"</td>
		<td>"$500.000"</td>
		<td>"$1.000.000"</td>
	</tr>
	
	</table>

</body>
</html>