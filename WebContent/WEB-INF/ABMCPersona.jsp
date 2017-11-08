<%@page import="controlers.CtrlABMPersona"%>
<%@page import="entity.Categoria"%>
<%@page import="entity.Persona"%>
<%@page import="java.util.*"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABMC Personas</title>
<script type="text/javascript">
   	function submitForm(met) {
   		document.signin.action=met;
   		//document.getElementById("myFrom").submit();
      }
</script>
</head>
<body>
<%
	Persona encontrada=null;
	String id="";
	String dni="";
	String nombre_per="";
	String apellido="";
	String usuario="";
	String contrasenia="";
//	boolean habilitado ;
	String categoria="";
	
	if(request.getAttribute("encontrada")!=null){
		encontrada = (Persona)request.getAttribute("encontrada");
		id=String.valueOf(encontrada.getIdpersona());
		dni=encontrada.getDni();
		nombre_per= encontrada.getNombre();
		apellido=encontrada.getApellido();
		usuario= encontrada.getUsuario();
		contrasenia = encontrada.getContrasenia();
	//	habilitado= encontrada.getHabilitado();
		categoria= encontrada.getCategoria().getDescripcion();
		
	}
%>
<form class="form-signin" name="signin" action="" method="POST"> <h2 class="form-signin-heading">

	<title>
	</title><font face="arial"> <b>PERSONAS<br></font></h2>
	
	<font face="arial">ID <input name="idpersona" id="idpersona" type="text" readonly="readonly" disabled="true" value="<%=id%>">
	<font face="arial"><br><br>DNI <input name="dni" id="dni" value="<%=dni%>"><i><b></b></i> <button class="btn btn-lg" name="buscar" onclick="javascript: submitForm('PersonaAb/buscar')" style="color: black;  background-color: aqua; width: 115px">Buscar</button>
	<font face="arial"><br><br>NOMBRE <input name="nombre_per" id="nombre_per" value="<%=nombre_per%>"><i><b></b></i>
	<font face="arial"><br><br>APELLIDO <input name="apellido" id="apellido" value="<%=apellido%>"><i><b></b></i>
	<font face="arial"><br><br>USUARIO <input name="usuario" id="usuario" value="<%=usuario%>"><i><b></b></i>
	<font face="arial"><br><br> CONTRASENIA <input name="contrasenia" id="contrasenia" value="<%=contrasenia%>"><i><b></b></i>
	<font face="arial"><br><br>CATEGORIA <input name="categoria" id="categoria" value="<%=categoria%>"><i><b></b></i>
	
	
	
	</select><br><br>
	
	<i><b></b></i>
	<button class="btn btn-lg"  onclick="javascript: submitForm('PersonaAb/insert')" style="color: black;  background-color: aqua; width: 115px"; type="submit">Agregar</button><i><b></b></i>
	<button class="btn btn-lg" onclick="javascript: submitForm('PersonaAb/update')" style="color: black;  background-color: aqua; width: 115px; type="submit">Modificar</button><i><b></b></i>
	<button class="btn btn-lg"  onclick="javascript: submitForm('PersonaaB/delete')" style="color: black;  background-color: aqua; width: 115px; type="submit">Borrar</button>
	</form></body>
</body>


</html>
