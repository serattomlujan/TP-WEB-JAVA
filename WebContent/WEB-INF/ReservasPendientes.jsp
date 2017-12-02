<%@page import="entity.Reserva"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
   	function submitForm(met) {
   		document.signin.action=met;
   	

   		//document.getElementById("myFrom").submit();
      }
</script>
</head><title>Reservas Pendientes</title><font face="arial"> 
<h2><b> RESERVAS PENDIENTES</h2>
<body>

	
	<div>
	<form name="signin" method="post" action="">
	<table border="1" id=>
		<tr>
		  <td><strong> ID </strong></td>
		  <td><strong> APELLIDO </strong></td>
		  <td><strong> NOMBRE </strong></td>
		  <td><strong> ELEMENTO </strong></td>
		  <td><strong> TIPO </strong></td>
		  <td><strong> FECHA </strong></td>
		  <td><strong> HORA </strong></td>
		  <td><strong> ACCIONES </strong></td>				 
		</tr>
		<% 
		List <Reserva> listResPen = (List <Reserva>)request.getAttribute("list");
		for (Reserva r: listResPen)
			{ %>
		<tr>
		  <td><%=r.getId_reserva() %></td>
		  <td><%=r.getPersona().getApellido() %></td>
		  <td><%=r.getPersona().getNombre() %></td>
		  <td><%=r.getElemento().getNombre() %></td>
		  <td><%=r.getElemento().getTipo_Elem().getNombre_tipo()%></td>
		  <td><%=r.getFecha()%></td>
		  <td><%=r.getHora() %></td>
		  <td><button type="submit"  onclick="javascript: submitForm('ReservasPendientes/cancelarReserva')" value="<%=r.getId_reserva() %>" id="cancelar" name="cancelar"  style="color: black;  background-color: aqua; width: 115px">Cancelar</button>
		</tr>
			
			<%	
				};
			%>
	</table>
	</form>		
	</div>
	<!-- <button type="submit" style="color: black;  background-color: aqua; width: 115px">Cancelar Reserva</button> -->
	<a href="#" title="Regresar a página anterior" onclick="history.back()">Volver</a>
	<a href="#" title="salir" onclick="window.close()">Salir</a>
	
</form></body>
</html>