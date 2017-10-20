package util;

import java.util.*;


public class Fechas {
	
	public  int diferenciaEnDias2(Date fechaMayor, Date fechaMenor) {
		 long diferenciaEn_ms = fechaMayor.getTime()- fechaMenor.getTime();
		 long dias = diferenciaEn_ms / (1000 * 60 * 60 * 24);
		 return (int) dias;
		 }

}
