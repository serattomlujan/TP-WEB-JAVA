

package entity;
import java.io.Serializable;



public class Tipo_Elemento  implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int idtipo_elemento;
private String nombre_tipo;
private int cant_max;
private int lim_tiempo;
private int dias;
private boolean encargado;


public int getIdtipo_elemento() {
	return idtipo_elemento;
}
public void setIdtipo_elemento(int idtipo_elemento) {
	this.idtipo_elemento = idtipo_elemento;
}
public String getNombre_tipo() {
	return nombre_tipo;
}
public void setNombre_tipo(String nombre_tipo) {
	this.nombre_tipo = nombre_tipo;
}
public int getCant_max() {
	return cant_max;
}
public void setCant_max(int cant_max) {
	this.cant_max = cant_max;
}
public int getLim_tiempo() {
	return lim_tiempo;
}
public void setLim_tiempo(int lim_tiempo) {
	this.lim_tiempo = lim_tiempo;
}
public int getDias_anticip() {
	return dias;
}
public void setDias_anticip(int dias_anticip) {
	this.dias = dias_anticip;
}
public boolean getEncargado() {
	return encargado;
}
public void setEncargado(boolean encargado) {
	this.encargado = encargado;
}
	
public Tipo_Elemento (String nombre_tipo, int cant, int tiempo, int dias, boolean encargado){
	 this.setNombre_tipo(nombre_tipo);
	 this.setCant_max(cant);
	 this.setLim_tiempo(tiempo);
	 this.setDias_anticip(dias);
	 this.setEncargado(encargado);

	 }

public Tipo_Elemento(){};

@Override
public String toString(){
return this.getNombre_tipo();
}

@Override
public boolean equals(Object o){
return (o instanceof Tipo_Elemento && ((Tipo_Elemento)o).getIdtipo_elemento()==this.getIdtipo_elemento());
}

@Override
public int hashCode(){
return ((Integer)this.getIdtipo_elemento()).hashCode();
}
	
	
}
