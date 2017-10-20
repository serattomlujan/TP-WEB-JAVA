package data;
import java.util.ArrayList;


import java.sql.*;

import util.AppDataException;
import entity.*;


public class DataTipoElemento {
	
	public ArrayList<Tipo_Elemento> getAll() throws Exception{

		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Tipo_Elemento> tipos= new ArrayList<Tipo_Elemento>();
		try{
			stmt = FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from tipo_elemento order by nombre_tipo");
			if(rs!=null){
				while(rs.next()){
					Tipo_Elemento t=new Tipo_Elemento();
					t.setIdtipo_elemento(rs.getInt("idtipo_elemento"));
					t.setNombre_tipo(rs.getString("nombre_tipo"));
					t.setCant_max(rs.getInt("cant_max"));
					t.setLim_tiempo(rs.getInt("lim_tiempo"));
					t.setDias_anticip(rs.getInt("dias_anticip"));
					t.setEncargado(rs.getBoolean("encargado"));
					tipos.add(t);
					}
				}
			} catch (Exception e){
				throw e;
			}
			
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return tipos;
		}
	
	public Tipo_Elemento getByNomTipo(Tipo_Elemento te) throws Exception{
 		Tipo_Elemento t=null;
 		PreparedStatement stmt=null;
 		ResultSet rs=null;
 		try {
 			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
 					"select * from tipo_elemento where nombre_tipo=?");
 			stmt.setString(1, te.getNombre_tipo());
 			rs=stmt.executeQuery();
 			if(rs!=null && rs.next()){
 					t=new Tipo_Elemento();
 					t.setIdtipo_elemento(rs.getInt("idtipo_elemento"));
 					t.setNombre_tipo(rs.getString("nombre_tipo"));
  					t.setCant_max(rs.getInt("cant_max"));
 					t.setLim_tiempo(rs.getInt("lim_tiempo"));
 					t.setDias_anticip(rs.getInt("dias_anticip"));
 					t.setEncargado(rs.getBoolean("encargado"));
 			}
 			
} catch (Exception e) {
throw e;
}
finally{
try {
if(rs!=null)rs.close();
if(stmt!=null)stmt.close();
FactoryConexion.getInstancia().releaseConn();
} catch (SQLException e) {
throw e;
	}
 }
		
 return t;
}
	public void add(Tipo_Elemento t) throws Exception{
 		PreparedStatement stmt=null;
 		ResultSet keyResultSet=null;
 		try {
 			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
 					"insert into tipo_elemento(nombre_tipo, cant_max, lim_tiempo, dias_anticip, encargado) "
 					+ "values (?,?,?,?,?)",
 					PreparedStatement.RETURN_GENERATED_KEYS
 					);
 			stmt.setString(1, t.getNombre_tipo());
 			stmt.setInt(2, t.getCant_max());
 			stmt.setInt(3, t.getLim_tiempo());
 			stmt.setInt(4, t.getDias_anticip());
 			stmt.setBoolean(5, t.getEncargado());
 			stmt.executeUpdate();
 			keyResultSet=stmt.getGeneratedKeys();
 			if(keyResultSet!=null && keyResultSet.next()){
 				t.setIdtipo_elemento((keyResultSet.getInt(1)));
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
 		

	public void remove(Tipo_Elemento t) throws Exception{
 		PreparedStatement stmt=null;
 			try {
 			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
 					"delete from tipo_elemento where nombre_tipo=?"
 					
 					);
 			stmt.setString(1, t.getNombre_tipo());
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
	
	public void update(Tipo_Elemento t) throws Exception{
 		PreparedStatement stmt=null;
 		
 		try {
 			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
 					"update tipo_elemento "
 					+ "set nombre_tipo=?, cant_max=?, lim_tiempo=?, dias_anticip=?, encargado=? "
 					+ "where idtipo_elemento=?"
 					
 					);
 			stmt.setString(1, t.getNombre_tipo());
 			stmt.setInt(2, t.getCant_max());
 			stmt.setInt(3, t.getLim_tiempo());
 			stmt.setInt(4, t.getDias_anticip());
 			stmt.setBoolean(5, t.getEncargado());
 			stmt.setInt(6, t.getIdtipo_elemento());
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
	
	public ArrayList<Tipo_Elemento> getAllEncargado() throws Exception{

		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Tipo_Elemento> tipos= new ArrayList<Tipo_Elemento>();
		try{
			stmt = FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from tipo_elemento where encargado=false order by nombre_tipo");
			if(rs!=null){
				while(rs.next()){
					Tipo_Elemento t=new Tipo_Elemento();
					t.setIdtipo_elemento(rs.getInt("idtipo_elemento"));
					t.setNombre_tipo(rs.getString("nombre_tipo"));
					t.setCant_max(rs.getInt("cant_max"));
					t.setLim_tiempo(rs.getInt("lim_tiempo"));
					t.setDias_anticip(rs.getInt("dias_anticip"));
					//t.setEncargado(rs.getBoolean("encargado"));
					tipos.add(t);
					}
				}
			} catch (Exception e){
				throw e;
			}
			
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return tipos;
		}
}
