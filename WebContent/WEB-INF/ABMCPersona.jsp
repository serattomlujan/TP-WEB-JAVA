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
	boolean habilitado=false;
	Categoria categ= new Categoria();
	String desCat="";
	String idCat="";
	
	
	if(request.getAttribute("encontrada")!=null){
		encontrada = (Persona)request.getAttribute("encontrada");
		id=String.valueOf(encontrada.getIdpersona());
		dni=encontrada.getDni();
		nombre_per= encontrada.getNombre();
		apellido=encontrada.getApellido();
		usuario= encontrada.getUsuario();
		contrasenia = encontrada.getContrasenia();
		categ= encontrada.getCategoria();
		habilitado= encontrada.getHabilitado();
		}
		
		else %> <alert("El DNI ingresado no está registrado")><%;
	
%>
<form class="form-signin" name="signin" action="" method="POST"> <h2 class="form-signin-heading">

	<font face="arial"> <b>PERSONAS</b><br></font></h2>
	
	<font face="arial">ID <input name="idpersona" id="idpersona" type="text" readonly="readonly" disabled="true" value="<%=id%>"></font>
	<font face="arial"><br><br>DNI <input name="dni" id="dni" value="<%=dni%>"><i><b></b></i></font> 
	<button class="btn btn-lg" name="buscar" onclick="javascript: submitForm('PersonaAb/buscar')" style="color: black;  background-color: aqua; width: 115px">Buscar</button>
	<font face="arial"><br><br>Nombre <input name="nombre_per" id="nombre_per" value="<%=nombre_per%>"><i><b></b></i></font>
	<font face="arial"><br><br>Apellido <input name="apellido" id="apellido" value="<%=apellido%>"><i><b></b></i></font>
	<font face="arial"><br><br>Usuario <input name="usuario" id="usuario" value="<%=usuario%>"><i><b></b></i></font>
	<font face="arial"><br><br>Contraseña <input name="contrasenia" id="contrasenia" value="<%=contrasenia%>"><i><b></b></i></font>
	<font face="arial"><br><br>Categoría 
	<%CtrlABMPersona ctrl= new CtrlABMPersona();
		ArrayList<Categoria> cats=new ArrayList<Categoria>();
		cats=ctrl.getCategorias(); %>
		<select name="categoria"  id="categoria" style="width: 154px; height: 29px">
			<%for(Categoria ca : cats){%>
			<option value="<%=ca.getId_categoria()%>"> <%=ca.getDescripcion()%></option><%;}%>
			<%if(categ == null){ %>
			 <option selected value="defecto">Seleccione una categoria</option><%;}
			else {%><option selected value="<%=categ.getId_categoria()%>"><%=categ.getDescripcion()%> 
			</option><%;}%>
			  </select>
		<br><br>
	</font>
	<input type="checkbox" name="habilitado" id="habilitado" value="habilitado" 
	<%if(habilitado) {%> checked <%}%>> <font face="arial">Habilitado<br><br></font>
	
	
	<button class="btn btn-lg" onclick="javascript: submitForm('PersonaAb/insert')" style="color: black;  background-color: aqua; width: 115px"; type="submit">Agregar</button><i><b></b></i>
	<button class="btn btn-lg" onclick="javascript: submitForm('PersonaAb/update')" style="color: black;  background-color: aqua; width: 115px; type="submit">Modificar</button><i><b></b></i>
	<button class="btn btn-lg" onclick="javascript: submitForm('PersonaAb/delete')" style="color: black;  background-color: aqua; width: 115px; type="submit">Borrar</button>
</form></body>

</html>
