
  <html style="height: 303px; "> 
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Persona"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title>MENU</title>
<center>
<h1> <b><i><big><FONT FACE="CALIBRI" COLOR="white">• • • B i e n v e n i d o • • •  </FONT></big></i></b></h1>
<style>.drop_menu {
	background:#C0C0C0;
	padding:0;
	margin:0;
	list-style-type:none;
	height:30px;
}
.drop_menu li { float:; }
.drop_menu li a:hover {background-color:aqua;}
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
<body bgcolor="black" style="height: 270px; ">

<div class="drop">
 <ul class="drop_menu">

			  
<li><a href="Reservar.jsp">RESERVAR ELEMENTO</a></li>
  <li><a href="ReservasPendientes.jsp"> RESERVAS PENDIENTES</a></li>
		   	
 <li><a href="ABMCPersona.jsp">PERSONAS</a></li>
			   <li><a href="ABMCElemento.jsp">ELEMENTOS</a></li>
			   <li><a href="ABMCTipoElemento.jsp">TIPO ELEMENTOS</a>
			   <li><a href="ListadoElementos.jsp">LISTADO ELEMENTOS</a></li>



			   
			   <li><a href="ListadoTipoElementos.jsp">LISTADO TIPOS ELEMENTOS</a></li>

			  
			   <li><a href="ListadoPersonas.jsp">LISTADO  PERSONAS</a></li>
	
 
		   

		 <li><a href="">CERRAR SESION</a></li>
			   <li><a href="">SALIR</a></li>
	
	
</ul>
	
</div>


<h1> <b><i><big><FONT FACE="CALIBRI" COLOR="white">Gracias por su visita </FONT></big></i></b></h1>


</b></i><i><b></b></i><i><b></b></i><i><b>
</b></i></form><i><b>

</b></i></center>
</body>
</html> 