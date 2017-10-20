
package entity;
import java.sql.Date;
import java.io.Serializable;


import java.sql.Time;

public class Reserva  implements Serializable{
	private int id_reserva;
	private Date fecha;
	private Time hora;
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
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
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
	
	

	@Override
	public boolean equals(Object o){
	return (o instanceof Reserva && ((Reserva)o).getId_reserva()==this.getId_reserva());
	}

	@Override
	public int hashCode(){
	return ((Integer)this.getId_reserva()).hashCode();
	}
		

}
