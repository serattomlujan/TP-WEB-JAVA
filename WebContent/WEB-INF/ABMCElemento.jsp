

<%@ page import="controlers.CtrlABMElemento" %>
<%@page import="entity.Tipo_Elemento"%>
<%@page import="entity.Elemento"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABMC Elementos</title>
<script type="text/javascript">
   	function submitForm(met) {
   		document.signin.action=met;
   		//document.getElementById("myFrom").submit();
      }
</script>
</head>
<body style="height: 215px; ">

<%
	Elemento encontrada=null;
	String id="";
	String nombre="";
	Tipo_Elemento ti= new Tipo_Elemento();
	String idCat="";
	
	
	if(request.getAttribute("encontrada")!=null){
		encontrada = (Elemento)request.getAttribute("encontrada");
		id=String.valueOf(encontrada.getIdelemento());
		nombre= encontrada.getNombre();
		ti= encontrada.getTipo_Elem();
		}
		
		else nombre=request.getParameter("nombre");
	
%>


<center>
<form class="form-signin" name="signin" action="" method="POST">
		<hr color="purple">
		<font face="arial" color="purple"><h2><b>E L E M E N T O S</h2> </font><hr color="purple"> <br><br>
<strong>		<font face="arial">ID: <input name="idelemento" id="idelemento"type="text" readonly="readonly" value="<%=id %>" size="5">
		<font face="arial">&nbsp;&nbsp;Nombre: <input name="nombre" required id="nombre"  <%if (nombre!=null){  %>value="<%=nombre%>"<%} %>><i><b></b></i>
		<button type="submit"  onclick="javascript: submitForm('/TP_Web3/ElementoAb/buscar')" style="color: black;  background-color: Pink; width: 115px"><strong>Buscar</strong></button>
	<%	if(request.getAttribute("valido")==null)
	{ %><div style="visibility:hidden;"><% }
	else{ %><div style="visibility:visible;"><%} %>
	<b><font face="arial" color="blue"><br>EL NOMBRE DEL ELEMENTO NO EXISTE</font></b></div>
	
		<font face="arial"><br>Tipo Elemento:
		<%CtrlABMElemento ctrl= new CtrlABMElemento();
		ArrayList<Tipo_Elemento> tipos=new ArrayList<Tipo_Elemento>();
		tipos=ctrl.getTipos(); %>
		<select name="tipo" id="tipo" required style="width: 154px; height: 29px">
		
		<%for(Tipo_Elemento t : tipos){%>
		<option value="<%=t.getIdtipo_elemento()%>"><%=t.getNombre_tipo()%></option><%} %>
		<%if(ti.getNombre_tipo() == null){ %>
			 <option selected>Seleccione un tipo</option><%;}
			else {%><option selected value="<%=ti.getIdtipo_elemento()%>"><%=ti.getNombre_tipo()%> 
			</option><%;}%>
	
		
		</select><br><br><br>
	<i><b></b></i></strong>
	<%if(request.getAttribute("nuevo")==null)
	{ %><div style="visibility:hidden;"><% }
	else if(request.getAttribute("nuevo")=="error"){ %><div style="visibility:visible; color: blue">
	<b><font face="arial" color="blue"><br>NO PUEDE REALIZARSE LA OPERACIÓN</font></b></div><%}
	else if(request.getAttribute("nuevo")=="ok"){ %><div style="visibility:visible; color: blue">
	<b><font face="arial" color="blue"><br>EL ELEMENTO FUE REGISTRADO</font></b></div><%}
	else if(request.getAttribute("nuevo")=="modif"){ %><div style="visibility:visible; color: blue">
	<b><font face="arial" color="blue"><br>LOS DATOS FUERON MODIFICADOS</font></b></div><%;}
	else if(request.getAttribute("nuevo")=="elim") {%><div style="visibility:visible; color: blue">
	<b><font face="arial" color="blue"><br>EL ELEMENTO FUE ELIMINADO</font><%;}%></b><br><br></div>
	
	
	<button type="submit" 
	<%if(request.getAttribute("buscar")!=null) {%> onclick="javascript: submitForm('insert');"<%} else{ %> disabled<%;} if(request.getAttribute("nuevo")=="ok"){%> disabled <%} %> style="color: black;  background-color: Pink; width: 115px"><strong>Agregar</strong></button><i><b></b></i>
	<button type="submit" onclick="javascript: submitForm('update')" style="color: black;  background-color: Pink; width: 115px"><strong>Modificar</strong></button><i><b></b></i>
	<button type="submit" onclick="javascript: submitForm('delete')" style="color: black;  background-color:Pink; width: 115px"><strong>Borrar</strong></button>
	
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
			   <a href="/TP_Web3/Login.html">CERRAR SESIÓN</a><hr color="pink">
			   <hr color="purple">
	</font></center>
	



</form></center>
	</body>

</html>