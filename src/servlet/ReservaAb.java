package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Elemento;
import entity.Persona;
import entity.Reserva;
import entity.Tipo_Elemento;
import controlers.CtrlABMElemento;
import controlers.CtrlABMPersona;
import controlers.CtrlABMTipoElemento;
import controlers.CtrlReserva;
import util.Emailer;
import util.Fechas;

import org.apache.catalina.Session;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;

import javax.mail.*;
import javax.mail.internet.*;

@WebServlet("/ReservaAb/*")
public class ReservaAb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ReservaAb(){
		super();
	}
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	};

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try{
        	if(request.getPathInfo()==null || request.getPathInfo().isEmpty()){
        		request.getRequestDispatcher("WEB-INF/Reservar.jsp").forward(request, response);
        	}
        	else{
        		String action = request.getPathInfo();
        	
	            switch (action) {
	            
	            case "/buscar":
	            	this.buscar(request, response);
	            	break;	            
	            case "/insert":
	                this.insert(request, response);
	                break;
	            case "/update":
	                this.update(request, response);
	                break; 
	 	        default:
	                //list(request, response);
	                break;
	            }}
        	}
	        catch (SQLException ex){ 	        
	            throw new ServletException(ex);
	        } catch (Exception e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
		 }

		
		 
		 private void insert(HttpServletRequest request, HttpServletResponse response)throws Exception {
			 	CtrlReserva	cres = new CtrlReserva();
			 	Fechas f = new Fechas();
			 	java.sql.Date fecha=f.ParseFecha2(request.getParameter("fecha"));
			 	//if(fecha.){
			 	
		    	Fechas h= new Fechas();
		    	Fechas hf= new Fechas();
		    	Time hora = h.ParseHora(request.getParameter("hora"));
		    	Time horaF = hf.ParseHora(request.getParameter("hora_fin"));
		    	String estado ="pendiente";
		        String detalle = request.getParameter("detalle");
		        CtrlABMElemento cele=new CtrlABMElemento();
		        Elemento ele = new Elemento();
		        String idele=request.getParameter("elemento");
		        
		        int idelemento = Integer.parseInt(idele);
		        ele=cele.getById(idelemento);
		        
		        //Date hoy= new Date();
		        Persona p=(Persona)request.getSession().getAttribute("user");
		        
		        Reserva r= new Reserva();
		        r.setElemento(ele);
		        r.setFecha(fecha);
				r.setHora_ini(hora);
				r.setHora_fin(horaF);
				r.setDetalle(detalle);
				r.setPersona(p);
				
				//if(fecha.after(hoy)){
			boolean valida=cres.validar(r);      	    	
			if(valida){
										  	
				if(cres.getPendientes(p, ele.getTipo_Elem()).size() < r.getElemento().getTipo_Elem().getCant_max())
				{
					r.setEstado(estado);
					cres.add(r); 
					//String id=String.valueOf(r.getId_reserva());       
					//response.getWriter().append("Reserva registrada con el nro: ").append(id);
					request.setAttribute("reservada", "ok");
					//response.sendRedirect("../ReservaAb");
			        
					request.getRequestDispatcher("/WEB-INF/Reservar.jsp").forward(request, response);
		    						
					//Emailer.getInstance().send("marianabsanchez@hotmail.com","Reserva realizada", r.getEstado());
						}
				else {
					request.setAttribute("reservada", "maximo");
					request.getRequestDispatcher("/WEB-INF/Reservar.jsp").forward(request, response);
		    		
					//response.getWriter().append("Supera la cantidad máxima de reservas de ese tipo");
				}
				}
						
			else {
				request.setAttribute("reservada", "anticip");
				request.getRequestDispatcher("/WEB-INF/Reservar.jsp").forward(request, response);
	    		
				//response.getWriter().append("No cumple con la cantidad de días de anticipación");
			}
			//}
		       // else {request.setAttribute("reservada", "error");
		        //request.getRequestDispatcher("/WEB-INF/Reservar.jsp").forward(request, response);}
			}
		 
		 
		 
		    private void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
			 	CtrlReserva	cres = new CtrlReserva();
		    	
			 	int id_reserva = Integer.parseInt(request.getParameter("id_reserva"));
			 	
		        Reserva r= new Reserva();
		        
		        r.setId_reserva(id_reserva);
		        cres.update(r);
		        response.getWriter().append("La Reserva ha sido cancelada");
				
		    }
		 
		    
		    private void cancelar(HttpServletRequest request, HttpServletResponse response)throws Exception {
			 	CtrlReserva	cres = new CtrlReserva();
			 	int id_reserva = Integer.parseInt(request.getParameter("id_reserva"));
		 
		    	Reserva r= new Reserva();
		        r.setId_reserva(id_reserva);
		        cres.update(r);
		        request.getRequestDispatcher("/WEB-INF/Reservar.jsp").forward(request, response);} 
		    
		    
		   
		    private void buscar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		    	
		    	request.setAttribute("reservada", "no");
		    	CtrlReserva	cres = new CtrlReserva();
		    	CtrlABMTipoElemento cti=new CtrlABMTipoElemento();
		    	Reserva r=new Reserva();
		    	
		    	Tipo_Elemento ti= new Tipo_Elemento();
		    	
		    	String id=request.getParameter("tipo");
		    	if(!id.equals("Seleccione un tipo")){
		    	int id_tipo = Integer.parseInt(id.trim());
		    	
		      	ti=cti.getById(id_tipo);
		      		      	
		    	java.sql.Date f=cres.convertirFecha(request.getParameter("fecha"));
		    	
		    	java.sql.Time h=cres.convertirHora(request.getParameter("hora"));
		    	
		    	java.sql.Time hFin=cres.convertirHora(request.getParameter("hora_fin"));
		    	
		    	 //Date hoy= new Date();		
     	    	    	 
			   	//if(f.after(hoy)){
		    		r.setFecha(f);
		    		r.setHora_ini(h);
		    		r.setHora_fin(hFin);
		    		boolean validaHs=cres.validarHoras(h,hFin,ti);
		    		//boolean valida=cres.validar(r);
		    		//if(valida){
		    			if(validaHs){
		    				ArrayList<Elemento> elems=new ArrayList<Elemento>();
		    				elems=cres.getElemDisponibles(f, h, hFin, cres.getElementos(ti));
		    				if (elems.size()>0)
		    				{		
		    					request.setAttribute("disponibles", elems);
		    					request.setAttribute("reserva", r);
		    					}
		    				
		    				else request.setAttribute("valido","ok");
		    				request.getRequestDispatcher("/WEB-INF/Reservar.jsp").forward(request, response);}
		    			 else {
		    				 request.setAttribute("reservada", "limite");
		    				 request.getRequestDispatcher("/WEB-INF/Reservar.jsp").forward(request, response);
			    		
		    			 }}
		    	else{request.setAttribute("reservada", "error");
				 request.getRequestDispatcher("/WEB-INF/Reservar.jsp").forward(request, response);
		    	}
		    		
		    	//request.setAttribute("reservada", null);
		    	//response.getWriter().append("Supera el límite de tiempo para ese tipo de elemento");}
		    			 }
		    		//else response.getWriter().append("No cumple con la cantidad de días de anticipación");}
			   //	else response.getWriter().append("La fecha ingresada debe ser mayor a la actual");}
		    
}

