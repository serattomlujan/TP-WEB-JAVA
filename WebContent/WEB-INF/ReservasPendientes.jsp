<%@page import="entity.Reserva"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head><title></title><font face="arial"> <b> Reservas Pendientes
<body>

	
	<div>
	<table>
		<tr>
		  <td><strong> Id Reserva </strong></td>
		  <td><strong> Estado </strong></td>
		 
		</tr>
		<% 
		List <Reserva> listResPen = (List <Reserva>)request.getAttribute("list");
		for (Reserva r: listResPen)
			{ %>
		<tr>
		  <td><strong><%=r.getId_reserva() %></strong></td>
		  <td><strong><%=r.getEstado() %></strong></td>
		 
		</tr>
			
			<%	
				};
			%>
	</table>		
	</div>
	
	<button type="submit" style="color: black;  background-color: aqua; width: 115px">Salir</button>
	</form></body>
</html>