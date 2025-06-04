package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
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
	/*private String pass = "root";*/
	private String pass = "13121401";//password alejo
	/*private String dbName = "SegurosGroup";*/
	private String dbName = "segurosgroup"; //name alej
	
	protected Connection connection;
	
	public ArrayList<Seguro> obtenerSeguros() {
		// TODO Auto-generated method stub
		return null;
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
	
	
}
