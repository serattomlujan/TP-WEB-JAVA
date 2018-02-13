<%@page import="entity.Tipo_Elemento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head><center><title>Listar Tipos  Elementos</title><hr color="pink"><font face="arial" color="black"><b><h2> LISTADO DE TIPOS DE ELEMENTOS </h2><hr color="pink"><br><br>
<body>

	
	<div>
	<table border="1">
		<tr>
		  <td><strong> ID </strong></td>
		  <td><strong> NOMBRE </strong></td>
		  <td><strong> CANTIDAD MAXIMA</strong></td>
		  <td><strong> LIMITE TIEMPO</strong></td>
		  <td><strong> DIAS ANTICIPACION</strong></td>
		 
		</tr>
		<% 
		List <Tipo_Elemento> listTipoEle = (List <Tipo_Elemento>)request.getAttribute("list");
		for (Tipo_Elemento te: listTipoEle)
			{ %>
		<tr>
		  <td><%=te.getIdtipo_elemento() %></td>
		  <td><%=te.getNombre_tipo() %></td>
		  <td><%=te.getCant_max() %></td>
		  <td><%=te.getLim_tiempo() %></td>
		  <td><%=te.getDias_anticip() %></td>
		  
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
			   <hr color="pink"><hr color="pink">
	
</form></center></body>
</html>