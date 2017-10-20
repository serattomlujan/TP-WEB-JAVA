package controlers;
import java.util.ArrayList;

import data.DataCategoria;
import data.DataPersona;
import entity.Categoria;
import entity.Persona;

public class CtrlABMPersona {
    private DataPersona dataPer;
	private DataCategoria dataCat;
	private ArrayList<Persona> pers;
	
	
	public CtrlABMPersona(){
	dataPer= new DataPersona();
	pers= new ArrayList<Persona>();
	dataCat=new DataCategoria();
	//pers.add(new Persona("343434","Hugo","Lopez",true));
	//pers.add(new Persona("353535","Ana","Martinez",true))
	}
	
	
	public void add(Persona p) throws Exception{
		dataPer.add(p);}
	
	
   public void delete(Persona p) throws Exception{
	   dataPer.remove(p);}
   
		
	public void update(Persona p) throws Exception{
		//dataPer.remove(p);
		//dataPer.add(p);
		dataPer.modificar(p);
	}
		
		
		
	public Persona getByDni(Persona p) throws Exception{
	return this.dataPer.getByDni(p);
	}	
		
	
	public Persona getByDni(String dni) throws Exception{
	Persona p=new Persona();
	p.setDni(dni);
	return getByDni(p);
	}
	
	
	public Persona getByNombreApellido(Persona p){
		for(int i=0; i<this.pers.size(); i++){
		if(pers.get(i).getNombre().equalsIgnoreCase(p.getNombre())
		 && pers.get(i).getApellido().equalsIgnoreCase(p.getApellido())){return pers.get(i);}}
		return null; 
		}

	
	
	public ArrayList<Persona>getAll() throws Exception{
		return dataPer.getAll();}
	
	public ArrayList<Categoria> getCategorias() throws Exception{
		return dataCat.getAll();
	
		}
	public Persona login(Persona per) throws Exception{
		return dataPer.getLogedUser(per);
	}
		
		
	}