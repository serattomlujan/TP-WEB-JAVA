package data;
 import java.util.ArrayList;
import java.sql.*;

import util.AppDataException;
import entity.*;
 

public class DataPersona {
	
	public ArrayList<Persona> getAll() throws Exception{
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Persona> pers= new ArrayList<Persona>();
		try {
		 	stmt = FactoryConexion.getInstancia().getConn().createStatement();
		 	rs = stmt.executeQuery("select * from reservas.personas p "
		 			+ "inner join reservas.categorias c on p.id_categoria=c.id_categoria order by apellido");
		 	if(rs!=null){
		 		while(rs.next()){
		 			Persona p=new Persona();
		 			p.setCategoria(new Categoria());
		 			p.setIdpersona(rs.getInt("idpersona"));
		 			p.setNombre(rs.getString("nombre"));
		 			p.setApellido(rs.getString("apellido"));
		 			p.setDni(rs.getString("dni"));
		 			p.setHabilitado(rs.getBoolean("habilitado"));
		 			p.setUsuario(rs.getString("usuario"));
		 			p.setContrasenia(rs.getString("contrasenia"));
		 			p.getCategoria().setId_categoria(rs.getInt("id_categoria"));
		 			p.getCategoria().setDescripcion(rs.getString("descripcion"));
		 			pers.add(p);
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
				
 		return pers;
 		}
		 	
		public Persona getByDni(Persona per) throws Exception{
		 		Persona p=null;
		 		PreparedStatement stmt=null;
		 		ResultSet rs=null;
		 		try {
		 			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
		 					"select idpersona, nombre, apellido, dni, habilitado, p.id_categoria, "
		 					+ "c.descripcion, usuario, contrasenia from personas p "
		 					+ "inner join categorias c on p.id_categoria=c.id_categoria where dni=?");
		 			stmt.setString(1, per.getDni());
		 			rs=stmt.executeQuery();
		 			if(rs!=null && rs.next()){
		 					p=new Persona();
		 					p.setCategoria(new Categoria());
		 					p.setIdpersona(rs.getInt("idpersona"));
		 					p.setNombre(rs.getString("nombre"));
		 					p.setApellido(rs.getString("apellido"));
		 					p.setDni(rs.getString("dni"));
		 					p.setHabilitado(rs.getBoolean("habilitado"));
		 					p.setUsuario(rs.getString("usuario"));
				 			p.setContrasenia(rs.getString("contrasenia"));
		 					p.getCategoria().setId_categoria(rs.getInt("id_categoria"));
		 					p.getCategoria().setDescripcion(rs.getString("descripcion"));
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
				
		 return p;
		}
		 	
		public void add(Persona p) throws Exception{
		 		PreparedStatement stmt=null;
		 		ResultSet keyResultSet=null;
		 		try {
		 			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
		 					"insert into personas(dni, nombre, apellido, habilitado, id_categoria,usuario,contrasenia) "
		 					+ "values (?,?,?,?,?,?,?)",
		 					PreparedStatement.RETURN_GENERATED_KEYS
		 					);
		 			stmt.setString(1, p.getDni());
		 			stmt.setString(2, p.getNombre());
		 			stmt.setString(3, p.getApellido());
		 			stmt.setBoolean(4, p.getHabilitado());
		 			stmt.setInt(5, p.getCategoria().getId_categoria());
		 			stmt.setString(6, p.getUsuario());
		 			stmt.setString(7, p.getContrasenia());
		 			stmt.executeUpdate();
		 			keyResultSet=stmt.getGeneratedKeys();
		 			if(keyResultSet!=null && keyResultSet.next()){
		 				p.setIdpersona(keyResultSet.getInt(1));
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
		
		public void remove(Persona p) throws Exception{
	 		PreparedStatement stmt=null;
	 		System.out.println(p.getDni());
	 		try {
	 			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
	 					"delete from personas where dni=?"
	 					);
	 			stmt.setString(1, p.getDni());
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
		
		public Persona getLogedUser(Persona per) throws Exception{
			Persona p=null;
			PreparedStatement stmt=null;
			ResultSet rs=null;
			try {
				//stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					//	"select p.id, nombre, apellido, dni, habilitado, categoriaId, descripcion from persona p inner join categoria c on p.categoriaId=c.id where user=? and pass=?");
				stmt=FactoryConexion.getInstancia().getConn().prepareStatement(""
						+ "	select idpersona, nombre, apellido, dni, habilitado, p.id_categoria, descripcion from personas p inner join categorias c on p.id_categoria=c.id_categoria where p.usuario =? and p.contrasenia= ?"); 
				stmt.setString(1, per.getUsuario());
				stmt.setString(2, per.getContrasenia());
				rs=stmt.executeQuery();
				if(rs!=null && rs.next()){
						p=new Persona();
						p.setCategoria(new Categoria());
						p.setIdpersona(rs.getInt("idpersona"));
						p.setNombre(rs.getString("nombre"));
						p.setApellido(rs.getString("apellido"));
						p.setDni(rs.getString("dni"));
						p.setHabilitado(rs.getBoolean("habilitado"));
						p.getCategoria().setId_categoria(rs.getInt("id_categoria"));
						p.getCategoria().setDescripcion(rs.getString("descripcion"));
				}
				
			} catch (Exception e) {
				throw e;
			} finally{
				try {
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();
					FactoryConexion.getInstancia().releaseConn();
				} catch (SQLException e) {
					throw e;
				}
			}

			return p;
		}
	 		
		
		public void modificar(Persona p) throws Exception{
	 		PreparedStatement stmt=null;
	 		
	 		try {
	 			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
	 					"update personas set dni=?, nombre=?, apellido=?, habilitado=?, "
	 					+ "id_categoria=?, usuario=?,contrasenia=? where idpersona=?"
	 					);
	 			stmt.setString(1, p.getDni());
	 			stmt.setString(2, p.getNombre());
	 			stmt.setString(3, p.getApellido());
	 			stmt.setBoolean(4, p.getHabilitado());
	 			stmt.setInt(5, p.getCategoria().getId_categoria());
	 			stmt.setString(6, p.getUsuario());
	 			stmt.setString(7, p.getContrasenia());
	 			stmt.setInt(8, p.getIdpersona());
	 			stmt.executeUpdate();
	 				 			 			
	 		}catch (SQLException | AppDataException e) {
	 			throw e;
	 		}
	 		try {
	 			if(stmt!=null)stmt.close();
	 			FactoryConexion.getInstancia().releaseConn();		
	 		
	 			
	 			
	 		} catch (SQLException e) {
	 			e.printStackTrace();
	 		}
	 	}
		
		public Persona getById(Persona per) throws Exception{
	 		Persona p=null;
	 		PreparedStatement stmt=null;
	 		ResultSet rs=null;
	 		try {
	 			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
	 					"select idpersona, nombre, apellido, dni, habilitado, p.id_categoria, "
	 					+ "c.descripcion, usuario, contrasenia from personas p "
	 					+ "inner join categorias c on p.id_categoria=c.id_categoria where id=?");
	 			stmt.setString(1, per.getDni());
	 			rs=stmt.executeQuery();
	 			if(rs!=null && rs.next()){
	 					p=new Persona();
	 					p.setCategoria(new Categoria());
	 					p.setIdpersona(rs.getInt("idpersona"));
	 					p.setNombre(rs.getString("nombre"));
	 					p.setApellido(rs.getString("apellido"));
	 					p.setDni(rs.getString("dni"));
	 					p.setHabilitado(rs.getBoolean("habilitado"));
	 					p.setUsuario(rs.getString("usuario"));
			 			p.setContrasenia(rs.getString("contrasenia"));
	 					p.getCategoria().setId_categoria(rs.getInt("id_categoria"));
	 					p.getCategoria().setDescripcion(rs.getString("descripcion"));
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
			
	 return p;
	}
	
}		 		 
		 
		
	
	
	
	
	
	
	

