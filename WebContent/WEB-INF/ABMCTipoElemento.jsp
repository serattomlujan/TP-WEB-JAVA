
<%@page import ="controlers.CtrlABMTipoElemento" %>
<%@page import ="entity.Tipo_Elemento" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABMC Tipos de Elementos</title>

<script type="text/javascript">
   	function submitForm(met) {
   		document.signin.action=met;
   		//document.getElementById("myFrom").submit();
      }
    function validarSiNumero(numero){
    	if (!/^([0-9])*$/.test(numero))
      	alert("El campo debe contener sólo números");
  	}
</script>
</head>
<body>
<%
	Tipo_Elemento encontrado=null;
	String id="";
	String nombre="";
	String cantidad="";
	String tiempo="";
	String dias="";
	boolean encargado=false;
	
	
	if(request.getAttribute("encontrado")!=null){
		encontrado = (Tipo_Elemento)request.getAttribute("encontrado");
		id=String.valueOf(encontrado.getIdtipo_elemento());
		nombre= encontrado.getNombre_tipo();
		cantidad=String.valueOf(encontrado.getCant_max());
		tiempo= String.valueOf(encontrado.getLim_tiempo());
		dias = String.valueOf(encontrado.getDias_anticip());
		encargado= encontrado.getEncargado();
		}
	else nombre=request.getParameter("nombre_tipo");
		
%>
<center>
<form class="form-signin" name="signin" action="" method="POST"><hr color="purple">
		<font face="arial" color="purple"><h2> <b>T I P O S   DE   E L E M E N T O S</h2></font><hr color="purple"><br><br>
		<font face="arial">ID: <input name="idtipo_elemento" id="idtipo_elemento" value="<%=id %>" type="text" readonly="readonly" size=5">
		<font face="arial">&nbsp;&nbsp;Nombre: <input name="nombre_tipo" id="nombre_tipo" required <%if (nombre!=null){  %>value="<%=nombre%>" <%} %>><i><b></b></i>
		
		<button type="submit" name="buscar" onclick="javascript: submitForm('/TP_Web3/TipoElementoAb/buscar')"style="color: black;  background-color: Pink; width: 115px"><strong>Buscar</strong></button>
		<%	if(request.getAttribute("valido")==null){ %><div style="visibility:hidden;"><% }
			else{ %><div style="visibility:visible;"><%} %>
			<b><font face="arial" color="blue"><br>EL NOMBRE DEL TIPO DE ELEMENTO NO EXISTE</font></b></div>
		<font face="arial"> <br></font>Cantidad Máxima: <input name="cant_max" id="cant_max" value="<%=cantidad%>" onChange="validarSiNumero(this.value);"><br><br>
		&nbsp;&nbsp;Tiempo límite:  <input name="lim_tiempo" id="lim_tiempo" value="<%=tiempo %>" onChange="validarSiNumero(this.value);">
		&nbsp;&nbsp;Días anticipación:  <input name="dias" id="dias"  value="<%=dias%>" onChange="validarSiNumero(this.value);"><br><br>
		<input name="encargado" id="encargado" type="checkbox" value="encargado" <%if(encargado) {%> checked <%}%>>
		<font face="arial">Encargado<br><br></font>
		
	<%if(request.getAttribute("nuevo")==null)
	{ %><div style="visibility:hidden;"><% }
	else if(request.getAttribute("nuevo")=="error"){ %><div style="visibility:visible; color: blue">
	<b><font face="arial" color="blue"><br>NO PUEDE REALIZARSE LA OPERACIÓN</font></b></div><%}
	else if(request.getAttribute("nuevo")=="ok"){ %><div style="visibility:visible; color: blue">
	<b><font face="arial" color="blue"><br>EL TIPO DE ELEMENTO FUE REGISTRADO</font></b></div><%}
	else if(request.getAttribute("nuevo")=="modif"){ %><div style="visibility:visible; color: blue">
	<b><font face="arial" color="blue"><br>LOS DATOS FUERON MODIFICADOS</font></b></div><%;}
	else if(request.getAttribute("nuevo")=="elim") {%><div style="visibility:visible; color: blue">
	<b><font face="arial" color="blue"><br>EL TIPO DE ELEMENTO FUE ELIMINADO</font><%;}%></b><br><br></div>
	
		
	<button type="submit" 
	<%if(request.getAttribute("buscar")!=null) {%> onclick="javascript: submitForm('insert')"<%} else{ %> disabled<%} %> style="color: black;  background-color: Pink; width: 120px"><strong>Agregar</strong></button>
	<button type="submit" onclick="javascript: submitForm('update');" style="color: black;  background-color: Pink; width: 115px"><strong>Modificar</strong></button>
	<button type="submit" onclick="javascript: submitForm('delete');" style="color: black;  background-color: Pink; width: 115px"><strong>Borrar</strong></button></font>
	
	<br>

	<a href="#" title="Regresar a página anterior" onclick="history.back()"><h6 align="right">Atrás</h6></a>
	<a href="#" title="salir" onclick="window.close()"> <h6 align="right">Salir</h6></a><br>
	<hr color="pink">
	<center><font face="verdana" size="1" color="pink"><a href='ReservaAb'>RESERVAR ELEMENTO</a>
			   <a href="/TP_Web3/ReservasPendientes"> RESERVAS PENDIENTES</a>
			   <a href="/TP_Web3/PersonaAb">PERSONAS</a>
			   <a href="/TP_Web3/ElementoAb">ELEMENTOS</a>
			   <a href="/TP_Web3/TipoElementoAb">TIPOS de ELEMENTOS</a>
			   <a href="/TP_Web3/ListadoElementos">LISTADO de ELEMENTOS</a>
			   <a href="/TP_Web3/ListadoTipoElementos">LISTADO de TIPOS de ELEMENTOS</a>
			   <a href="/TP_Web3/ListadodePersona">LISTADO de PERSONAS</a> 
			   <a href="/TP_Web3/Login.html">CERRAR SESIÓN</a>
			   <hr color="pink"><hr color="purple">
	
	
	</form>
</center>
</body>
</html>