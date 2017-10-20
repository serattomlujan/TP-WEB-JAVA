package controlers;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

//import UI.MainWindow;
import data.DataElemento;
import data.DataPersona;
import data.DataReserva;
import data.DataTipoElemento;
import entity.Elemento;
import entity.Persona;
import entity.Reserva;
import entity.Tipo_Elemento;

public class CtrlReserva {
	private DataReserva dataRes;
	private DataElemento dataEle;
	private DataPersona dataPer;
	private DataTipoElemento dataTip;
	
	
	public CtrlReserva(){
		dataRes=new DataReserva();
		dataEle=new DataElemento();
		dataPer=new DataPersona();
		dataTip=new DataTipoElemento();
		
		
	}

	public void add(Reserva r) throws Exception{
		dataRes.add(r);}
	
	
   public void delete(Reserva r) throws Exception{
	   dataRes.remove(r);}
   
   public void update(Reserva r) throws Exception{
	   dataRes.update(r);
   }
   
   public ArrayList<Persona>getAll() throws Exception{
		return dataPer.getAll();}
	
	public ArrayList<Elemento> getElementos() throws Exception{
		return dataEle.getAll();
			}
	public ArrayList<Reserva> getReservasPendientes() throws Exception{
		return dataRes.getReservasPendientes();
			}
	
	public ArrayList<Reserva> getAllPendientes() throws Exception{
		return dataRes.getAllPendientes();
			}
	
	public ArrayList<Reserva> getPendientes() throws Exception{
		return dataRes.getPendientes();
			}
	
	public ArrayList<Tipo_Elemento>getTipos() throws Exception{ 
		// TODO Auto-generated method stub
		//if (MainWindow.usuarioAct.getCategoria().getId_categoria()==1)
		return dataTip.getAll();
		//else return dataTip.getAllEncargado();
		
	}
	
	public boolean validar(Reserva r){
		
		return dataRes.validar(r);
	
	}
	
	
	public ArrayList<Elemento> getElementos(Tipo_Elemento t) throws Exception{
		return dataEle.getByTipo(t);
	}	
	
	
	public ArrayList<Elemento> getElemDisponibles(Date f, Time h,ArrayList<Elemento>el) throws Exception
		{ return dataRes.getElemDisponibles(f, h, el);
		}

	
	
	public int validarBotonBuscar(int cboTipos , String fecha,String hora) {
		int ok;
		if (cboTipos == -1)
		 	{ok= 1;}
		else if ((fecha.isEmpty()) || (hora.isEmpty()))
		 	{ok=2;} 
		else {ok=3;}
		 	return ok;
		}
		
	
	}
	
	
