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
	
	<a href="#" title="Regresar a página anterior" onclick="history.back()">Volver</a>
	<a href="#" title="salir" onclick="window.close()">Salir</a>
	
</form></body>
</html>