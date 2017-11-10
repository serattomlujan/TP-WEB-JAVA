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

import controlers.CtrlABMElemento;
import controlers.CtrlABMPersona;
import entity.Tipo_Elemento;
import entity.Elemento;
import entity.Persona;


@WebServlet("/ElementoAb/*")
public class ElementoAb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ElementoAb() {
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
        		request.getRequestDispatcher("WEB-INF/ABMCElemento.jsp").forward(request, response);
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
	                //request.getRequestDispatcher("WEB-INF/ABMCPersona.jsp").forward(request, response);
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


		 private void list(HttpServletRequest request, HttpServletResponse response)
		            throws Exception {
			 	CtrlABMElemento	celem = new CtrlABMElemento();
		        List<Elemento> listElemento = celem.getAll();
		        //request.setAttribute("list", listPersona);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/ABMCElemento.jsp");
		        dispatcher.forward(request, response);
		       
		    }
		 
		
		 
		 private void insert(HttpServletRequest request, HttpServletResponse response)
		            throws Exception {
			 	CtrlABMElemento	cele = new CtrlABMElemento();
		    	String nombre = request.getParameter("nombre");
		        int idelemento = Integer.parseInt(request.getParameter("idelemento"));
		        Tipo_Elemento tp = new Tipo_Elemento();
		        int tipo_elemento = Integer.parseInt(request.getParameter("idelemento"));
		        tp.setIdtipo_elemento(tipo_elemento);
		        
		        Elemento ele = new Elemento();
		        ele.setNombre(nombre);
		        ele.setIdelemento(idelemento);
		   	    ele.setTipo_Elem(tp);
		   	    
		        cele.add(ele);
		        response.sendRedirect("WEB-INF/ABMCElemento.jsp");
		        
		        
		    }

		 
		   private void update(HttpServletRequest request, HttpServletResponse response)
		            throws Exception {
			    CtrlABMElemento	cele = new CtrlABMElemento();
			    String nombre = request.getParameter("nombre");
		        int idelemento = Integer.parseInt(request.getParameter("idelemento"));
		        Tipo_Elemento tp = new Tipo_Elemento();
		        int tipo_elemento = Integer.parseInt(request.getParameter("idelemento"));
		        tp.setIdtipo_elemento(tipo_elemento);
		        
		        Elemento ele = new Elemento();
		       
		        ele.setNombre(nombre);
		        ele.setIdelemento(idelemento);
		   	    ele.setTipo_Elem(tp);
		 
		        cele.update(ele);
		        response.sendRedirect("WEB-INF/ABMCElemento.jsp"); 
		    }
		 
		    private void delete(HttpServletRequest request, HttpServletResponse response)
		            throws Exception {
		    	CtrlABMElemento	cele = new CtrlABMElemento();
		    	int idelemento = Integer.parseInt(request.getParameter("idelemento"));
		    	Elemento ele = new Elemento();
		      
		        ele.setIdelemento(idelemento);		       
		        cele.delete(ele);
		        
		        
		        response.sendRedirect("WEB-INF/ABMCElemento.jsp");} // es necesaria esta lista?
		 //solo listado redirecciona al .jsp y el resto?
		    
		    

	
			private void buscar(HttpServletRequest request, HttpServletResponse response) throws Exception {
				CtrlABMElemento	cele = new CtrlABMElemento();
				String nombre = request.getParameter("nombre");
				Elemento ele = new Elemento();
				ele.setNombre(nombre);
				ele=cele.getByNombre(ele);
       
				request.setAttribute("encontrada", ele);
				request.getRequestDispatcher("/WEB-INF/ABMCElemento.jsp").forward(request, response);
				}
			}	    
		    
		    
		    
		    

		 