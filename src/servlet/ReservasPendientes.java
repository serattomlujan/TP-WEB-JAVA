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
import util.Emailer;



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
		//System.out.println(request.getPathInfo());
		
		try{
        	if(request.getPathInfo()==null || request.getPathInfo().isEmpty()){
        		this.list(request, response);
        	}
        	else{
        		String action = request.getPathInfo();
        	
	            switch (action) {
	            
	            case "/cancelarReserva":
	                this.cancelarReserva(request, response);

	                break;
	 	     
	            default:
	                //list(request, response);
	                break;
	            }}
        	}
	        catch (Exception e) {
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
		 
		 
		 private void cancelarReserva(HttpServletRequest request, HttpServletResponse response) throws Exception
		 {
			 
			 String id=request.getParameter("cancelar"); 
			 int id_reserva=Integer.parseInt(id);
			 CtrlReserva ctrlR=new CtrlReserva();
			 Reserva r=new Reserva();
			 r.setId_reserva(id_reserva);
			 int ok=ctrlR.cambiarEstado(r);
			 if (ok==1)
			 {
				 //System.out.println(ok); 
				 Persona p=(Persona)request.getSession().getAttribute("user");
				Emailer.getInstance().send(p.getEmail(),"Reserva Cancelada","El estado de su Reserva es :Cancelada");
				System.out.println("Enviando Mail.....");
		        response.sendRedirect("../ReservasPendientes");
			        
			 }
			 
		 }
		 
		 
		
}
