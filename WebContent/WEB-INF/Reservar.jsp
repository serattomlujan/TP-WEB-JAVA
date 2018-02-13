
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


 function validarSiNumero(numero){
    if (!/^([0-9])*$/.test(numero))
      alert("Debe ingresar sólo números");
  }
function checkTime(hora) 
	{ 
	validarSiNumero(hora);
	if (hora=='')alert("El campo no puede estar vacío"); 
	a=hora.charAt(0); //<=2 
	b=hora.charAt(1); //<4 
	c=hora.charAt(2); //<=5 
	if ((a==2 && b>3) || (a>2))
		alert("La hora debe tener un valor entre 00 y 23"); 
	if (c>5)
		alert("Los minutos deben tener un valor entre 00 y 59"); 
	}
function isValidDate(day,month,year)
{
    var dteDate;
    month=month-1;
    dteDate=new Date(year,month,day);
    return ((day==dteDate.getDate()) && (month==dteDate.getMonth()) && (year==dteDate.getFullYear()));
}

function cleanForm(){
	var inputs = document.signin.getElementsByTagName("input");
	var select = document.signin.getElementsByTagName("select")
	for(var i=0;i<inputs.length;i++){
	inputs[i].value = "";
	}
	for(var i=0;i<select.length;i++){
	select[i].value = "";
	}
	
}



  function limpiarFormulario() {
    document.getElementById("signin").reset();
  }


function validarFecha(inp){
   
   patron = /^\d{4}\d{2}\d{2}$/
   if (!patron.test(inp)) {
       alert("Ingrese una fecha válida");}
       
   var patron=new RegExp("^(20)+([0-9]{2})([0-9]{1,2})([0-9]{1,2})$");
 
    if(inp.search(patron)==0)
    {
        var a=inp.substr(0,4);
        var m=inp.substr(4,2);
        var d=inp.substr(6,2);
        var hoy=new Date();
        var fe=new Date(a,m,d);
       
        if(!isValidDate(d,m,a))
   			 alert("Ingrese una fecha válida");
   	    else if(fe<hoy) alert ("La fecha ingresada debe ser mayor a la actual");}
   			 
    }
    
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
		//tipo=reserva.getElemento().getTipo_Elem();
		fecha=String.valueOf(reserva.getFecha());
		hora=String.valueOf(reserva.getHora_ini());
		hora_fin=String.valueOf(reserva.getHora_fin());}
		
	if(request.getAttribute("disponibles")!=null){
		el = (ArrayList<Elemento>)request.getAttribute("disponibles");}
	else {
		fecha=request.getParameter("fecha");
		hora=request.getParameter("hora");
		hora_fin=request.getParameter("hora_fin");}
		
	Persona p=(Persona)session.getAttribute("user");
	
		
%>
<center>

<form class="form-signin" name="signin" id="signin"action="" method="POST" > <h2 class="form-signin-heading">
	
	<hr color="pink">
	<font face="arial" color="pink"> <b>R E S E R V A S </font></h2>
	<hr color="pink"><br><br>
	<font face="arial">
	<font face="arial"> <i><b></b></i></font>
	<font face="arial">Tipo Elemento: 
	
	<%CtrlABMTipoElemento ctrl= new CtrlABMTipoElemento();
		ArrayList<Tipo_Elemento> tipos=new ArrayList<Tipo_Elemento>();
		if(p.getCategoria().getId_categoria()==1) tipos=ctrl.getAll();
		else tipos=ctrl.getAllEncargado();%>
		<select name="tipo" id="tipo" required value="" style="width: 154px; height: 29px">
		<option>Seleccione un tipo </option>
		<%for(Tipo_Elemento t : tipos){%>
			<option value="<%=t.getIdtipo_elemento()%>"><%=t.getNombre_tipo()%></option><%;}%>
		
	</select><br><br></font>
	
Fecha(aaaammdd): <input type="text" name="fecha" id="fecha" required size="8" maxlength="8" 
<%if (fecha!=null){  %>value="<%=fecha%>" <%} %>onChange="validarFecha(this.value)">

&nbsp;&nbsp;Hora Inicio(hhmm):  <input name="hora" id="hora"  required size="4"  maxlength="4" 
	<%if (fecha!=null){  %>value="<%=hora%>" <%} %> onChange="checkTime(this.value)"> 
	 &nbsp;&nbsp;&nbsp; Hora Fin:   <input name="hora_fin"  id="hora_fin" required size="4"  maxlength="4" 
	   <%if (fecha!=null){  %>value="<%=hora_fin%>"<%} %>onChange="checkTime(this.value)">
	 <button name="buscar" id="buscar" onclick="javascript: submitForm('/TP_Web3/ReservaAb/buscar')" style="color: black;  background-color: Pink; width: 115px"><strong>Buscar</strong></button><br><br>	
	 Elemento <select name="elemento" id="elemento"style="width: 147px; height: 27px">
		<%if(el!=null){
		for(Elemento e: el){ %>
			<option value="<%=e.getIdelemento()%>"><%=e.getNombre()%></option><%;}}%>
			</select><br>
	<%	if(request.getAttribute("valido")==null)
	{ %><div style="visibility:hidden;"><% }
	else{ %><div style="visibility:visible;"><%} %>
	<b><font face="arial" color="blue"><br>NO HAY ELEMENTOS DISPONIBLES DE ESE TIPO</font></b></div>
	Detalle <textarea name="detalle"style="width: 212px; height: 67px; "></textarea><br><br>
	
	<% if(request.getAttribute("reservada")==null)
	{ %><div id="mensaje" style="visibility:hidden;color:red;"><% }

	else if(request.getAttribute("reservada")=="error"){%><div id="mensaje" style="visibility:visible; color:blue;">
	<b>NO PUEDE REALIZARSE LA OPERACION</b></div><br><%}
	else if(request.getAttribute("reservada")=="ok"){%><div id="mensaje" style="visibility:visible; color:blue;">
	<b>RESERVA REGISTRADA!!!</b></div><br><%}
	else if(request.getAttribute("reservada")=="limite"){ %><div id="mensaje" style="visibility:visible; color: blue">
	<b><font face="arial" color="blue"><br>SUPERA EL LIMITE DE TIEMPO PARA ESE TIPO DE ELEMENTO</font></b></div><%;}
	else if(request.getAttribute("reservada")=="maximo") {%><div id="mensaje" style="visibility:visible; color: blue">
	<b><font face="arial" color="blue"><br>SUPERA LA CANTIDAD MAXIMA DE RESERVAS DE ESE TIPO</font></b></div><%;}
	else if(request.getAttribute("reservada")=="anticip") {%><div id="mensaje" style="visibility:visible; color: blue">
	<b><font face="arial" color="blue"><br>NO CUMPLE CON LA CANTIDAD DE DIAS DE ANTICIPACION</font></b><%;}%><br><br></div>
	

	
	<i><b></b></i><button name="insert" type="submit" id="insert" style="color: black;  background-color: Pink; width: 115px"
	 <%if(request.getAttribute("reservada")=="no" || request.getAttribute("disponibles")!=null){ %>onclick="javascript: submitForm('insert')" <%;}
	 else %> disabled<%; %>><strong>Agregar</strong></button>
	<button type="button"name="Limpiar" id="limpiar" onclick= "cleanForm()"style="color: black;  background-color: Pink; width: 115px"><strong>Limpiar</strong></button>
	<!--  <button id="limpiar" style="color: black;  background-color: Pink; width: 115px">Limpiar</button>
     -->
	 

	 

	<br>

	<a href="#" title="Regresar a página anterior" onclick="history.back()"><h6 align="right">Atrás</h6></a>
	<a href="#" title="salir" onclick="window.close()"> <h6 align="right">Salir</h6></a><br>
	<hr color="pink">
	<%if(p.getCategoria().getId_categoria()==2){ %>
	<center><font face="verdana" size="1" color="pink">
			   <a href="/TP_Web3/ReservaAb">RESERVAR ELEMENTO</a>
			   <a href="/TP_Web3/ReservasPendientes"> RESERVAS PENDIENTES</a>
			   <a href="/TP_Web3/PersonaAb">PERSONAS</a>
			   <a href="/TP_Web3/ElementoAb">ELEMENTOS</a>
			   <a href="/TP_Web3/TipoElementoAb">TIPOS de ELEMENTOS</a>
			   <a href="/TP_Web3/ListadoElementos">LISTADO de ELEMENTOS</a>
			   <a href="/TP_Web3/ListadoTipoElementos">LISTADO de TIPOS de ELEMENTOS</a>
			   <a href="/TP_Web3/ListadodePersona">LISTADO de PERSONAS</a>
			   <a href="/TP_Web3/Login.html">CERRAR SESIÓN</a>
			    <hr color="pink">
	<hr color="pink">
	<%}else{ %>	<center><font face="verdana" size="1" color="pink"><a href='/TP_Web3/ReservaAb'>RESERVAR ELEMENTO</a>
			   <a href="/TP_Web3/ReservasPendientes"> MIS RESERVAS</a>
			   <a href="/TP_Web3/Login.html">CERRAR SESIÓN</a> <hr color="pink">
			   <hr color="pink"><%} %>
		   

</form></center>
 
</body>
</html>
