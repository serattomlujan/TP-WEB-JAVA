<%@page import="java.util.ArrayList"%>
<%@page import="entity.Persona"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>.drop_menu {
	background:#C0C0C0;
	padding:0;
	margin:0;
	list-style-type:none;
	height:30px;
	text-align: center;
}
.drop_menu li { float:; }
.drop_menu li a:hover {background-color:#FF66CC;}
.drop_menu li a {
	padding:9px 20px;
	display:block;
	color:#fff;
	text-decoration:none;
	font:12px arial, verdana, sans-serif;
}

/* Submenu */
.drop_menu ul {
	position:absolute;
	left:-9999px;
	top:-9999px;
	list-style-type:none;
}
.drop_menu li:hover { position:relative; background:#5FD367; }
.drop_menu li:hover ul {
	left:0px;
	top:30px;
	background:#5FD367;
	padding:0px;
}

.drop_menu li:hover ul li a {
	padding:5px;
	display:block;
	width:168px;
	text-indent:15px;
	background-color:#5FD367;
}
.drop_menu li:hover ul li a:hover { background:#005555; }</style>

</head> 

<body bgcolor="Pink" style="height: 291px; ">
	
	<h1> Bienvenido <%=((Persona)session.getAttribute("user")).getNombre()%></h1>
	 <table>
<div class="drop">
 <ul class="drop_menu">

			  
<li><a href="WEB-INF/Reservar.jsp">RESERVAR ELEMENTO</a></li>
  <li><a href="WEB-INF/ReservasPendientes.jsp"> RESERVAS PENDIENTES</a></li>
		   	
 <li><a href="WEB-INF/ABMCPersona.jsp">PERSONAS</a></li>
			   <li><a href="WEB-INF/ABMCElemento.jsp">ELEMENTOS</a></li>
			   <li><a href="WEB-INF/ABMCTipoElemento.jsp">TIPO ELEMENTOS</a>
			  <li><a href="WEB-INF/ListadoElementos.jsp">LISTADO ELEMENTOS</a></li>



			   
			   <li><a href="ListadoTipoElementos.jsp">LISTADO TIPOS ELEMENTOS</a></li>

			  
			   <li><a href="ListadoPersonas.jsp">LISTADO  PERSONAS</a></li> 
	
 
		   

		 <li><a href="">CERRAR SESION</a></li>
			   <li><a href="">SALIR</a></li>
	
	
</ul>
	
</div>

<!--  <div>
<h1> <b><i><big><FONT FACE="CALIBRI" COLOR="white"> Gracias por su visita </FONT></big></i></b></h1>
</div>
-->
</body>
</html> 