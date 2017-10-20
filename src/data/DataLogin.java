package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Categoria;
import entity.Persona;

public class DataLogin {

	 	
	public Persona getUsuario(Persona us) throws Exception{
 		Persona u=null;
 		PreparedStatement stmt=null;
 		ResultSet rs=null;
 		try {
 			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("select idpersona, dni, nombre, apellido,"
 					+ "usuario, contrasenia, habilitado, p.id_categoria, c.descripcion"
		 			+ " from personas p inner join categorias c on "
		 			+ "c.id_categoria=p.id_categoria where usuario=? and contrasenia=?");
 			stmt.setString(1, us.getUsuario());
 			stmt.setString(2, us.getContrasenia());
 			rs=stmt.executeQuery();
 			if(rs!=null && rs.next()){
 					u=new Persona();
 					u.setCategoria(new Categoria());
 					u.setIdpersona(rs.getInt("idpersona"));
 					u.setDni(rs.getString("dni"));
 					u.setNombre(rs.getString("nombre"));
 					u.setApellido(rs.getString("apellido"));
 					u.setUsuario(rs.getString("usuario"));
 					u.setContrasenia(rs.getString("contrasenia"));
 					u.setHabilitado(rs.getBoolean("habilitado"));
 					u.getCategoria().setId_categoria(rs.getInt("p.id_categoria"));
 					u.getCategoria().setDescripcion(rs.getString("descripcion"));
 					 					
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
		return u;
		
	}
 		
}
