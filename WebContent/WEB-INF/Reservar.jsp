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

function validarFecha(inp){
   
   patron = /^\d{4}\d{2}\d{2}$/
   if (!patron.test(inp)) {
       alert("Ingrese una fecha válida");}
       
   var patron=new RegExp("^(19|20)+([0-9]{2})([0-9]{1,2})([0-9]{1,2})$");
 
    if(inp.search(patron)==0)
    {
        var a=inp.substr(0,4);
        var m=inp.substr(4,2);
        var d=inp.substr(6,2);
        
        if(!isValidDate(d,m,a))
   			 alert("Ingrese una fecha válida");}
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


<form class="form-signin" name="signin" action="" method="POST" > <h2 class="form-signin-heading">
	<!--<input id="idreserva" name="idreserva" value="<%=p.getDni()%>" style="visibility:hidden;"/>-->
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
	
Fecha(aaaammdd) <input type="text" name="fecha" id="fecha" required size="8" maxlength="8" 
<%if (fecha!=null){  %>value="<%=fecha%>" <%} %>onChange="validarFecha(this.value)"><br>

	<br>Hora Inicio (hhmm)  <input name="hora" id="hora"  required size="4"  maxlength="4" 
	<%if (fecha!=null){  %>value="<%=hora%>" <%} %> onChange="checkTime(this.value)"> 
	  Hora Fin (hhmm)  <input name="hora_fin" id="hora_fin" required size="4"  maxlength="4" 
	   <%if (fecha!=null){  %>value="<%=hora_fin%>"<%} %>onChange="checkTime(this.value)">
	  <button name="buscar" id="buscar" onclick="javascript: submitForm('ReservaAb/buscar')" style="color: black;  background-color: Pink; width: 115px">Buscar</button><br><br>	Elemento <select name="elemento" id="elemento"style="width: 147px; height: 27px">
		<%if(el!=null){
		for(Elemento e: el){ %>
			<option value="<%=e.getIdelemento()%>"><%=e.getNombre()%></option><%;}}%>
			</select><br>
	<%	if(request.getAttribute("valido")==null)
	{ %><div style="visibility:hidden;"><% }
	else{ %><div style="visibility:visible;"><%} %>
	<b>NO HAY ELEMENTOS DISPONIBLES</b></div>
	<br> Detalle <textarea name="detalle"style="width: 212px; height: 67px; "></textarea>
	<% if(request.getAttribute("reservada")==null)
	{ %><div style="visibility:hidden;color:red;"><% }
	else{ %><div style="visibility:visible; color:red;"><%} %>
	<b>RESERVA REGISTRADA</b></div>
	
	<br><br>
	<i><b></b></i><button name="insert" type="submit" id="insert" style="color: black;  background-color: Pink; width: 115px"
	 <%if(request.getAttribute("reservada")==null){ %>onclick="javascript: submitForm('insert')" <%}
	 else %>disabled<%; %>>Agregar</button>

	<!--  <% if(p.getCategoria().getId_categoria()==1) %> <a href="/WEB-INF/MenuEncargado.jsp" ><br>Home </a><%;
	 if(p.getCategoria().getId_categoria()==2)%> <a href="MenuAdmin" ><br>Home </a><%;
	  if(p.getCategoria().getId_categoria()==3)%>><a href="/WEB-INF/MenuUsuario.jsp"><br>Home </a><%;%>
	 
	 <a href="#" title="volver" onclick="window.open('WEB-INF/MenuAdmin.jsp')">Menu</a>-->
		<a href="#" title="salir" onclick="window.close()">Salir</a>
	

</form>
 
</body>
</html>
