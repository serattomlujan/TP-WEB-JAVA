<%@page import="entity.Elemento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>

	<center>
	
	
	<center><title>Listar Elementos</title><hr color="purple"><font face="arial" color="Purple"> <b> <h2> LISTADO DE ELEMENTOS</h2></b></center><hr color="purple"><div>
	<br><br><strong><table border="1" color="purple" >
		<tr >
		   <td><strong> ID  </strong></td>
		  <td><strong> NOMBRE </strong></td>
		  <td><strong> TIPO </strong></td>
		</tr>
		<% 
		List <Elemento> listElemento = (List <Elemento>)request.getAttribute("list");
		for (Elemento e: listElemento)
			{ %>
		<tr>
		  <td><%=e.getIdelemento() %></td>
		  <td><%=e.getNombre() %></td>
		  <td><%=e.getTipo_Elem() %></td>
		</tr>
			
			<%	
				};
			%>
	</table><br>		</font>
	</div></center>
	<br>

	<a href="#" title="Regresar a página anterior" onclick="history.back()"><h6 align="right"><font face="arial">Atrás</h6></a>
	<a href="#" title="salir" onclick="window.close()"> <h6 align="right">Salir</h6></a><br></font>
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
	</font></strong></form></body>
</html>