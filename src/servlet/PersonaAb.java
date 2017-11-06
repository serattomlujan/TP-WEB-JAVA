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
import entity.Persona;


@WebServlet("/PersonaAb")
public class PersonaAb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public PersonaAb() {
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
		
	 String action = request.getServletPath();
		 
	        try {
	            switch (action) {
	            
	            case "/insert":
	                this.insert(request, response);
	                break;
	            case "/delete":
	                this.delete(request, response);
	                break;
	 	        case "/update":
	                this.update(request, response);
	                break;
	 	       case "/consulta":
	 	        	this.consulta(request,response);
	 	        	break;
	 	       default:
	                this.list(request, response);
	                break;
	 	        //
	            //default:
	            	//this.error(request,response);
	                //break;
	            }
	        } catch (SQLException ex){ 	        
	            throw new ServletException(ex);
	        } catch (Exception e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
		 }

		 private void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
			    CtrlABMPersona	cpers = new CtrlABMPersona();
		        List<Persona> listPersona = cpers.getAll();
		        request.setAttribute("list", listPersona);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/ABMCPersona.jsp");
		        dispatcher.forward(request, response);
		       
		    }
		 
		 private void error(HttpServletRequest request, HttpServletResponse response) {
			 response.setStatus(404);
			 //redirigir a página de error
			 }
		 
		 private void consulta(HttpServletRequest request, HttpServletResponse response) throws Exception {
			 response.getWriter().append("Consulta, requested action: ").append(request.getPathInfo()).append(" through post");
			 //crear el controlador y ejecutar el getOne o getById
			 
			 CtrlABMPersona ctrl=new CtrlABMPersona();
			
			
			 try {
		 			Persona p = ctrl.getByDni(request.getParameter("dni"));
		 			
		 			if (p!= null){
		 				;}
		 			
		 			else {}
		 			
		 			} catch (Exception e) {throw e;}
			 
			 }
		 
		 

		private void insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
		        response.sendRedirect("WEB-INF/ABMCPersona.jsp");
		        
		        
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
		        response.sendRedirect("WEB-INF/ABMCPersona.jsp"); 
		    }
		 
		    private void delete(HttpServletRequest request, HttpServletResponse response)
		            throws Exception {
		    	CtrlABMPersona	cpers = new CtrlABMPersona();
		    	String dni = request.getParameter("dni");
		 
		        Persona per = new Persona();
		        per.setDni(dni);
		        cpers.delete(per);
		        response.sendRedirect("WEB-INF/ABMCPersona.jsp");} // es necesaria esta lista?
		 //solo listado redirecciona al .jsp y el resto?
		    
}

