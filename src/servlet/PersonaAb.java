package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controlers.CtrlABMPersona;
import util.AppDataException;
import entity.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;


@WebServlet("/Persona")
public class PersonaAb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * Default constructor. 
     */
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  throws ServletException, IOException {
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
			    } catch (SQLException ex) {
			        throw new ServletException(ex);
			    }
			}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		

		 throws ServletException, IOException {
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
	        } 
	        catch (SQLException ex){     
	        
	        
	            throw new ServletException(ex);
	        
	        }
		 }
	}
		 private void list(HttpServletRequest request, HttpServletResponse response)
		            throws Exception {
			    CtrlABMPersona	cpers = new CtrlABMPersona();
		        List<Persona> listPersona = cpers.getAll();
		        request.setAttribute("list", listPersona);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("ListadoPersonas.jsp");
		        dispatcher.forward(request, response);
		    }
		 
		
		 
		 private void insert(HttpServletRequest request, HttpServletResponse response)
		            throws Exception {
			 	CtrlABMPersona	cpers = new CtrlABMPersona();
		    	String nombre = request.getParameter("nombre");
		        String apellido = request.getParameter("apellido");
		        String dni = request.getParameter("dni");
		        boolean habilitado = request.getParameter("habilitado") != null;
		        String usuario = request.getParameter("usuario");
		        String contrasenia = request.getParameter("contrasenia");
		 
		        Persona per = new Persona();
		        per.setDni(dni);
		   	    per.setNombre(nombre);
		   	    per.setApellido(apellido);
		   	    per.setHabilitado(habilitado);
		   	    per.setDni(dni);
		   	    per.setUsuario(usuario);
		   	    per.setContrasenia(contrasenia);
		        cpers.add(per);
		        response.sendRedirect("list");
		        
		        
		    }
		 
		    private void update(HttpServletRequest request, HttpServletResponse response)
		            throws Exception {
		    	CtrlABMPersona	cpers = new CtrlABMPersona();
		    	String nombre = request.getParameter("nombre");
		        String apellido = request.getParameter("apellido");
		        String dni = request.getParameter("dni");
		        boolean habilitado = request.getParameter("habilitado") != null;
		        String usuario = request.getParameter("usuario");
		        String contrasenia = request.getParameter("contrasenia");
		 
		        Persona per = new Persona();
		        per.setDni(dni);
			   	per.setNombre(nombre);
			   	per.setApellido(apellido);
			   	per.setHabilitado(habilitado);
			   	per.setDni(dni);
			   	per.setUsuario(usuario);
			   	per.setContrasenia(contrasenia);
		        cpers.update(per);
		        response.sendRedirect("list"); 
		    }
		 
		    private void delete(HttpServletRequest request, HttpServletResponse response)
		            throws Exception {
		    	CtrlABMPersona	cpers = new CtrlABMPersona();
		    	String dni = request.getParameter("dni");
		 
		        Persona per = new Persona();
		        per.setDni(dni);
		        cpers.delete(per);
		        response.sendRedirect("list");} // es necesaria esta lista?
		 //solo listado redirecciona al .jsp y el resto?
		    
}

