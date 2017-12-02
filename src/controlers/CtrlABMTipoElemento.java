package controlers;
import java.util.ArrayList;

import data.DataTipoElemento;
import entity.Tipo_Elemento;

public class CtrlABMTipoElemento {
		private DataTipoElemento dataTiEl;
		
		
		public CtrlABMTipoElemento(){
		dataTiEl= new DataTipoElemento();
		}
		
	
	public void add(Tipo_Elemento t) throws Exception{
		dataTiEl.add(t);}
	
	
   public void delete(Tipo_Elemento t) throws Exception{
	   dataTiEl.remove(t);}
   
		
	public void update(Tipo_Elemento t) throws Exception{
		dataTiEl.update(t);}
		
	
	public Tipo_Elemento getByNomTipo(Tipo_Elemento t) throws Exception{
		return this.dataTiEl.getByNomTipo(t);
		}	
	
	public Tipo_Elemento getByNomTipo(String nom) throws Exception{
	Tipo_Elemento t=new Tipo_Elemento();
	t.setNombre_tipo(nom);
	return getByNomTipo(t);
	}
	
	public ArrayList<Tipo_Elemento>getAll() throws Exception{
		return dataTiEl.getAll();}

	public ArrayList<Tipo_Elemento>getAllEncargado() throws Exception{
	return dataTiEl.getAllEncargado();}

	
	public Tipo_Elemento getById(int id) throws Exception{
		Tipo_Elemento t=new Tipo_Elemento();
		t.setIdtipo_elemento(id);
		return getById(t);
		}


	private Tipo_Elemento getById(Tipo_Elemento t) throws Exception {
		// TODO Auto-generated method stub
		return this.dataTiEl.getById(t);
	}
}
