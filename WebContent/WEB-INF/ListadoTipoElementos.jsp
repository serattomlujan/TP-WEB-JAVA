<%@page import="entity.Tipo_Elemento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head><title>Listar Tipos de Elementos</title><font face="arial"> <b><h2> LISTADO DE TIPOS DE ELEMENTOS </h2>
<body>

	
	<div>
	<table border="1">
		<tr>
		  <td><strong> ID </strong></td>
		  <td><strong> NOMBRE </strong></td>
		  <td><strong> CANTIDAD MAXIMA</strong></td>
		  <td><strong> LIMITE TIEMPO</strong></td>
		  <td><strong> DIAS ANTICIPACION</strong></td>
		  <td><strong> ENCARGADO</strong></td>
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
	</table><br>		
	</div>
	
	<button type="submit" style="color: black;  background-color: aqua; width: 115px">Editar</button>
	<button type="submit" style="color: black;  background-color: aqua; width: 115px">Salir</button>
	</form></body>
</html>