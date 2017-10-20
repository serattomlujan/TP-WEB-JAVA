package controlers;

import data.DataLogin;
import data.DataPersona;
import entity.Persona;
//import UI.MainWindow;

public class CtrlLogin {
	
	 private DataPersona dataPer;
	 private DataLogin dataLog;
	 
	 
	 public CtrlLogin(){}

	
	public Persona getUsuario(Persona p) throws Exception{
		return dataLog.getUsuario(p);
		}	
	
	public Persona getUsuario(String u, String pas) throws Exception{
		Persona p=new Persona();
		p.setUsuario(u);
		p.setContrasenia(pas);
		return getUsuario(p);
		}
	
	public Persona enviarUsuario(Persona u)
		{return u;}
	
	/*public void habilitarMenu() throws Exception{
		
		new MainWindow().habilitarMenu();
		;}*/

}