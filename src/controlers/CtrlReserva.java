package controlers;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	public ArrayList<Reserva> getReservasPendientes(Persona p) throws Exception{
		return dataRes.getReservasPendientes(p);
			}
	
	public ArrayList<Reserva> getAllPendientes() throws Exception{
		return dataRes.getAllPendientes();
			}
	
	public ArrayList<Reserva> getPendientes(Persona p, Tipo_Elemento t) throws Exception{
		return dataRes.getPendientes(p,t);
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
		
	public java.sql.Date convertirFecha(String f) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
         java.util.Date parsed = format.parse(f);
         //System.out.println(parsed);
         java.sql.Date fecha = new java.sql.Date(parsed.getTime());
        // System.out.println(parsed);
		return fecha;
	}

	
	public java.sql.Time convertirHora(String h) throws ParseException {
		SimpleDateFormat f = new SimpleDateFormat("HHmm");
        java.util.Date pars = f.parse(h);
        java.sql.Time hora = new java.sql.Time(pars.getTime());
		return hora;
	}
	
	public int cambiarEstado(Reserva r) throws Exception
	{
		return dataRes.cambiarEstado(r);
	}
	
	
	}
	
	
