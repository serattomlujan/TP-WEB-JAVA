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
		else{
			//dni=request.getParameter("dni");
		}%>
		



<form class="form-signin" name="signin" action="" method="POST"> <h2 class="form-signin-heading" >

	<font face="arial"> <b>PERSONAS</b><br></font></h2>
	
	<font face="arial">ID <input name="idpersona" id="idpersona" type="text" readonly="readonly"  value="<%=id%>"></font>
	 <font face="arial"><br><br>DNI <input  required name="dni" id="dni" value="<%=dni%>" size="8" maxlength="8" onChange="validarSiNumero(this.value);">
	 <i><b></b></i></font> 
	
	<button class="btn btn-lg" type="submit" name="buscar" onclick="javascript: submitForm('PersonaAb/buscar')" style="color: black;  background-color: Pink; width: 115px">Buscar</button>
	 
	
	<font face="arial"><br><br>Nombre <input type="text" name="nombre_per" id="nombre_per" size="15" value="<%=nombre_per%>" 
	>
	<i><b></b></i></font>
	<font face="arial"><br><br>Apellido <input type="text" name="apellido" id="apellido" size="15" value="<%=apellido%>" >
	<i><b></b></i></font>
	<font face="arial"><br><br>Usuario <input name="usuario" id="usuario" value="<%=usuario%>"><i><b></b></i></font>
	<font face="arial"><br><br>Contraseña <input type="password" name="contrasenia" id="contrasenia" value="<%=contrasenia%>"><i><b></b></i></font>
	<font face="arial"><br><br>Categoría 
	<%CtrlABMPersona ctrl= new CtrlABMPersona();
		ArrayList<Categoria> cats=new ArrayList<Categoria>();
		cats=ctrl.getCategorias(); %>
		<select name="categoria" required="id=" id="categoria" style="width: 154px; height: 29px">
			<%for(Categoria ca : cats){%>
			<option value="<%=ca.getId_categoria()%>"> <%=ca.getDescripcion()%></option><%;}%>
			<%if(categ.getDescripcion()== ""){ %>
			 <option selected placeholder="Seleccione una categoria" ></option><%;}
			else {%><option  selected value="<%=categ.getId_categoria()%>"><%=categ.getDescripcion()%> 
			</option><%;}%>
			  </select>
		<br><br>
	</font>
	<input type="checkbox" name="habilitado" id="habilitado" value="habilitado" 
	<%if(habilitado) {%> checked <%}%>> <font face="arial">Habilitado<br><br></font>
	
	
	<button class="btn btn-lg" id="insert" onclick="javascript: submitForm('PersonaAb/insert')" style="color: black;  background-color: Pink; width: 115px" type="submit">Agregar</button>
	<button name="update" id="update" onclick="javascript: submitForm('update')" style="color: black;  background-color: Pink; width: 115px" type="submit">Modificar</button>
	<button name="delete" id="delete" onclick="javascript: submitForm('delete')" style="color: black;  background-color: Pink; width: 115px" type="submit">Borrar</button>
	
	<a href="#" title="Regresar a página anterior" onclick="history.back()"><br>Volver</a>
	<a href="#" title="salir" onclick="window.close()">Salir</a>
	
 
</form></body>

</html>
