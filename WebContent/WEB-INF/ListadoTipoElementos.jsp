<%@page import="entity.Tipo_Elemento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head><title></title><font face="arial"> <b> Lista de Tipo de Elementos
<body>

	
	<div>
	<table>
		<tr>
		  <td><strong> Id Elemento </strong></td>
		  <td><strong> Nombre </strong></td>
		  <td><strong> Cantidad Maxima</strong></td>
		  <td><strong> Limite de Tiempo</strong></td>
		  <td><strong> Dias de anticipacion</strong></td>
		  <td><strong> Encargado</strong></td>
		</tr>
		<% 
		List <Tipo_Elemento> listTipoEle = (List <Tipo_Elemento>)request.getAttribute("list");
		for (Tipo_Elemento te: listTipoEle)
			{ %>
		<tr>
		  <td><strong><%=te.getIdtipo_elemento() %></strong></td>
		  <td><strong><%=te.getNombre_tipo() %></strong></td>
		  <td><strong><%=te.getCant_max() %></strong></td>
		  <td><strong><%=te.getLim_tiempo() %></strong></td>
		  <td><strong><%=te.getDias_anticip() %></strong></td>
		  <td><strong><%=te.getEncargado() %></strong></td>
		</tr>
			
			<%	
				};
			%>
	</table>		
	</div>
	
	<button type="submit" style="color: black;  background-color: aqua; width: 115px">Salir</button>
	</form></body>
</html>