<%@ page import="controlers.CtrlABMTipoElemento" %>
<%@page import="entity.Tipo_Elemento"%>
<%@page import="java.util.*"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservar Elemento</title>
</head>
<body>
<form class="form-signin" name="signin" action="ReservaAb" method="POST" ><h2 class="form-signin-heading">
	<font face="arial"> <b>RESERVAS </font></h2>
	<font face="arial">ID Reserva <input name="id_reserva" disabled="true"><br><br>
	<font face="arial"> <i><b></b></i></font>
	<font face="arial">Tipo Elemento 
	<%CtrlABMTipoElemento ctrl= new CtrlABMTipoElemento();
		ArrayList<Tipo_Elemento> tipos=new ArrayList<Tipo_Elemento>();
		tipos=ctrl.getAll(); %>
		<select name="tipo" style="width: 154px; height: 29px">
		<option>Seleccione un tipo </option>
		<%for(Tipo_Elemento t : tipos){%>
		<option value="<%=t.getIdtipo_elemento()%>"><%=t.getNombre_tipo()%></option><%} %>
	
	</select><br><br></font>
	Fecha(aaaammdd) <input name="fecha" required><button type="submit" style="color: black;  background-color: aqua; width: 115px">Buscar</button><br>
	<br>Hora(hhmm) <input name="hora" required><br><br>Elemento <select name="elemento" style="width: 147px; height: 27px; "></select><br>
	<br> Detalle <textarea name="detalle"style="width: 212px; height: 67px; "></textarea><br><br>
	<i><b></b></i><button type="submit" style="color: black;  background-color: aqua; width: 115px">Agregar</button><i><b></b></i><i><b></b></i><button type="submit" style="color: black;  background-color: aqua; width: 115px">Cancelar</button>

	<a href="#" title="Regresar a página anterior" onclick="history.back()"><br>Volver </a>
	<a href="#" title="salir" onclick="window.close()">Salir</a>
	

</form>

</body>
</html>