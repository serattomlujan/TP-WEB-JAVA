<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABMC Tipos de Elementos</title>
</head>
<body>


<form class="form-signin" name="signin" action="TipoElementoAb" method="POST">
		<font face="arial"> <b>TIPOS  DE ELEMENTOS<br><br></font>
	<font face="arial">ID <input name="idtipo_elemento" type="text" disabled="true">
		<font face="arial"><br><br>Nombre <input name="nombre_tipo"><i><b></b></i>
		<button type="submit" style="color: black;  background-color: aqua; width: 115px">Buscar</button>
		<font face="arial"><br><br></font>Cantidad Máxima <input name="cant_max"><br><br>
		Tiempo límite <input name="lim_tiempo"><br><br>Anticipación (dias) <input name="dias"><br><br>
		<input name="encargado" type="checkbox">Encargado
	<br><br><br><i><b></b></i><button type="submit" style="color: black;  background-color: aqua; width: 120px">Agregar</button><i><b></b></i><button type="submit" style="color: black;  background-color: aqua; width: 115px">Modificar</button><i><b></b></i><button type="submit" style="color: black;  background-color: aqua; width: 115px">Borrar</button>
	</form>

</body>
</html>