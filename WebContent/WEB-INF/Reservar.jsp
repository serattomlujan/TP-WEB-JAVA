<%@ page import="controlers.CtrlABMTipoElemento" %>
<%@page import="entity.Tipo_Elemento"%>
<%@page import="entity.Elemento"%>
<%@page import="java.util.*"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservar Elemento</title>
</head>
<body>
<%
	ArrayList<Elemento> elemDisp= new ArrayList<Elemento>();
	String id="";
	String descripcion="";
	Elemento el=new Elemento();
	
		
	if(request.getAttribute("disponibles")!=null){
		elemDisp = (ArrayList<Elemento>)request.getAttribute("disponibles");}
		for(int i=0; i<elemDisp.size();i++) el.getIdelemento();
		
%>


<form class="form-signin" name="signin" action="ReservaAb" method="POST" ><h2 class="form-signin-heading">
	<font face="arial"> <b>RESERVAS </font></h2>
	<font face="arial">ID Reserva <input name="id_reserva" disabled="true" style="width: 89px; "><br><br>
	<font face="arial"> <i><b></b></i></font>
	<font face="arial">Tipo Elemento 
	
	<%CtrlABMTipoElemento ctrl= new CtrlABMTipoElemento();
		ArrayList<Tipo_Elemento> tipos=new ArrayList<Tipo_Elemento>();
		tipos=ctrl.getAll();%>
		<select name="tipo" style="width: 154px; height: 29px" required>
		<option>Seleccione un tipo </option>
		<%for(Tipo_Elemento t : tipos){%>
			<option value="<%=t.getIdtipo_elemento()%>"><%=t.getNombre_tipo()%></option><%;}%>
	
	</select><br><br></font>
	
	Fecha(aaaammdd) <input type="text" name="fecha" id="fecha" required size="10" maxlength="10"><br>
	<br>Hora(hhmm)  <input name="hora" id="hora" size="4"  maxlength="4" required> 
	  <button onclick="javascript: submitForm('ReservaAb/buscar')" style="color: black;  background-color: aqua; width: 115px">Buscar</button><br><br>
	Elemento <select name="elemento" style="width: 147px; height: 27px; ">
		<%//if (elemDisp.isEmpty()) %> 
		<%for(Elemento e: elemDisp){ %>
			<option value="<%=e.getIdelemento()%>"><%=e.getNombre()%></option><%;}%>
			</select><br>
	<br> Detalle <textarea name="detalle"style="width: 212px; height: 67px; "></textarea><br><br>
	<i><b></b></i><button type="submit" style="color: black;  background-color: aqua; width: 115px">Agregar</button><i><b></b></i><i><b></b></i><button type="submit" style="color: black;  background-color: aqua; width: 115px">Cancelar</button>

	<a href="#" title="Regresar a página anterior" onclick="history.back()"><br>Volver </a>
	<a href="#" title="salir" onclick="window.close()">Salir</a>
	

</form>
<script>
function formateaFecha(valor)
{
	var log=valor.length;
	var sw="S";
	for (x=0; x<log; x++)
	{
	   v1=valor.substr(x,1);
	   v2 = parseInt(v1);
		//Compruebo si es un valor numérico
		if (isNaN(v2))
		{
		sw= "N";
		}
	}
	
	if (sw=="S")
	{return true;}
	else
	{return false;}
	}

	var primerslap=false;
	var segundoslap=false;
function formateafecha(fecha)
{
	var long = fecha.length;
	var dia;
	var mes;
	var ano;

	   ano=fecha.substr(0,4);
	   if ((long>=4) && (primerslap==false))
	   {
		   
		   ano=fecha.substr(0,4);
		   //alert("akii" + ano);
		   if ((IsNumeric(ano)== false) || ((ano==0) || (ano<1900) || (ano>2100)))
		   {
		       fecha=""; primerslap=false;
		   }
		   else
		   {
		      fecha=fecha.substr(0,4)+"/"+fecha.substr(5,9); primerslap=true;
		   }
	    }
		else
		{
		    ano=fecha.substr(0,4);
		    if (IsNumeric(ano)==false)
		    {
		        fecha="";
		     }
		     if ((long<=4) && (primerslap=true))
		     {
		        fecha=fecha.substr(0,4); primerslap=false;
		     }
	   }// fin if ((long>=4) && (primerslap==false))
	    
	   
	   if ((long>=7) && (segundoslap==false))
	   {
		   mes=fecha.substr(5,2);
		   if ((IsNumeric(mes)==true) &&(mes<=12) && (mes!="00"))
		   {
		       fecha=fecha.substr(0,7)+"/"+fecha.substr(8,2); segundoslap=true;
		   }
		   else
		   {
		      fecha=fecha.substr(0,5);; segundoslap=false;
		   }
	    }
	   else
		{
		     if ((long<=7) && (segundoslap=true))
		    {
		       fecha=fecha.substr(0,6); segundoslap=false;
		    }
	   }//if ((long>=7) && (segundoslap==false))
	   
	   
	   if (long>=9)
       {
           dia=fecha.substr(8,5);
           if (IsNumeric(dia)==false)
           {
               fecha=fecha.substr(0,8);
           }
           else
           {
               if (long==10)
               {
				   if ((dia >31) || (dia=="00"))
                  {
                      fecha=fecha.substr(0,8);
                   }
                }
           }
     } //if (long>=7) 
	 
	 
	 if (long>=10)
     {
         fecha=fecha.substr(0,10);
         dia=fecha.substr(8,2);
         mes=fecha.substr(5,2);
         ano=fecha.substr(0,4);
        // Año no biciesto y es febrero y el dia es mayor a 28
		//alert(mes);
        if ( (ano%4 != 0) && (mes ==02) && (dia > 28) ) // es año biciesto
        {
		   fecha=fecha.substr(0,4)+"/";
         }
      } 
	   

    return (fecha);
}



</script>

</body>
</html>