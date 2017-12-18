package data;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.*;
import java.util.Date;

import util.AppDataException;
import util.Fechas;
import entity.*;
 


public class DataReserva {
	
	public ArrayList<Reserva> getReservasPendientes(Persona p) throws Exception{
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Reserva> res= new ArrayList<Reserva>();
		try {
		 	stmt = FactoryConexion.getInstancia().getConn().createStatement();
		 	rs = stmt.executeQuery("select * from reservas r "
		 			+ "inner join  personas p on p.idpersona=r.id_persona "
		 			+ "inner join elementos e on e.idelemento=r.id_elemento "
		 			+ "inner join tipo_elemento te on te.idtipo_elemento=e.idtipo_elemento "
		 			+ "where p.idpersona='" + p.getIdpersona()
		 			+ "'and estado='pendiente' and (fecha>current_timestamp or "
		 			+ "(fecha=current_timestamp and hora_ini>current_timestamp)) order by fecha");
		 	if(rs!=null){
		 		while(rs.next()){
		 			Reserva r=new Reserva();
		 			r.setPersona(new Persona());
		 			r.setElemento(new Elemento());
		 			r.setId_reserva(rs.getInt("id_reserva"));
		 			r.setDetalle(rs.getString("detalle"));
		 			r.setEstado(rs.getString("estado"));
		 			r.setFecha(rs.getDate("fecha"));
		 			r.setHora_ini(rs.getTime("hora_ini"));
		 			r.setHora_fin(rs.getTime("hora_fin"));
		 			r.getElemento().setIdelemento(rs.getInt("r.id_elemento"));
		 			r.getElemento().setNombre(rs.getString("e.nombre"));
		 			r.getElemento().setTipo_Elem(new Tipo_Elemento());
		 			r.getElemento().getTipo_Elem().setIdtipo_elemento(rs.getInt("te.idtipo_elemento"));
		 			r.getElemento().getTipo_Elem().setNombre_tipo(rs.getString("nombre_tipo"));
		 			r.getPersona().setIdpersona(rs.getInt("idpersona"));
		 			r.getPersona().setApellido(rs.getString("apellido"));
		 			r.getPersona().setNombre(rs.getString("p.nombre"));
		 			res.add(r);
		 						}
		 				}		
			} catch (SQLException e) {throw e;
			} catch (AppDataException ade){
					throw ade;
				 		}
				try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
				} catch (SQLException e) {
					e.printStackTrace();
		 		}
				
 		return res;
 		}
		 	
	
	public ArrayList<Reserva> getAllPendientes() throws Exception{
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Reserva> res= new ArrayList<Reserva>();
		try {
		 	stmt = FactoryConexion.getInstancia().getConn().createStatement();
		 	rs = stmt.executeQuery("select * from reservas r "
		 			+ "inner join  personas p on p.idpersona=r.id_persona "
		 			+ "inner join elementos e on e.idelemento=r.id_elemento "
		 			+ "inner join tipo_elemento te on te.idtipo_elemento=e.idtipo_elemento "
		 			+ "where estado='pendiente' and (fecha>current_timestamp or "
		 			+ "(fecha=current_timestamp and hora_ini>current_timestamp)) order by p.apellido, fecha");
		 	if(rs!=null){
		 		while(rs.next()){
		 			Reserva r=new Reserva();
		 			r.setPersona(new Persona());
		 			r.setElemento(new Elemento());
		 			r.setId_reserva(rs.getInt("id_reserva"));
		 			r.setDetalle(rs.getString("detalle"));
		 			r.setEstado(rs.getString("estado"));
		 			r.setFecha(rs.getDate("fecha"));
		 			r.setHora_ini(rs.getTime("hora_ini"));
		 			r.setHora_fin(rs.getTime("hora_fin"));
		 			r.getElemento().setIdelemento(rs.getInt("r.id_elemento"));
		 			r.getElemento().setNombre(rs.getString("e.nombre"));
		 			r.getElemento().setTipo_Elem(new Tipo_Elemento());
		 			r.getElemento().getTipo_Elem().setIdtipo_elemento(rs.getInt("te.idtipo_elemento"));
		 			r.getElemento().getTipo_Elem().setNombre_tipo(rs.getString("nombre_tipo"));
		 			r.getPersona().setIdpersona(rs.getInt("idpersona"));
		 			r.getPersona().setApellido(rs.getString("apellido"));
		 			r.getPersona().setNombre(rs.getString("p.nombre"));
		 			res.add(r);
		 						}
		 				}		
			} catch (SQLException e) {throw e;
			} catch (AppDataException ade){
					throw ade;
				 		}
				try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
				} catch (SQLException e) {
					e.printStackTrace();
		 		}
				
 		return res;
 		}
		 
	
	public void add(Reserva r) throws Exception{
 		PreparedStatement stmt=null;
 		ResultSet keyResultSet=null;
 		System.out.println(r.getFecha());
 	 		try {
 			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
 					"insert into reservas(fecha, hora_ini,hora_fin, id_persona, id_elemento, estado, detalle) "
 					+ "values (?,?,?,?,?,?,?)",
 					PreparedStatement.RETURN_GENERATED_KEYS
 					);
 			java.sql.Date sqlDate = new java.sql.Date(r.getFecha().getTime());
 			System.out.println(sqlDate);
 			stmt.setDate(1,sqlDate);
 			stmt.setTime(2, r.getHora_ini());
 			stmt.setTime(3, r.getHora_fin());
 			stmt.setInt(4, r.getPersona().getIdpersona());
 			stmt.setInt(5, r.getElemento().getIdelemento());
 			stmt.setString(6, r.getEstado());
 			stmt.setString(7, r.getDetalle());
  			stmt.executeUpdate();
 			keyResultSet=stmt.getGeneratedKeys();
 			if(keyResultSet!=null && keyResultSet.next()){
 				r.setId_reserva(keyResultSet.getInt(1));
 			}
 			
 		} catch (SQLException | AppDataException e) {
 			throw e;
 		
 		}
 		try {
 			if(keyResultSet!=null)keyResultSet.close();
 			if(stmt!=null)stmt.close();
 			FactoryConexion.getInstancia().releaseConn();
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 		
 	}
	
	
	public void update(Reserva r) throws Exception{
 		PreparedStatement stmt=null;
 		
 		try {
 			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
 					"update reservas "
 					+ "set fecha=?, hora_ini=?, hora_fin=?, id_persona=?, id_elemento=?, estado='cancelada', detalle=?"
 					+ " where id_reserva=?"
 					
 					);
 			java.sql.Date sqlDate = new java.sql.Date(r.getFecha().getTime());
  			stmt.setDate(1, sqlDate);
 			stmt.setTime(2, r.getHora_ini());
 			stmt.setTime(3, r.getHora_fin());
 			stmt.setInt(4, r.getPersona().getIdpersona());
 			stmt.setInt(5, r.getElemento().getIdelemento());
 			stmt.setString(6, r.getDetalle());
 			stmt.setInt(7, r.getId_reserva());
 			stmt.executeUpdate();
 			
 		} catch (SQLException | AppDataException e) {
 			throw e;
 		}
 		try {
 			if(stmt!=null)stmt.close();
 			FactoryConexion.getInstancia().releaseConn();
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}}
	
	public void remove(Reserva r) throws Exception{
 		PreparedStatement stmt=null;
 		
 		try {
 			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
 					"delete from reservas where id_reserva=?"
 					);
 			stmt.setInt(1, r.getId_reserva());
 			stmt.executeUpdate();
 			
 		} catch (SQLException | AppDataException e) {
 			throw e;
 		}
 		try {
 			
 			if(stmt!=null)stmt.close();
 			FactoryConexion.getInstancia().releaseConn();
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 	}

 	
	public ArrayList<Elemento> getElemDisponibles(Date f,Time h , Time h1, ArrayList<Elemento> elem) throws Exception
	{
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Elemento>e=new ArrayList<Elemento>();
		
				
		stmt = FactoryConexion.getInstancia().getConn().createStatement();
		rs = stmt.executeQuery("select * from elementos e inner join tipo_elemento te "
	 			+ "on e.idtipo_elemento=te.idtipo_elemento where idelemento not in "
	 			+ "(select id_elemento from reservas where estado='pendiente' and fecha='" + f + "'and (hora_ini<='"+ h1 +"'or hora_fin>='"+ h + "'))");
	
		 	if(rs!=null){
			 	while(rs.next()){
			 			Elemento el=new Elemento();
			 			el.setTipo_Elem(new Tipo_Elemento());
			 			el.setIdelemento(rs.getInt("idelemento"));
			 			el.setNombre(rs.getString("nombre"));
			 			el.getTipo_Elem().setIdtipo_elemento(rs.getInt("idtipo_elemento"));
			 			el.getTipo_Elem().setNombre_tipo(rs.getString("nombre_tipo"));
			 			e.add(el);
			  		}
						try {
						if(rs!=null)rs.close();
						if(stmt!=null)stmt.close();
						FactoryConexion.getInstancia().releaseConn();
						} catch (SQLException ex) {
							ex.printStackTrace();
				 		}
						 		
		 		}
		 	 ArrayList <Elemento> edisp=new ArrayList<Elemento>();
		 			
				for (int i=0; i<e.size();i++)
				{ if (elem.contains(e.get(i)))edisp.add(e.get(i));}
				
		return edisp;		
			
	}
	public boolean validar(Reserva r) {
		// TODO Auto-generated method stub
				
				int d= r.getElemento().getTipo_Elem().getDias_anticip();
				java.util.Date hoy= new Date();
				
				Fechas f = new Fechas(); 
				int D=f.diferenciaEnDias2( r.getFecha(),hoy);
				//System.out.print(D);
			
				Calendar cal=Calendar.getInstance();
				cal.setTime(hoy);
				cal.add(Calendar.DAY_OF_YEAR, d);
				/*if (r.getFecha().after(cal.getTime()))
					return true;
				else
				
				return false;*/
								
				if (D >= d){
					return true;
					 }
				else				
					return false;
	}
	
	
	
	
	public boolean validarHoras(Time h1,Time h2, Tipo_Elemento t){
		double lim=t.getLim_tiempo();
		//Time h1=r.getHora_ini();
		//Time h2=r.getHora_fin();
		double h3=(h2.getTime()-h1.getTime())/1000/3600;
		//System.out.print(h3);
		//System.out.print(lim);
		
		
		if(lim>=h3 || lim==0)return true;
		else return false;
		
		
	}



public ArrayList<Reserva> getPendientes(Persona p,Tipo_Elemento ti) throws Exception{
	DataReserva dr=new DataReserva();
	ArrayList<Reserva> resXUs=new ArrayList<Reserva>();
	for(Reserva r: dr.getAllPendientes()){
		if(r.getPersona().getIdpersona() == p.getIdpersona()&& r.getElemento().getTipo_Elem().getIdtipo_elemento()==ti.getIdtipo_elemento())
		{resXUs.add(r);}
	}
	return resXUs;
}
	
public int cambiarEstado(Reserva r) throws Exception
{
	PreparedStatement stmt=null;
	int ok=0;

		try {
		stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
				"update reservas set estado=? where id_reserva=?",
				PreparedStatement.RETURN_GENERATED_KEYS
				);
		stmt.setString(1,"cancelada");
		stmt.setInt(2, r.getId_reserva());
		stmt.executeUpdate();
		ok=1;
		} catch (SQLException | AppDataException e) 
		{
			ok=0;
 			throw e;
 			
 		}
 		try {
 			if(stmt!=null)stmt.close();
 			FactoryConexion.getInstancia().releaseConn();
 			
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 		
 		return ok;
}
	
}
