package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
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
import controlers.CtrlReserva;
import util.Fechas;


@WebServlet("/ReservaElemento")
public class ReservaElemento extends HttpServlet {
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
		
	 String action = request.getServletPath();
		 
	        try {
	            switch (action) {
	            
	            case "/insert":
	                insert(request, response);
	                break;
	            case "/delete":
	                delete(request, response);
	                break;
	 	        case "/update":
	                update(request, response);
	                break;
	            default:
	                list(request, response);
	                break;
	            }
	        } catch (SQLException ex){ 	        
	            throw new ServletException(ex);
	        } catch (Exception e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
		 }

		 private void list(HttpServletRequest request, HttpServletResponse response)
		            throws Exception {
			  
		        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/Reservar.jsp");
		        dispatcher.forward(request, response);
		       
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
		        response.sendRedirect("WEB-INF/Reservar.jsp");
		        
		        
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
		 
		    private void delete(HttpServletRequest request, HttpServletResponse response)
		            throws Exception {
			 	CtrlReserva	cres = new CtrlReserva();
			 	int id_reserva = Integer.parseInt(request.getParameter("id_reserva"));
		 
		    	Reserva r= new Reserva();
		        r.setId_reserva(id_reserva);
		        cres.delete(r);
		        response.sendRedirect("WEB-INF/Reservar.jsp");} // es necesaria esta lista?
		 //solo listado redirecciona al .jsp y el resto?
		    
}

