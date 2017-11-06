<%@page import="entity.Elemento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Elementos</title>
</head><title></title><font face="arial"> <b> <h2> LISTADO de ELEMENTOS</h2>
<body>

	
	<div>
	<table border-collapse: separate; border: black 5px solid; >
		<tr margin: 15px;
  			padding: 15px>
		  <td><strong> NOMBRE </strong></td>
		  <td><strong> ID  </strong></td>
		  <td><strong> TIPO </strong></td>
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
	</table><br>		
	</div>
	<button type="submit" style="color: black;  background-color: aqua; width: 115px">Editar</button>
	<button type="submit" style="color: black;  background-color: aqua; width: 115px">Salir</button>
	</form></body>
</html>