package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.AppDataException;
import controlers.CtrlABMPersona;
import entity.Categoria;
import entity.Persona;


@WebServlet("/PersonaAb/*")
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
		
			try{
	        	if(request.getPathInfo()==null || request.getPathInfo().isEmpty()){
	        		request.getRequestDispatcher("WEB-INF/ABMCPersona.jsp").forward(request, response);
	        	}else{
	        		String action = request.getPathInfo();
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
		 	        case "/buscar":
		 	    	   this.buscar(request, response);
		 	    	   break;
		 	        default:
		               //this.error(request, response);
		                break;
		 	        
	        	}
	        	}
	        } catch (SQLException ex){ 	        
	            throw new ServletException(ex);
	        } catch (Exception e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
		 }

		
		 
		 private void error(HttpServletRequest request, HttpServletResponse response) {
			 response.setStatus(404);
			 //redirigir a página de error
			 }
		 
		 
		 private void insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
				try{
			 
			 	CtrlABMPersona	cpers = new CtrlABMPersona();
		    	
			 	String dni = request.getParameter("dni");
			 	//System.out.print(dni);
			 	String nombre = request.getParameter("nombre_per");
		        String apellido = request.getParameter("apellido");
		        String usuario = request.getParameter("usuario");
		        String contrasenia = request.getParameter("contrasenia");
		        int id_cat=Integer.parseInt(request.getParameter("categoria"));
		        boolean habilitado = request.getParameter("habilitado") != null;
		        String email=request.getParameter("email");
			       
		        //validaer que los getpara sean distintos d enull
		 
		        Persona per = new Persona();
		        ArrayList<Categoria> cats=cpers.getCategorias();
		        for(Categoria c:cats){
		        	if(c.getId_categoria()==id_cat) per.setCategoria(c);
		        }
		   	    per.setNombre(nombre);
		   	    per.setApellido(apellido);
		   	    per.setHabilitado(habilitado);
		   	    per.setDni(dni);
		   	    per.setUsuario(usuario);
		   	    per.setContrasenia(contrasenia);
		   	    per.setEmail(email);
		   	    cpers.add(per);
		   	    String id= String.valueOf(cpers.getByDni(dni).getIdpersona());
		   	    
		   	    request.setAttribute("nueva", "ok");
		   	    response.getWriter().append("Persona ingresada con éxito con el nro: ").append(id);
		   	    //request.getRequestDispatcher("/WEB-INF/ABMCPersona.jsp").forward(request, response);
			    
		   	    //response.sendRedirect("WEB-INF/ABMCPersona.jsp");
		        
		        
					}
				catch (Exception e){
					e.printStackTrace();
					}
		 		}
		 
				 
		    private void update(HttpServletRequest request, HttpServletResponse response)
		            throws Exception {
		    	try{
					 
				 	CtrlABMPersona	cpers = new CtrlABMPersona();
				 	
			    	//int id=Integer.parseInt(request.getParameter("idpersona"));
				 	String ida=request.getParameter("idpersona");
				 	int id=Integer.parseInt(ida.trim());
				 	String dni = request.getParameter("dni");
				 	//System.out.print(request.getParameter("dni"));
				 	String nombre = request.getParameter("nombre_per");
			        String apellido = request.getParameter("apellido");
			        String usuario = request.getParameter("usuario");
			        String contrasenia = request.getParameter("contrasenia");
			        String id_cat=request.getParameter("categoria");
			        //System.out.print(request.getParameter("categoria"));
			        boolean habilitado = request.getParameter("habilitado") != null;
			        String email = request.getParameter("email");
			        
				       
			        //validar que los getpara sean distintos d enull
			 
			        Persona per = new Persona();
			        ArrayList<Categoria> cats=cpers.getCategorias();
			        for(Categoria c:cats){
			        	if(c.getId_categoria()==Integer.parseInt(id_cat)) per.setCategoria(c);
			        }
			        //System.out.print(Integer.parseInt(id));
			        per.setIdpersona(id);
			   	    per.setNombre(nombre);
			   	    per.setApellido(apellido);
			   	    per.setHabilitado(habilitado);
			   	    per.setDni(dni);
			   	    per.setUsuario(usuario);
			   	    per.setContrasenia(contrasenia);
			   	    per.setEmail(email);
			   	    ArrayList<Persona> todas= new ArrayList<Persona>();
			   	    todas=cpers.getAll();
			   	    for(Persona p: todas)
			   	    	if(p.getIdpersona()==per.getIdpersona()) cpers.update(per);
			   	    response.getWriter().append("Los datos de la persona fueron modificados");
			   	    
					
			        }
					catch (Exception e){
						e.printStackTrace();
						}
			 		}
			 
		    
		    private void delete(HttpServletRequest request, HttpServletResponse response)
		   
		    		throws Exception {
		    	 
		    	try{
					 
				 	CtrlABMPersona	cpers = new CtrlABMPersona();
			    	

				 	Persona pers=new Persona();
				 	String dni= request.getParameter("dni");
				 	
				 	if (dni=="")
				 		{
				 		response.getWriter().append("dni vacio");
				 		}
				 	else
				 	{	
					pers.setDni(dni);
				 	
				 	pers=cpers.getByDni(dni);
				 	
				 	cpers.delete(pers);

			   	   	response.getWriter().append("Los datos de la persona fueron eliminados");
			   	   
			   	    
				 	}
			        }
					catch (Exception e){
						System.out.println("error");
						e.printStackTrace();
						}
			 		}
			
		    
		    
		    
		    private void buscar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		    	CtrlABMPersona	cpers = new CtrlABMPersona();
		    	String dni = request.getParameter("dni");
		    	Persona per = new Persona();
		    	per.setDni(dni);
			    per=cpers.getByDni(per);
			    if(per!=null) request.setAttribute("encontrada", per);
			    else request.setAttribute("valido","ok");
			    request.setAttribute("buscar", "si");
			    request.getRequestDispatcher("/WEB-INF/ABMCPersona.jsp").forward(request, response);
			    }
			    
			    }
		    


