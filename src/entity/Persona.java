package entity;
import java.io.Serializable;


public class Persona implements Serializable {
	private int idpersona;
	private String dni;
	private String nombre_per;
	private String apellido;
	private String usuario;
	private String contrasenia;
	private boolean habilitado;
	private Categoria categoria;
	private String email;
	
	
	public Categoria getCategoria(){
		 return categoria;
		 }

	public void setCategoria(Categoria categoria){
		 this.categoria=categoria;
		 }
	public int getIdpersona() {
		return idpersona;
	}
	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre_per;
	}
	public void setNombre(String nombre) {
		this.nombre_per = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String pas) {
		this.contrasenia = pas;
	}
	public boolean getHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	public Persona (String dni, String nombre, String apellido, boolean habilitado){
		 this.setDni(dni);
		 this.setNombre(nombre);
		 this.setApellido(apellido);
		 this.setHabilitado(habilitado);
	
		 }
	public Persona(){}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	 
	// @Override
	// public boolean equals(Object p){
	 //return (p instanceof Persona) &&
	 //(((Persona)p).getDni().equals(this.getDni()));
	 //}
	 }


