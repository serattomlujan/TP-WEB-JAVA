<%@ page import="controlers.CtrlABMTipoElemento" %>
<%@ page import="controlers.CtrlABMElemento" %>
<%@page import="entity.Tipo_Elemento"%>
<%@page import="entity.Elemento"%>
<%@page import="entity.Reserva"%>
<%@page import="java.util.*"%>
<%@page import="entity.Persona"%>


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
      /*function validarFechaMenorActual(date){
      var x=new Date();
      Date f=controlers.CtrlReserva.convertirFecha(date);
      var fecha = date;
      x.setFullYear(fecha[2],fecha[1]-1,fecha[0]);
      var today = new Date();
 	  if (f >= today)
        alert ("La fecha ingresada debe ser superior a la actual"); no funciona
}*/
</script>
</head>
<body>
<%
	ArrayList<Elemento> el=null;
	Reserva reserva=null;
	String fecha="";
	String hora="";
	String hora_fin="";
	Tipo_Elemento tipo= new Tipo_Elemento();
	
	
	if(request.getAttribute("reserva")!=null){
		reserva=(Reserva)request.getAttribute("reserva");
		fecha=String.valueOf(reserva.getFecha());
		hora=String.valueOf(reserva.getHora_ini());
		hora_fin=String.valueOf(reserva.getHora_fin());}
		
	if(request.getAttribute("disponibles")!=null){
		el = (ArrayList<Elemento>)request.getAttribute("disponibles");}
		
	Persona p=(Persona)session.getAttribute("user");
	
		
%>


<form class="form-signin" name="signin" action="" method="POST" > <h2 class="form-signin-heading">
	<input id="dni" name="dni" value="<%=p.getDni()%>" style="visibility:hidden;"/>
	</br>
	<font face="arial"> <b>RESERVAS </font></h2>
	<font face="arial">
	<font face="arial"> <i><b></b></i></font>
	<font face="arial">Tipo Elemento 
	
	<%CtrlABMTipoElemento ctrl= new CtrlABMTipoElemento();
		ArrayList<Tipo_Elemento> tipos=new ArrayList<Tipo_Elemento>();
		if(p.getCategoria().getId_categoria()==1) tipos=ctrl.getAll();
		else tipos=ctrl.getAllEncargado();%>
		<select name="tipo" id="tipo" required style="width: 154px; height: 29px">
		<option>Seleccione un tipo </option>
		<%for(Tipo_Elemento t : tipos){%>
			<option value="<%=t.getIdtipo_elemento()%>"><%=t.getNombre_tipo()%></option><%;}%>
		
	</select><br><br></font>
	
Fecha(aaaammdd) <input type="text" name="fecha" id="fecha" size="8" maxlength="8" value="<%=fecha%>" ><br>

	<br>Hora Inicio (hhmm)  <input name="hora" id="hora" size="4"  maxlength="4" value="<%=hora%>"> 
	  Hora Fin (hhmm)  <input name="hora_fin" id="hora_fin" size="4"  maxlength="4" value="<%=hora_fin%>">
	  <button name="buscar" id="buscar" onclick="javascript: submitForm('ReservaAb/buscar')" style="color: black;  background-color: Pink; width: 115px">Buscar</button><br><br>	Elemento <select name="elemento" id="elemento"style="width: 147px; height: 27px">
		<%if(el!=null){
		for(Elemento e: el){ %>
			<option value="<%=e.getIdelemento()%>"><%=e.getNombre()%></option><%;}}%>
			</select><br>
	<%	if(request.getAttribute("valido")==null)
	{ %><div style="visibility:hidden;"><% }
	else{ %><div style="visibility:visible;"><%} %>
	<b><font face="arial" color="blue"><br>NO HAY ELEMENTOS DISPONIBLES</font></b></div>
	<br> Detalle <textarea name="detalle"style="width: 212px; height: 67px; "></textarea><br><br>
	<i><b></b></i>  <button name="insert" type="submit" id="insert" onclick="javascript: submitForm('insert')" style="color: black;  background-color: Pink; width: 115px">Agregar</button>

	<a href="#" title="Regresar a página anterior" onclick="history.back()"><br>Atrás </a>
	<!--  <a href="#" title="salir" onclick="window.close()">Salir</a>-->
		<a href="#" title="Menu" onclick="javascript: submitForm('/Start')">Menu</a>
	

</form>
 
</body>
</html>
