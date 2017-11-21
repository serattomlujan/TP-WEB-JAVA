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
import controlers.CtrlReserva;
import entity.Persona;
import entity.Reserva;



@WebServlet("/ReservasPendientes/*")
public class ReservasPendientes extends HttpServlet {
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
		// TODO Bloque catch generado automáticamente
		e.printStackTrace();
	} 
	       
		 }

		 private void list(HttpServletRequest request, HttpServletResponse response)
		            throws Exception {
			 	CtrlReserva	cres = new CtrlReserva();
			 	
			 	Persona user=(Persona) request.getSession().getAttribute("user");
			 	
			 	if(user.getCategoria().getId_categoria()==2){
		        List<Reserva> listResTodas = cres.getAllPendientes();
		        request.setAttribute("list", listResTodas);}
			 	else{
			 		 List<Reserva> misReservas = cres.getReservasPendientes(user);
				        request.setAttribute("list", misReservas);
					}
			 	 RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/ReservasPendientes.jsp");
			     dispatcher.forward(request, response);
			       	
		       
		    }
		 
		 
		
}
