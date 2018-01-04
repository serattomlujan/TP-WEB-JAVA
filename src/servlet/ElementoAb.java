package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlers.CtrlABMElemento;
import controlers.CtrlABMPersona;
import controlers.CtrlABMTipoElemento;
import entity.Categoria;
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
	 	    	   this.error(request, response);
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

		
		 
		
		 
		 private void insert(HttpServletRequest request, HttpServletResponse response)
		            throws Exception {
			 	
				try{
					 
					CtrlABMElemento	cele = new CtrlABMElemento();
			    	
				 	String nombre = request.getParameter("nombre");
				 	String tipo=request.getParameter("tipo");
				 	
				 	request.setAttribute("nuevo", "ok");
				 	
				 	if(!tipo.equals("Seleccione un tipo")){		 	
			        int id_tipo=Integer.parseInt(tipo);
			        Elemento ele = new Elemento();
			        ele.setNombre(nombre);
			        ArrayList<Tipo_Elemento> tipos=cele.getTipos();
			        for(Tipo_Elemento ti:tipos){
			        	if(ti.getIdtipo_elemento()==id_tipo) ele.setTipo_Elem(ti);
			        }
			   	    
			        cele.add(ele);}
			   	    //String id= String.valueOf(cele.getByNombre(nombre).getIdelemento());
			        //response.getWriter().append("Elemento ingresado con éxito con el nro: ").append(id);
				 	else request.setAttribute("nuevo", "error");
			   	    request.getRequestDispatcher("/WEB-INF/ABMCElemento.jsp").forward(request, response);
			        
						}
					catch (Exception e){
						e.printStackTrace();
						}
			 		}
			 
			
			 
			 	
		   
		 
		   private void update(HttpServletRequest request, HttpServletResponse response)
		            throws Exception {
			   try{
			    CtrlABMElemento	cele = new CtrlABMElemento();
			    CtrlABMTipoElemento ctiel=new CtrlABMTipoElemento();
			    String nombre = request.getParameter("nombre");
			    String idele = request.getParameter("idelemento");
			    request.setAttribute("nuevo", "modif");
		        if(idele!=""){  
			    int idelemento= Integer.parseInt(idele.trim());
		        Tipo_Elemento tp = new Tipo_Elemento();
		        String tipele=request.getParameter("tipo");
		         
		        int tipo_elemento= Integer.parseInt(tipele.trim());
		       	   
		        tp.setIdtipo_elemento(tipo_elemento);
		        //System.out.println(tipo_elemento);
		        Elemento ele = new Elemento();
		        ele.setIdelemento(idelemento);
		        ele.setNombre(nombre);
		        ele.setTipo_Elem(tp);
		        cele.update(ele);
		        }
		   	    //response.getWriter().append("Los datos del elemento fueron modificados");
		        else request.setAttribute("nuevo", "error");
		        request.getRequestDispatcher("/WEB-INF/ABMCElemento.jsp").forward(request, response);
		        }
				catch (Exception e){
					e.printStackTrace();
					}
		 		}
		 

		 
		    private void delete(HttpServletRequest request, HttpServletResponse response)
		            throws Exception {
		    	CtrlABMElemento	cele = new CtrlABMElemento();
		    	  String idele = request.getParameter("nombre");
		    	  String id=request.getParameter("idelemento");
				 //int idelemento= Integer.parseInt(idele.trim());
		    	Elemento ele = new Elemento();
		      
		        ele.setNombre(idele);		       
		        cele.delete(ele);
		        request.setAttribute("nuevo", "elim");
		        if(id=="")request.setAttribute("nuevo", "error");
		        request.getRequestDispatcher("/WEB-INF/ABMCElemento.jsp").forward(request, response);}
		        //response.getWriter().append("Los datos del elemento fueron eliminados");} // es necesaria esta lista?
		 //solo listado redirecciona al .jsp y el resto?
		    
		    

	
			private void buscar(HttpServletRequest request, HttpServletResponse response) throws Exception {
				CtrlABMElemento	cele = new CtrlABMElemento();
				String nombre = request.getParameter("nombre");
				Elemento ele = new Elemento();
				ele.setNombre(nombre);
				ele=cele.getByNombre(ele);
				if(ele!=null){
       
				request.setAttribute("encontrada", ele);
				}
				else {
					request.setAttribute("valido","ok");
					//request.getRequestDispatcher("/WEB-INF/ABMCElemento.jsp").forward(request, response);
					}
				request.setAttribute("buscar", "si");
			    request.getRequestDispatcher("/WEB-INF/ABMCElemento.jsp").forward(request, response);
				
			}	}    
		    
		    
		    
		    

		 