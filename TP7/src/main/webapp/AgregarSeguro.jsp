<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
     <%@ page import="dominio.TipoSeguro" %>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="./Style.css">
<meta charset="UTF-8">
<title>AGREGAR SEGURO</title>
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
			<a href="./ListarSeguros.jsp">LISTAR SEGUROS</a> <br>
		</div>
	</nav>
</header>

<main>
	<h1> Agregar Seguro </h1>
	<br>
	<form method="post" action="ServletSeguros">
	
	
	
	Id Seguro: <input type="hidden" name="id"> 
  	
   
	<br>  
	Descripcion: <input type="text" name="txtDescripcion">
	<br>
	Tipo de seguro: 
	<select name="ddlTipos">
       <%
    ArrayList<TipoSeguro> tipos;
	if(request.getAttribute("tipos")!=null){
		
		tipos = (ArrayList<TipoSeguro>)request.getAttribute("tipos");
	%>	

	  
	  <% for(TipoSeguro tipo : tipos){  %>
	    <option value="<%=tipo.getId()%>"><%=tipo.getDescripcion()%></option>
      <% } // for %>	  
	<% } // if %>
	</select>
	<br>
	Costo contratacion: <input type="text" name="txtCosto">
	<br>
	Costo maximo asegurado: <input type="text" name="txtCostoMaximo">
	<br>
	<input type="submit" name = "btnAceptar">
	
	</form>
</main>


</body>
</html>