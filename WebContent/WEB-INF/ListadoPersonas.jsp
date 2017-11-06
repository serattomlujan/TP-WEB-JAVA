<%@page import="entity.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head><title>Listar Personas</title><font face="arial"> <b> <h2>LISTADO de PERSONAS </h2>
<body>

	
	<div>
	<table border="1">
		<tr>
		  <td><strong> APELLIDO </strong></td>
		  <td><strong> NOMBRE </strong></td>
		  <td><strong> DNI</strong></td>
		</tr>
		<% 
		List <Persona> listPersona = (List <Persona>)request.getAttribute("list");
		for (Persona p: listPersona)
			{ %>
		<tr>
		  <td><strong><%=p.getApellido() %></strong></td>
		  <td><strong><%=p.getNombre() %></strong></td>
		  <td><strong><%=p.getDni() %></strong></td>
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