<%@page import="java.util.ArrayList"%>
<%@page import="servlet.PersonaAb"%>
<%@page import="servlet.ElementoAb"%>
<%@page import="servlet.ListadoElementos"%>
<%@page import="servlet.ListadoTipoElementos"%>
<%@page import="servlet.ReservaAb"%>
<%@page import="servlet.ReservasPendientes"%>
<%@page import="servlet.TipoElementoAb"%>
<%@page import="servlet.ListadodePersona"%>



<%@page import="entity.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Menú Principal</title>
<style>.drop_menu{
	background:#FFFFFF;
	padding:0;
	margin:0;
	list-style-type:none;
	height:30px;
	text-align: center;
	
}
.drop_menu li { float:; }
.drop_menu li a:hover {background-color:#FFCCCC;}
.drop_menu li a {
	padding:9px 20px;
	display:block;
	color:#FF66CC;
	text-decoration:none;
	font:12px verdana, sans-serif;
}

/* Submenu */
.drop_menu ul {
	position:absolute;
	left:-9999px;
	top:-9999px;
	list-style-type:none;
}
.drop_menu li:hover { position:relative; background:#FFF5EE; }
.drop_menu li:hover ul {
	left:0px;
	top:30px;
	background:#FFCCCC;
	padding:0px;
}

.drop_menu li:hover ul li a {
	padding:5px;
	display:block;
	width:168px;
	text-indent:15px;
	background-color:#FFCCCC;
}
.drop_menu li:hover ul li a:hover { background:#FFCCCC }</style>


</head> 

<body bgcolor="white"><center>

<% Persona usuarioLog=((Persona)session.getAttribute("user")); %>
	
	<h1><font face="verdana" color="pink"> SISTEMA DE GESTION DE RESERVAS</h1><h2><marquee><font face="verdana" color="black">Bienvenido <%=((Persona)session.getAttribute("user")).getNombre()%></marquee></font></h2>
	</center>
	
	 <center>
<div class="drop">


 <ul class="drop_menu">

		  
			   <li><a href='ReservaAb'>RESERVAR ELEMENTO</a></li>
			   <li><a href="ReservasPendientes"> RESERVAS PENDIENTES</a></li>
			   <li><a href="PersonaAb">PERSONAS</a></li>
			   <li><a href="ElementoAb">ELEMENTOS</a></li>
			   <li><a href="TipoElementoAb">TIPO ELEMENTOS</a>
			   <li><a href="ListadoElementos">LISTADO ELEMENTOS</a></li>
			   <li><a href="ListadoTipoElementos">LISTADO TIPOS ELEMENTOS</a></li>
			   <li><a href="ListadodePersona">LISTADO PERSONAS</a></li> 
	
 
		  <li><a href="Login.html">CERRAR SESION</a></li>
		  <li><a href="" onclick="window.close()">SALIR</a></li>

	
</ul>
	
</div>

<!--  <div>
<h1> <b><i><big><FONT FACE="CALIBRI" COLOR=pink"> Gracias por su visita </FONT></big></i></b></h1>
</div>
-->
</body>
</html> 