<%@page import="entity.Elemento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head><title></title><font face="arial"> <b> Lista de Elementos
<body>

	
	<div>
	<table>
		<tr>
		  <td><strong> Nombre Elemento </strong></td>
		  <td><strong> Id Elemento </strong></td>
		  <td><strong> Tipo Elemento</strong></td>
		</tr>
		<% 
		List <Elemento> listElemento = (List <Elemento>)request.getAttribute("list");
		for (Elemento e: listElemento)
			{ %>
		<tr>
		  <td><strong><%=e.getNombre() %></strong></td>
		  <td><strong><%=e.getIdelemento() %></strong></td>
		  <td><strong><%=e.getTipo_Elem() %></strong></td>
		</tr>
			
			<%	
				};
			%>
	</table>		
	</div>
	
	<button type="submit" style="color: black;  background-color: aqua; width: 115px">Salir</button>
	</form></body>
</html>