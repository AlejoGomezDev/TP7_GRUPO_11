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
    <h1>Agregar Seguro</h1>

    <form method="post" action="servletAgregar" id="form-agregar-seguro">
        <table id="table-form-agregar">
            <tr>
                <td><label>Id Seguro:</label></td>
                <td>
					<%
						int proximoId = 0;
						if(request.getAttribute("proximoID") != null){
							proximoId = (int)request.getAttribute("proximoID");
						}
					%>
					<label><%= proximoId %></label>
				</td>
            </tr>

            <tr>
                <td><label>Descripción:</label></td>
                <td><input type="text" name="txtDescripcion"></td>
            </tr>

            <tr>
                <td><label>Tipo de seguro:</label></td>
                <td>
                    <select name="ddlTipos">
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
                </td>
            </tr>

            <tr>
                <td><label>Costo contratación:</label></td>
                <td><input type="text" name="txtCosto"></td>
            </tr>

            <tr>
                <td><label>Costo máximo asegurado:</label></td>
                <td><input type="text" name="txtCostoMaximo"></td>
            </tr>

            <tr>
                <td colspan="2" style="text-align:center;">
                    <input type="submit" name="btnAgregarSeguro" value="Agregar Seguro">
                </td>
            </tr>
        </table>
    </form>
	
	<!-- CONDICIONAL MENSAJE DE ERROR -->
	<% if (request.getAttribute("mensajeError") != null) { %>
	    <div id="div-agregar-error">
	        <%= request.getAttribute("mensajeError") %>
	    </div>
	<% } %>
	
	<!-- CONDICIONAL INSERTAR EN LA DB -->
	<%
	int filas = 0; 
	if (request.getAttribute("cantFilas") != null) {
		filas = Integer.parseInt(request.getAttribute("cantFilas").toString()); 
	
	%>
	
	<%
		if (filas == 1) {
	%>
	    <div style = "color:gren;" id="div-agregado-exito">
	         Seguro agregado con éxito
	    </div>
	<%
		} else {
	%>
	    <div style = "color:red;" id="div-error-agregado">
	         Hubo un ERROR al agregar el seguro
	    </div>
	<%
		}
	}
	%>
</main>


</body>
</html>