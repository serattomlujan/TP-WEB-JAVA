

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
      
  function validarSiNumero(numero){
    if (!/^([0-9])*$/.test(numero))
      alert("El DNI debe contener sólo números");
  }
  
   function validarNoNumero(letra){
    if (!/^([a-zA-ZáéíóúÁÉÍÓÚ ])*$/.test(letra))
       alert("El campo no puede contener caracteres inválidos");
  }
  
  function validarSiVacio(valor){
  if(valor==null)
  	alert("El DNI ingresado no está registrado");}
  	
 function validarEmail(email) {
    expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if(email=='')alert("El campo no puede estar vacío");
    if ( !expr.test(email) )
        alert("Ingrese una dirección de mail válida");
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
	String email="";
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
		email=encontrada.getEmail();
		}
		else{
			
			dni=request.getParameter("dni");
		}
		
		Persona p=(Persona)session.getAttribute("user");%>
		

<center>

<form class="form-signin" name="signin" action="" method="POST"> <h2 class="form-signin-heading" >
	<hr color="Pink">
	<font face="arial" color="Pink"> <b>P E R S O N A S</b><br></font></h2>
		<hr color="Pink"><br><br>
	
	<strong><font face="arial">ID: <input name="idpersona" id="idpersona" type="text" size="5"readonly="readonly" value="<%=id%>"></font>
	 <font face="arial">&nbsp;&nbsp;DNI: <input  required name="dni" id="dni" <%if (dni!=null){  %> value="<%=dni%>"<%} %> 
	 size="8" maxlength="8" onChange="validarSiNumero(this.value);">
	 <i><b></b></i></font> 
	
	<button class="btn btn-lg" type="submit" name="buscar" onclick="javascript: submitForm('/TP_Web3/PersonaAb/buscar')" style="color: black;  background-color: Pink; width: 115px"><strong>Buscar</strong></button><%	
 	if(request.getAttribute("valido")==null)
	{ %><div style="visibility:hidden;"><% }
	else{ %><div style="visibility:visible;"><%} %>
	<b><font face="arial" color="blue"><br>EL DNI INGRESADO NO ESTÁ REGISTRADO</font></b></div>
	<font face="arial"><br>Nombre:  <input type="text" name="nombre_per" id="nombre_per" size="15" value="<%=nombre_per%>" >
	<i><b></b></i></font>
	<font face="arial">&nbsp;&nbsp;Apellido:  <input type="text" name="apellido" id="apellido" size="15" value="<%=apellido%>" >
	<i><b></b></i></font>
	<font face="arial">&nbsp;&nbsp;Email:  <input name="email" id="email" value="<%=email%>" onChange="validarEmail(this.value)"><i><b></b></i></font>
	<font face="arial"><br><br>Usuario: <input name="usuario" id="usuario" value="<%=usuario%>"><i><b></b></i></font>
	<font face="arial">&nbsp;&nbsp;Contraseña: <input type="password" name="contrasenia" id="contrasenia" value="<%=contrasenia%>"><i><b></b></i></font>
	<font face="arial"><br><br>Categoría: 
	<%CtrlABMPersona ctrl= new CtrlABMPersona();
		ArrayList<Categoria> cats=new ArrayList<Categoria>();
		cats=ctrl.getCategorias(); %>
		<select name="categoria" required="id=" id="categoria" style="width: 195px; height: 29px">
			<%for(Categoria ca : cats){%>
			<option value="<%=ca.getId_categoria()%>"> <%=ca.getDescripcion()%></option><%;}%>
			<%if(categ.getDescripcion()==null){ %>
			 <option selected>Seleccione una categoria</option><%;}
			else {%><option  selected value="<%=categ.getId_categoria()%>"><%=categ.getDescripcion()%> 
			</option><%;}%>
			  </select>
		
	</font>
	<input type="checkbox" name="habilitado" id="habilitado" value="habilitado" 
	<%if(habilitado) {%> checked <%}%>> <font face="arial">Habilitado<br></font>
	
	<%if(request.getAttribute("nueva")==null)
	{ %><div style="visibility:hidden;"><% }
	else if(request.getAttribute("nueva")=="error"){ %><div style="visibility:visible; color: blue">
	<b><font face="arial" color="blue"><br>NO PUEDE REALIZARSE LA OPERACION</font></b></div><%}
	else if(request.getAttribute("nueva")=="ok"){ %><div style="visibility:visible; color: blue">
	<b><font face="arial" color="blue"><br>LA PERSONA FUE REGISTRADA</font></b></div><%}
	else if(request.getAttribute("nueva")=="modif"){ %><div style="visibility:visible; color: blue">
	<b><font face="arial" color="blue"><br>LOS DATOS FUERON MODIFICADOS</font></b></div><%;}
	else if(request.getAttribute("nueva")=="elim") {%><div style="visibility:visible; color: blue">
	<b><font face="arial" color="blue"><br>LA PERSONA FUE ELIMINADA</font><%;}%></b><br><br></div>
	
	
	<button class="btn btn-lg" id="insert"
	<%if(request.getAttribute("buscar")!=null) {%> onclick="javascript: submitForm('insert')"<%} else {%> disabled<%} %> style="color: black;  background-color: Pink; width: 120px"><strong>Agregar</strong></button>
	<button name="update" id="update" onclick="javascript: submitForm('update');" style="color: black;  background-color: Pink; width: 115px" type="submit"><strong>Modificar</strong></button>
	<button name="delete" id="delete" onclick="javascript: submitForm('delete');" style="color: black;  background-color: Pink; width: 115px" type="submit"><strong>Borrar</strong></button>
	
		<br>

	<a href="#" title="Regresar a página anterior" onclick="history.back()"><h6 align="right"><font face="arial">Atrás</h6></a>
	<a href="#" title="salir" onclick="window.close()"> <h6 align="right">Salir</h6></a><br><font>
	<hr color="pink">
	<center><font face="verdana" size="1" color="pink">
			   <a href='/TP_Web3/ReservaAb'>RESERVAR ELEMENTO</a>
			   <a href="/TP_Web3/ReservasPendientes"> RESERVAS PENDIENTES</a>
			   <a href="/TP_Web3/PersonaAb">PERSONAS</a>
			   <a href="/TP_Web3/ElementoAb">ELEMENTOS</a>
			   <a href="/TP_Web3/TipoElementoAb">TIPOS de ELEMENTOS</a>
			   <a href="/TP_Web3/ListadoElementos">LISTADO de ELEMENTOS</a>
			   <a href="/TP_Web3/ListadoTipoElementos">LISTADO de TIPOS de ELEMENTOS</a>
			   <a href="/TP_Web3/ListadodePersona">LISTADO de PERSONAS</a>
			   <a href="/TP_Web3/Login.html">CERRAR SESIÓN</a><hr color="pink">
			   <hr color="purple">
		
	
 
</form></center>

</body>

</html>