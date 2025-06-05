package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SeguroDao {

	/** BLOQUE PARA CADA FUNCION 
	 try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  **/
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	//private String pass = "13121401";//password alejo
	private String dbName = "SegurosGroup";
	//private String dbName = "segurosgroup"; //name alejo
	
	protected Connection connection;
	
	public ArrayList<segurosDto> obtenerSeguros() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(host+dbName,user,pass);
		}catch(Exception e) {
			e.printStackTrace();
		}
		ArrayList<segurosDto> listaSeguros = new ArrayList<segurosDto>();
		String query = "SELECT idSeguro, seguros.descripcion AS descSeguro, tiposeguros.descripcion AS descTipo,"
				+ " costoContratacion, costoAsegurado FROM seguros INNER JOIN tiposeguros"
				+ " ON seguros.idTipo = tiposeguros.idTipo";
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
			  segurosDto seguro = new segurosDto();
			  seguro.setIdSeguro(rs.getInt("idSeguro"));
			  seguro.setDescripcion(rs.getString("descSeguro"));
			  seguro.setDescTipo(rs.getString("descTipo"));
			  seguro.setCostoContratacion(rs.getFloat("costoContratacion"));
			  seguro.setCostoAsegurado(rs.getFloat("costoAsegurado"));
			  
			  listaSeguros.add(seguro);
			}
			
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listaSeguros;
	}
	
	public ArrayList<TipoSeguro> obtenerTipos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int obtenerProximoId() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(host+dbName,user,pass);
		}catch(Exception e) {
			e.printStackTrace();
		}	
		
		String query="SELECT MAX(idSeguro) FROM seguros";	
		int proximoSeguro = 0;
				
			try {
			Statement st =	connection.createStatement();
			ResultSet rs = st.executeQuery(query);
		
			    while(rs.next()) {
			    	proximoSeguro = rs.getInt(1);
			    }
			    connection.close();			
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
			}
			return proximoSeguro + 1;
		}
	
	public int agregarSeguro(Seguro seg) {
		 try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 int filas_afectadas = 0;
		 String query = "INSERT INTO seguros (descripcion, idTipo, costoContratacion, costoAsegurado) " +
	               "VALUES (?, ?, ?, ?)";
		 
		 Connection cn = null;
		 
			try
			{
				cn = DriverManager.getConnection(host+dbName, user,pass);
				PreparedStatement pst = cn.prepareStatement(query);	
				
			    pst.setString(1, seg.getDescripcion());
			    pst.setInt(2, seg.getIdTipo());
			    pst.setDouble(3, seg.getCostoContratacion());
			    pst.setDouble(4, seg.getCostoAsegurado());
			    
				filas_afectadas= pst.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		 
		 return filas_afectadas;
	}
}
