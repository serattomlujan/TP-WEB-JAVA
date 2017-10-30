package util;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


public class Fechas {
	
	public  int diferenciaEnDias2(Date fechaMayor, Date fechaMenor) {
		 long diferenciaEn_ms = fechaMayor.getTime()- fechaMenor.getTime();
		 long dias = diferenciaEn_ms / (1000 * 60 * 60 * 24);
		 return (int) dias;
		 }

	public Date ParseFecha(String fecha) throws java.text.ParseException
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }

	public Time ParseHora(String hora) throws java.text.ParseException
    {
		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
		java.util.Date d1=(java.util.Date)format.parse(hora);
		java.sql.Time horaDate = new java.sql.Time(d1.getTime());
		
        return horaDate;
    }
	
	
	

}
