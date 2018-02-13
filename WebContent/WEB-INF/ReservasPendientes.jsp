<%@page import="entity.Reserva"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entity.Persona"%>

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
</head><center><title>Reservas Pendientes</title><hr color="pink">
<font face="arial" color="black"> 

<h2><b> RESERVAS PENDIENTES</h2><hr color="pink"><br><br>
<body>
<% Persona p=(Persona)session.getAttribute("user");%>
	
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
		  <td><strong> HORA INICIO</strong></td>
		   <td><strong> HORA FIN</strong></td>
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

		  <td><%=r.getHora_ini() %></td>
		  <td><%=r.getHora_fin() %></td>
		  <td><button type="submit"  onclick="javascript: submitForm('ReservasPendientes/cancelarReserva')" 
		  value="<%=r.getId_reserva() %>" id="cancelar" name="cancelar"  style="color: black;  background-color: Pink; width: 115px">Cancelar</button>
	</tr>
			
			<%	
				};
			%>
	</table>
	</form>		
	</div>
	<!-- <button type="submit" style="color: black;  background-color: aqua; width: 115px">Cancelar Reserva</button> -->
<br>

	<a href="#" title="Regresar a página anterior" onclick="history.back()"><h6 align="right">Atrás</h6></a>
	<a href="#" title="salir" onclick="window.close()"> <h6 align="right">Salir</h6></a><br>
	<hr color="pink">
	<%if(p.getCategoria().getId_categoria()==2){ %>
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
			   <%}else{ %>	<center><font face="verdana" size="1" color="pink"><a href='ReservaAb'>RESERVAR ELEMENTO</a>
			   <a href="/TP_Web3/ReservasPendientes"> MIS RESERVAS</a>
			   <a href="/TP_Web3/Login.html">CERRAR SESIÓN</a> <hr color="pink">
			   <hr color="pink"><%} %>
		   
	
</form></center></body>
</html>
