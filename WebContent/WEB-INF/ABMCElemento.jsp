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
		
		else %> <%;
	
%>



<form class="form-signin" name="signin" action="" method="POST">
		
		<font face="arial"><h2><b>ELEMENTOS</h2> <br></font>
		<font face="arial">ID <input name="idelemento" id="idelemento"type="text" readonly="readonly" value="<%=id %>"><br><br>
		<font face="arial">Nombre <input name="nombre" required id="nombre" value="<%=nombre%>"><i><b></b></i>
		<button type="submit"  onclick="javascript: submitForm('ElementoAb/buscar')" style="color: black;  background-color: Pink; width: 115px">Buscar</button>
	<%	if(request.getAttribute("valido")==null)
	{ %><div style="visibility:hidden;"><% }
	else{ %><div style="visibility:visible;"><%} %>
	<b><font face="arial" color="blue"><br>EL NOMBRE DEL ELEMENTO NO EXISTE</font></b></div>
	
		<font face="arial"><br><br>Tipo Elemento
		<%CtrlABMElemento ctrl= new CtrlABMElemento();
		ArrayList<Tipo_Elemento> tipos=new ArrayList<Tipo_Elemento>();
		tipos=ctrl.getTipos(); %>
		<select name="tipo" id="tipo"style="width: 154px; height: 29px">
		
		<%for(Tipo_Elemento t : tipos){%>
		<option value="<%=t.getIdtipo_elemento()%>"><%=t.getNombre_tipo()%></option><%} %>
		<%if(ti == null){ %>
			 <option selected value="defecto">Seleccione un tipo</option><%;}
			else {%><option selected value="<%=ti.getIdtipo_elemento()%>"><%=ti.getNombre_tipo()%> 
			</option><%;}%>
	
		
		</select><br><br><br>
	<i><b></b></i>
	<button type="submit" onclick="javascript: submitForm('ElementoAb/insert');alert('Elemento ingresado con éxito')" style="color: black;  background-color: Pink; width: 115px">Agregar</button><i><b></b></i>
	<button type="submit" onclick="javascript: submitForm('update');alert('Los datos del elemento fueron modificados')" style="color: black;  background-color: Pink; width: 115px">Modificar</button><i><b></b></i>
	<button type="submit" onclick="javascript: submitForm('delete');alert('Los datos del elemento fueron eliminados')" style="color: black;  background-color:Pink; width: 115px">Borrar</button>
	<a href="#" title="Regresar a página anterior" onclick="history.back()"><br>Atrás</a>
	<a href="#" title="salir" onclick="window.close()">   Salir</a>
		<a href="#" title="Menu" onclick="javascript: submitForm('/Start')">Menu</a>
	


</form>
	</body>

</html>