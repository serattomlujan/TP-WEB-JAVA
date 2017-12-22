
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
      	alert("El campo debe contener s�lo n�meros");
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
		<font face="arial" color="purple"><h2> <b>T I P O S    E L E M E N T O S</h2></font><hr color="purple"><br><br>
		<font face="arial">ID: <input name="idtipo_elemento" id="idtipo_elemento" value="<%=id %>" type="text" readonly="readonly">
		<font face="arial">&nbsp;&nbsp;Nombre: <input name="nombre_tipo" id="nombre_tipo" required <%if (nombre!=null){  %>value="<%=nombre%>" <%} %>><i><b></b></i>
		
		<button type="submit" name="buscar" onclick="javascript: submitForm('TipoElementoAb/buscar')"style="color: black;  background-color: Pink; width: 115px"><strong>Buscar</strong></button>
		<%	if(request.getAttribute("valido")==null){ %><div style="visibility:hidden;"><% }
			else{ %><div style="visibility:visible;"><%} %>
			<b><font face="arial" color="blue"><br>EL NOMBRE DEL TIPO DE ELEMENTO NO EXISTE</font></b></div>
		<font face="arial"> <br></font>Cantidad M�xima: <input name="cant_max" id="cant_max" value="<%=cantidad%>" onChange="validarSiNumero(this.value);">
		&nbsp;&nbsp;Tiempo l�mite:  <input name="lim_tiempo" id="lim_tiempo" value="<%=tiempo %>" onChange="validarSiNumero(this.value);">
		&nbsp;&nbsp;Anticipaci�n:  <input name="dias" id="dias" value="dias" value="<%=dias%>" onChange="validarSiNumero(this.value);"><br><br>
		<input name="encargado" id="encargado" type="checkbox" value="encargado" <%if(encargado) {%> checked <%}%>>
		<font face="arial">Encargado<br><br></font>
		
	<button type="submit" 
	<%if(request.getAttribute("buscar")==null) {%> onclick="javascript: submitForm('TipoElementoAb/insert')"<%} else{ %> onclick="javascript: submitForm('insert');alert('Tipo ingresado con �xito')"<%} %> style="color: black;  background-color: Pink; width: 120px"><strong>Agregar</strong></button>
	<button type="submit" onclick="javascript: submitForm('update');alert('Tipo modificado con �xito')" style="color: black;  background-color: Pink; width: 115px"><strong>Modificar</strong></button>
	<button type="submit" onclick="javascript: submitForm('delete');alert('Tipo eliminado con �xito')" style="color: black;  background-color: Pink; width: 115px"><strong>Borrar</strong></button></font>
	
	<br>

	<a href="#" title="Regresar a p�gina anterior" onclick="history.back()"><h6 align="right">Atr�s</h6></a>
	<a href="#" title="salir" onclick="window.close()"> <h6 align="right">Salir</h6></a><br>
	<hr color="pink">
	<center><font face="verdana" size="1" color="pink"><a href='ReservaAb'>RESERVAR ELEMENTO</a>
			   <a href="ReservasPendientes"> RESERVAS PENDIENTES</a>
			   <a href="PersonaAb">PERSONAS</a>
			   <a href="ElementoAb">ELEMENTOS</a>
			   <a href="TipoElementoAb">TIPOS de ELEMENTOS</a>
			   <a href="ListadoElementos">LISTADO de ELEMENTOS</a>
			   <a href="ListadoTipoElementos">LISTADO de TIPOS de ELEMENTOS</a>
			   <a href="ListadodePersona">LISTADO de PERSONAS</a> <hr color="pink"><hr color="purple">
	
	
	</form>
</center>
</body>
</html>