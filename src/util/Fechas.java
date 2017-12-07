package util;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Fechas {
	
	public  int diferenciaEnDias2(Date fechaMayor, Date fechaMenor) {
		 long diferenciaEn_ms = fechaMayor.getTime() - fechaMenor.getTime();
		 long dias = diferenciaEn_ms / (1000 * 60 * 60 * 24);
		 return (int) dias;
		 }

	public Date ParseFecha(String fecha) throws java.text.ParseException
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
        	//System.out.println(fecha);
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            //System.out.println(ex);
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
	
	public java.sql.Date ParseFecha2(String f) throws ParseException, java.text.ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         java.util.Date parsed = format.parse(f);
         //System.out.println(parsed);
         java.sql.Date fecha = new java.sql.Date(parsed.getTime());
         //System.out.println(parsed);
		return fecha;
	}
	
	
	
	

}
