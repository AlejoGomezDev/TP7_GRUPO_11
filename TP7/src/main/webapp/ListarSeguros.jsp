<%@page import="dominio.segurosDto"%>
<%@page import="dominio.Seguro"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="dominio.TipoSeguro" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>

<link rel="stylesheet" href="./Style.css">
<meta charset="UTF-8">
<title>LISTAR SEGUROS</title>
</head>
<body>
<header>
	<nav>
		<div class="logo">
			<img id="imgUtn" src="./logo-utn.png" alt="Logo UTN">
		</div>
		<div class="div-nav">
			<a href="./Inicio.jsp">INICIO</a> <br>
			<a href="servletAgregar">AGREGAR SEGURO</a> <br>
			<a href="servletListar">LISTAR SEGUROS</a> <br>
		</div>
	</nav>
</header>

<main>
	<h1> "Tipos de seguros de la base de datos" </h1> 
	
	<br> <br>
	
<form action="servletListar" method="get">
	<label> Busqueda por tipo de Seguros </label>
	<select name="filtro">
	<option value="todos" > Mostrar todos</option>
	
	<% 
		ArrayList<TipoSeguro> tipos;
        if(request.getAttribute("listaTipos") != null) {
        tipos = (ArrayList<TipoSeguro>) request.getAttribute("listaTipos");
        
        for(TipoSeguro tipo : tipos) {
    %>
        <option value="<%= tipo.getId() %>"><%= tipo.getDescripcion() %></option>
        <%
         } // for
         } // if
		%>

	</select> 
	
	<input type="submit" name="btnFiltrar" value="Filtrar"/>
	</form>
	
		<%
			ArrayList<Seguro> listaSeguros = null;
			if(request.getAttribute("listaSeguro")!=null){
				listaSeguros = (ArrayList<Seguro>) request.getAttribute("listaSeguro");
			}
		%>
		
	<br><br>
	<table id="tabla-listado">
		<tr>
			<th>ID Seguro</th>
			<th>Descripcion Seguro</th>
			<th>Descripcion Tipo Seguro</th>
			<th>Costo Contratacion</th>
			<th>Costo Maximo Asegurado</th>
		</tr>

<%
	if(listaSeguros!=null)
		for(Seguro seg : listaSeguros)
		{
%>
		
		<tr>
			<td><%= seg.getIdSeguro()%></td>
			<td><%= seg.getDescripcion()%></td>
			<td><%= seg.getTipo().getDescripcion()%></td>
			<td><%= seg.getCostoContratacion()%></td>
			<td><%= seg.getCostoAsegurado()%></td>
		</tr>
	<% } %>
	</table>
	
</main>


</body>
</html>