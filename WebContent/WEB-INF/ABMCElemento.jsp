<%@ page import="controlers.CtrlABMElemento" %>
<%@page import="entity.Tipo_Elemento"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABMC Elementos</title>
</head>
<body style="height: 215px; ">



<form class="form-signin" name="signin" action="ElementoAb" method="POST">
		
		<font face="arial"><h2><b>ELEMENTOS</h2> <br></font>
	<font face="arial">ID <input name="idelemento" type="text"disabled="true"><br><br>
		<font face="arial">Nombre <input name="nombre"><i><b></b></i>
		<button type="submit" style="color: black;  background-color: aqua; width: 115px">Buscar</button>
	
		<font face="arial"><br><br>Tipo Elemento
		<%CtrlABMElemento ctrl= new CtrlABMElemento();
		ArrayList<Tipo_Elemento> tipos=new ArrayList<Tipo_Elemento>();
		tipos=ctrl.getTipos(); %>
		<select name="tipo" style="width: 154px; height: 29px">
		<option>Seleccione un tipo </option>
		<%for(Tipo_Elemento t : tipos){%>
		<option value="<%=t.getIdtipo_elemento()%>"><%=t.getNombre_tipo()%></option><%} %>
	
		
		</select><br><br><br>
	<i><b></b></i><button type="submit" style="color: black;  background-color: aqua; width: 115px">Agregar</button><i><b></b></i><button type="submit" style="color: black;  background-color: aqua; width: 115px">Modificar</button><i><b></b></i><button type="submit" style="color: black;  background-color: aqua; width: 115px">Borrar</button>
</form>
	</body>

</html>