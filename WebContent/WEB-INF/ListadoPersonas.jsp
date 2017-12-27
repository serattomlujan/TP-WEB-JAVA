<%@page import="entity.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head><center><title>Listar Personas</title><hr color="purple"><font face="arial" color="purple"> <b> <h2>LISTADO DE PERSONAS </h2><hr color="purple"><br><br>
<body>

	
	<div>
	<table border="1">
		<tr>
		  <td><strong> ID </strong></td>
		  <td><strong> APELLIDO </strong></td>
		  <td><strong> NOMBRE </strong></td>
		  <td><strong> DNI</strong></td>
		  <td><strong> EMAIL</strong></td>
		  <td><strong> CATEGORIA</strong></td>
		  
		</tr>
		<% 
		List <Persona> listPersona = (List <Persona>)request.getAttribute("list");
		for (Persona p: listPersona)
			{ %>
		<tr>
		  <td><%=p.getIdpersona() %></td>
		  <td><%=p.getApellido() %></td>
		  <td><%=p.getNombre() %></td>
		  <td><%=p.getDni() %></td>
		  <td><%=p.getEmail()%></td>
		  <td><%=p.getCategoria().getDescripcion() %></td>
		</tr>
			
			<%	
				};
			%>
	</table><br>		
	</div>
	<br>

	<a href="#" title="Regresar a página anterior" onclick="history.back()"><h6 align="right">Atrás</h6></a>
	<a href="#" title="salir" onclick="window.close()"> <h6 align="right">Salir</h6></a><br>
	<hr color="pink">
	<center><font face="verdana" size="1" color="pink"><a href='/TP_Web3/ReservaAb'>RESERVAR ELEMENTO</a>
			   <a href="/TP_Web3/ReservasPendientes"> RESERVAS PENDIENTES</a>
			   <a href="/TP_Web3/PersonaAb">PERSONAS</a>
			   <a href="/TP_Web3/ElementoAb">ELEMENTOS</a>
			   <a href="/TP_Web3/TipoElementoAb">TIPOS de ELEMENTOS</a>
			   <a href="/TP_Web3/ListadoElementos">LISTADO de ELEMENTOS</a>
			   <a href="/TP_Web3/ListadoTipoElementos">LISTADO de TIPOS de ELEMENTOS</a>
			   <a href="/TP_Web3/ListadodePersona">LISTADO de PERSONAS</a> 
			   <a href="/TP_Web3/Login.html">CERRAR SESIÓN</a>
			   <hr color="pink"><hr color="purple">
			  
			   
	
</form></center></body>
</html>