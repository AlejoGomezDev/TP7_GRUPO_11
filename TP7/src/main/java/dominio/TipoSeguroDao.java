package dominio;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;

public class TipoSeguroDao {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	/*private String pass = "root";*/
	private String pass = "13121401"; //pass alejo
	/*private String dbName = "SegurosGroup";*/
	private String dbName = "segurosgroup"; //name alejo
	protected Connection connection;
	
	
public ArrayList<TipoSeguro> obtenerTodos() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection(host+dbName,user,pass);
	}catch(Exception e) {
		e.printStackTrace();
	}	
	
	String query="SELECT * FROM tiposeguros";	
	ArrayList<TipoSeguro> listaTipos = new ArrayList<TipoSeguro>();
			
		try {
		Statement st =	connection.createStatement();
		ResultSet rs = st.executeQuery(query);
	
		    while(rs.next()) {
		    	TipoSeguro tipo = new TipoSeguro();
		    	tipo.setId(rs.getInt(1));
		    	tipo.setDescripcion(rs.getString(2));
		    	
		    	listaTipos.add(tipo);
		    }
		    connection.close();			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		}
		return listaTipos;
	}
}
