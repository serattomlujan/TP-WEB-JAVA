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
</head>
<body>
<form class="form-signin" name="signin" action="PersonaAb" method="POST"> <h2 class="form-signin-heading">

	<title>
	</title><font face="arial"> <b>PERSONAS<br></font></h2>
	
	<font face="arial">ID <input name="idpersona" id="idpersona" type="text" readonly="readonly" disabled="true">
	<font face="arial"><br><br>DNI <input name="dni" id="dni"><i><b></b></i>
	
	<button class="btn btn-lg" name="buscar" onclick="javascript: submitForm('PersonaAb/consulta')" style="color: black;  background-color: aqua; width: 115px">Buscar</button>
	
	
	<font face="arial"><br><br>Nombre <input name="nombre_per" id="nombre_per" >
	<br><br></font>Apellido <input name="apellido"id="apellido"><br><br>
	Usuario <input name="usuario" id="usuario"><br><br>Contraseña <input name="contrasenia" id="contrasenia"><br><br>
	Categoría 
	<%CtrlABMPersona ctrl= new CtrlABMPersona();
			ArrayList<Categoria> cats=new ArrayList<Categoria>();
			cats=ctrl.getCategorias();%>
			
		<select name="categoria" style="width: 147px; height: 27px; " >
		<option>Seleccione una categoría </option>
		<%for(Categoria c : cats){%>
		<option value="<%=c.getId_categoria()%>"><%=c.getDescripcion()%></option><%}%>
	</select><br><br>
	<input name="habilitado" id="habilitado" type="checkbox">Habilitado<br><br>
	<i><b></b></i><button class="btn btn-lg"  onclick="javascript: submitForm('PersonaAb/insert')" style="color: black;  background-color: aqua; width: 115px"; type="submit">Agregar</button><i><b></b></i>
	<button class="btn btn-lg" onclick="javascript: submitForm('PersonaAb/update')" style="color: black;  background-color: aqua; width: 115px; type="submit">Modificar</button><i><b></b></i>
	<button class="btn btn-lg"  onclick="javascript: submitForm('PersonaaB/delete')" style="color: black;  background-color: aqua; width: 115px; type="submit">Borrar</button>
	</form></body>
</body>


</html>
