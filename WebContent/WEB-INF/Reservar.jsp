<%@ page import="controlers.CtrlABMTipoElemento" %>
<%@ page import="controlers.CtrlABMElemento" %>
<%@page import="entity.Tipo_Elemento"%>
<%@page import="entity.Elemento"%>
<%@page import="entity.Reserva"%>
<%@page import="java.util.*"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservar Elemento</title>
<script type="text/javascript">
   	function submitForm(met) {
   		document.signin.action=met;
   		//document.getElementById("myFrom").submit();
      }
</script>
</head>
<body>
<%
	ArrayList<Elemento> el=null;
	Reserva reserva=null;
	String fecha_r="";
	String hora_r="";
	Tipo_Elemento tipo= new Tipo_Elemento();
	
	
	if(request.getAttribute("reserva")!=null){
		reserva=(Reserva)request.getAttribute("reserva");
		fecha_r=String.valueOf(reserva.getFecha());
		hora_r=String.valueOf(reserva.getHora());}
		
	if(request.getAttribute("disponibles")!=null){
		el = (ArrayList<Elemento>)request.getAttribute("disponibles");}
	
		
%>


<form class="form-signin" name="signin" action="ReservaAb" method="POST" ><h2 class="form-signin-heading">
	<font face="arial"> <b>RESERVAS </font></h2>
	<font face="arial">ID Reserva <input name="id_reserva" disabled="true" style="width: 89px; "><br><br>
	<font face="arial"> <i><b></b></i></font>
	<font face="arial">Tipo Elemento 
	
	<%CtrlABMTipoElemento ctrl= new CtrlABMTipoElemento();
		ArrayList<Tipo_Elemento> tipos=new ArrayList<Tipo_Elemento>();
		tipos=ctrl.getAll();%>
		<select name="tipo" id="tipo" required style="width: 154px; height: 29px">
		<option>Seleccione un tipo </option>
		<%for(Tipo_Elemento t : tipos){%>
			<option value="<%=t.getIdtipo_elemento()%>"><%=t.getNombre_tipo()%></option><%;}%>
		
	</select><br><br></font>
	
	Fecha(aaaammdd) <input type="text" name="fecha" id="fecha" required size="8" maxlength="8" value="<%=fecha_r%>"><br>
	<br>Hora(hhmm)  <input type="text" name="hora" id="hora" size="4"  maxlength="4" value="<%=hora_r%>"required> 
	  <button name="buscar" id="buscar" type="submit" onclick="javascript: submitForm('ReservarElemento/buscar')" style="color: black;  background-color: aqua; width: 115px">Buscar</button><br><br>
	<label>Elemento </label><select name="elemento" id="elemento"style="width: 147px; height: 27px">
		<% if(el!=null){
			for(Elemento e: el){ %>
			<option value="<%=e.getIdelemento()%>"><%=e.getNombre()%></option><%;}}%>
			</select>
			<br>
	<br> <label>Detalle </label><textarea name="detalle"style="width: 212px; height: 67px; "></textarea><br><br>
	<i><b></b></i><button type="submit" onclick="javascript: submitForm('ReservarElemento/insert')"style="color: black;  background-color: aqua; width: 115px">Agregar</button><i><b></b></i><i><b></b></i><button type="submit" style="color: black;  background-color: aqua; width: 115px">Cancelar</button>

	<a href="#" title="Regresar a página anterior" onclick="history.back()"><br>Volver </a>
	<a href="#" title="salir" onclick="window.close()">Salir</a>
	

</form>
<script>


</script>

</body>
</html>