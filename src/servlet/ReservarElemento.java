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
import controlers.CtrlABMPersona;
import controlers.CtrlABMTipoElemento;
import controlers.CtrlReserva;
import util.Fechas;


@WebServlet("/ReservaAb/*")
public class ReservarElemento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ReservarElemento(){
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

		
		 
		
		 
		 private void insert(HttpServletRequest request, HttpServletResponse response)
		            throws Exception {
			 	CtrlReserva	cres = new CtrlReserva();
			 	int id_reserva = Integer.parseInt(request.getParameter("id_reserva"));
			 	Fechas f = new Fechas();
			 	Date fecha=f.ParseFecha(request.getParameter("fecha"));
		    	
			 	Fechas h= new Fechas();
		    	Time hora = h.ParseHora(request.getParameter("hora"));
		        String detalle = request.getParameter("detalle");
		        
		        Elemento ele = new Elemento();
		        int idelemento = Integer.parseInt(request.getParameter("idelemento"));
		        ele.setIdelemento(idelemento);
		    
		        Persona per=(Persona) request.getSession().getAttribute("user");
			 				 	       
		        Reserva r= new Reserva();
		        
		        r.setId_reserva(id_reserva);
		        r.setFecha(fecha);
		        r.setHora(hora);
		        r.setDetalle(detalle);
		        r.setEstado("pendiente");
		        r.setElemento(ele);
		        r.setPersona(per);
		        
		        cres.add(r); 
		        response.getWriter().append("Reserva registrada con éxito");
				
		        
		    }
		 
		    private void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
			 	CtrlReserva	cres = new CtrlReserva();
		    	
			 	int id_reserva = Integer.parseInt(request.getParameter("id_reserva"));
			 	
		        Reserva r= new Reserva();
		        
		        r.setId_reserva(id_reserva);
		        cres.update(r);
		        response.getWriter().append("La Reserva ha sido cancelada");
				
		    }
		 
		   
		   
		    private void buscar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		    	CtrlReserva	cres = new CtrlReserva();
		    	CtrlABMTipoElemento cti=new CtrlABMTipoElemento();
		    	Reserva r=new Reserva();
		    	
		    	int id_tipo = Integer.parseInt(request.getParameter("tipo"));
		    	Tipo_Elemento ti= new Tipo_Elemento();
		    	ti=	cti.getById(id_tipo);
		     	System.out.println(ti);
		      	String fecha=(String)request.getParameter("fecha");
		    	java.sql.Date f=cres.convertirFecha(fecha);
		    	System.out.println(f);
		    	java.sql.Time h=cres.convertirHora(request.getParameter("hora"));
		    	System.out.println(h);
		    	r.setFecha(f);
		    	r.setHora(h);
		    	ArrayList<Elemento> elems=new ArrayList<Elemento>();
		    	elems=cres.getElemDisponibles(f, h, cres.getElementos(ti));
		    	request.setAttribute("disponibles", elems);
		    	System.out.println(elems);
		    	request.setAttribute("reserva", r);
			    request.getRequestDispatcher("/WEB-INF/Reservar.jsp").forward(request, response);
		    
		    }
		    
}

