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



@WebServlet("/ListadoTipoElementos/*")
public class ListadoTipoElementos extends HttpServlet {
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
	
	 try {
		list(request, response);
	} catch (Exception e) {
		// TODO Bloque catch generado autom�ticamente
		e.printStackTrace();
	} 
	       
		 }

		 private void list(HttpServletRequest request, HttpServletResponse response)
		            throws Exception {
			 CtrlABMTipoElemento ctipoele = new CtrlABMTipoElemento();
		        List<Tipo_Elemento> listTipoEle = ctipoele.getAll();
		        request.setAttribute("list", listTipoEle);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/ListadoTipoElementos.jsp");
		        dispatcher.forward(request, response);
		       
		    }
		 
		 
		
}

