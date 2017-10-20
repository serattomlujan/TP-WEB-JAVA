package entity;
import java.io.Serializable;

public class Elemento implements Serializable{
	private int idelemento;
	private String nombre;
	private Tipo_Elemento tipo;
	
	
	public int getIdelemento() {
		return idelemento;
	}
	public void setIdelemento(int idelemento) {
		this.idelemento = idelemento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Tipo_Elemento getTipo_Elem(){
		return tipo;
	}
	
	public void setTipo_Elem(Tipo_Elemento te){
		this.tipo=te;
	}
	
	//public Elemento (String nombre){
		 //this.setNombre(nombre);
		
	//}
	public Elemento(){}
	@Override
	 public String toString(){
	 return this.getNombre();
	 }
	 
	 @Override
	 public boolean equals(Object o){
	 return (o instanceof Elemento && ((Elemento)o).getIdelemento()==this.getIdelemento());
	 }
	 
	 @Override
	 public int hashCode(){
	 return ((Integer)this.getIdelemento()).hashCode();
	 }
}
