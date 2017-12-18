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
		
%>

<form class="form-signin" name="signin" action="" method="POST">
		<font face="arial"><h2> <b>TIPOS  DE ELEMENTOS</h2></font>
		<font face="arial">ID <input name="idtipo_elemento" id="idtipo_elemento" value="<%=id %>" type="text" readonly="readonly">
		<font face="arial"><br><br>Nombre <input name="nombre_tipo" id="nombre_tipo" value="<%=nombre%>"><i><b></b></i>
		
		<button type="submit" name="buscar" onclick="javascript: submitForm('TipoElementoAb/buscar')"style="color: black;  background-color: Pink; width: 115px">Buscar</button>
		<%	if(request.getAttribute("valido")==null){ %><div style="visibility:hidden;"><% }
			else{ %><div style="visibility:visible;"><%} %>
			<b><font face="arial" color="blue"><br>EL NOMBRE DEL TIPO DE ELEMENTO NO EXISTE</font></b></div>
		<font face="arial"> <br></font>Cantidad Máxima <input name="cant_max" id="cant_max" value="<%=cantidad%>" onChange="validarSiNumero(this.value);"><br><br>
		Tiempo límite <input name="lim_tiempo" id="lim_tiempo" value="<%=tiempo %>" onChange="validarSiNumero(this.value);"><br><br>
		Anticipación (dias) <input name="dias" id="dias" value="<%=dias%>" onChange="validarSiNumero(this.value);"><br><br>
		<input name="encargado" id="encargado" type="checkbox" value="encargado" <%if(encargado) {%> checked <%}%>>
		<font face="arial">Encargado<br><br></font>
		
	<button type="submit" onclick="javascript: submitForm('TipoElementoAb/insert');alert('Tipo ingresado con éxito')" style="color: black;  background-color: Pink; width: 120px">Agregar</button>
	<button type="submit" onclick="javascript: submitForm('update');alert('Los datos del tipo fueron modificados')" style="color: black;  background-color: Pink; width: 115px">Modificar</button>
	<button type="submit" onclick="javascript: submitForm('delete');alert('Los datos del tipo fueron eliminados')" style="color: black;  background-color: Pink; width: 115px">Borrar</button></font>
	
	<a href="#" title="Regresar a página anterior" onclick="history.back()"><br>Atrás</a>
	<a href="#" title="salir" onclick="window.close()">Salir</a>   
		<a href="#" title="Menu" onclick="javascript: submitForm('/Start')">Menu</a>
	
	
	</form>

</body>
</html>