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
public class ReservaAb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * Default constructor. 
     */
   
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
	            
	            case "/insert":
	                insert(request, response);
	                break;
	            case "/cancelar":
	                cancelar(request, response);
	                break;
	            case "/buscar":
	            	buscar(request, response);
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
		        String estado = request.getParameter("estado");
		        String detalle = request.getParameter("detalle");
		        
		        Elemento ele = new Elemento();
		        int idelemento = Integer.parseInt(request.getParameter("idelemento"));
		        ele.setIdelemento(idelemento);
		    
		        Persona per = new Persona();
		        String dni = request.getParameter("dni");
		        per.setDni(dni);
		        
		        Reserva r= new Reserva();
		        
		        r.setId_reserva(id_reserva);
		        r.setFecha(fecha);
		        r.setHora(hora);
		        r.setEstado(estado);
		        r.setDetalle(detalle);
		        r.setElemento(ele);
		        r.setPersona(per);
		        
		        cres.add(r); 
		        response.getWriter().append("Reserva registrada con éxito");
				
		        
		    }
		 
		    private void update(HttpServletRequest request, HttpServletResponse response)
		            throws Exception {
			 	CtrlReserva	cres = new CtrlReserva();
		    	
			 	int id_reserva = Integer.parseInt(request.getParameter("id_reserva"));
			 	Fechas f = new Fechas();
			 	Date fecha=f.ParseFecha(request.getParameter("fecha"));
		    	
			 	Fechas h= new Fechas();
		    	Time hora = h.ParseHora(request.getParameter("hora"));
		        String estado = request.getParameter("estado");
		        String detalle = request.getParameter("detalle");
		        
		        Elemento ele = new Elemento();
		        int idelemento = Integer.parseInt(request.getParameter("idelemento"));
		        ele.setIdelemento(idelemento);
		    
		        Persona per = new Persona();
		        String dni = request.getParameter("dni");
		        per.setDni(dni);
		        
		        Reserva r= new Reserva();
		        
		        r.setId_reserva(id_reserva);
		        r.setFecha(fecha);
		        r.setHora(hora);
		        r.setEstado(estado);
		        r.setDetalle(detalle);
		        r.setElemento(ele);
		        r.setPersona(per);
		        cres.update(r);
		        response.sendRedirect("WEB-INF/Reservar.jsp"); 
		    }
		 
		    private void cancelar(HttpServletRequest request, HttpServletResponse response)
		            throws Exception {
			 	CtrlReserva	cres = new CtrlReserva();
			 	int id_reserva = Integer.parseInt(request.getParameter("id_reserva"));
		 
		    	Reserva r= new Reserva();
		        r.setId_reserva(id_reserva);
		        cres.delete(r);
		        response.sendRedirect("WEB-INF/Reservar.jsp");} // es necesaria esta lista?
		 //solo listado redirecciona al .jsp y el resto?
		    
		   
		    private void buscar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		    	CtrlReserva	cres = new CtrlReserva();
		    	CtrlABMTipoElemento cti=new CtrlABMTipoElemento();
		    	Reserva r=new Reserva();
		    	int id_tipo = Integer.parseInt(request.getParameter("tipo"));
		      	Tipo_Elemento ti=new Tipo_Elemento();
		     	ti=cti.getById(id_tipo);
		    	java.sql.Date f=cres.convertirFecha(request.getParameter("fecha"));
		    	java.sql.Time h=cres.convertirHora(request.getParameter("hora"));
		    	r.setFecha(f);
		    	r.setHora(h);
		    	ArrayList<Elemento> elems=new ArrayList<Elemento>();
		    	elems=cres.getElemDisponibles(f, h, cres.getElementos(ti));
		    	request.setAttribute("disponibles", elems);
			    request.getRequestDispatcher("/WEB-INF/Reservar.jsp").forward(request, response);
		    
		    }
		    
}

