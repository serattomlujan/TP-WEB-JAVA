
package entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;


public class Reserva  implements Serializable{
	private int id_reserva;
	private Date fecha;
	private Time hora_ini;
	private Time hora_fin;
	private String estado;
	private String detalle;
	private Elemento elemento;
	private Persona persona;
	//private Time horaT;
	
	
	public int getId_reserva() {
		return id_reserva;
	}
	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Time getHora_ini() {
		return hora_ini;
	}
	public void setHora_ini(Time hora) {
		this.hora_ini = hora;
	}
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	public Reserva(){}
	
	public Elemento getElemento() {
		return elemento;
	}
	
	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public Time getHora_fin() {
		return hora_fin;
	}
	public void setHora_fin(Time hora_fin) {
		this.hora_fin = hora_fin;
	}
		
	

	@Override
	public boolean equals(Object o){
	return (o instanceof Reserva && ((Reserva)o).getId_reserva()==this.getId_reserva());
	}

	@Override
	public int hashCode(){
	return ((Integer)this.getId_reserva()).hashCode();
	}
	

}
