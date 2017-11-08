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
import controlers.CtrlABMTipoElemento;

import entity.Tipo_Elemento;



@WebServlet("/TipoElementoAb/*")
public class TipoElementoAb extends HttpServlet {
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
			    CtrlABMTipoElemento ctipoele = new CtrlABMTipoElemento();
		        List<Tipo_Elemento> listTipoEle = ctipoele.getAll();
		        //request.setAttribute("list", listPersona);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/ABMCTipoElemento.jsp");
		        dispatcher.forward(request, response);
		       
		    }
		 
		
		 
		 private void insert(HttpServletRequest request, HttpServletResponse response)
		            throws Exception {
			 	CtrlABMTipoElemento ctipoele = new CtrlABMTipoElemento();
			 	int id_tipoelemento = Integer.parseInt(request.getParameter("id_tipoelemento"));
			 	String nombre_tipo = request.getParameter("nombre_tipo");
			 	int cant_max = Integer.parseInt(request.getParameter("cant_max"));
			 	int lim_tiempo = Integer.parseInt(request.getParameter("lim_tiempo"));
			 	int dias_anticip = Integer.parseInt(request.getParameter("dias"));
		        boolean encargado = request.getParameter("encargado") != null;
		        
		 
		        Tipo_Elemento tipoele = new Tipo_Elemento();
		        tipoele.setIdtipo_elemento(id_tipoelemento);
		        tipoele.setNombre_tipo(nombre_tipo);
		        tipoele.setCant_max(cant_max);
		        tipoele.setDias_anticip(dias_anticip);
		        tipoele.setEncargado(encargado);
		       
		        ctipoele.add(tipoele);
		        response.sendRedirect("WEB-INF/ABMCTipoElemento.jsp");
		        
		        
		    }
		 
		    private void update(HttpServletRequest request, HttpServletResponse response)
		            throws Exception {
		    	CtrlABMTipoElemento ctipoele = new CtrlABMTipoElemento();
			 	int id_tipoelemento = Integer.parseInt(request.getParameter("id_tipoelemento"));
			 	String nombre_tipo = request.getParameter("nombre_tipo");
			 	int cant_max = Integer.parseInt(request.getParameter("cant_max"));
			 	int lim_tiempo = Integer.parseInt(request.getParameter("lim_tiempo"));
			 	int dias_anticip = Integer.parseInt(request.getParameter("dias"));
		        boolean encargado = request.getParameter("encargado") != null;
		        
		        Tipo_Elemento tipoele = new Tipo_Elemento();
		        tipoele.setIdtipo_elemento(id_tipoelemento);
		        tipoele.setNombre_tipo(nombre_tipo);
		        tipoele.setCant_max(cant_max);
		        tipoele.setDias_anticip(dias_anticip);
		        tipoele.setEncargado(encargado);
		        
		       ctipoele.update(tipoele);
		        response.sendRedirect("WEB-INF/ABMCTipoElemento.jsp"); 
		    }
		 
		    private void delete(HttpServletRequest request, HttpServletResponse response)
		            throws Exception {
		    	CtrlABMTipoElemento ctipoele = new CtrlABMTipoElemento();
			 	int id_tipoelemento = Integer.parseInt(request.getParameter("id_tipoelemento"));
			 	
			 	Tipo_Elemento tipoele = new Tipo_Elemento();
			 	tipoele.setIdtipo_elemento(id_tipoelemento);
		        ctipoele.delete(tipoele);
		        response.sendRedirect("WEB-INF/ABMCTipoElemento.jsp");} // es necesaria esta lista?
		 //solo listado redirecciona al .jsp y el resto?
		    
}

