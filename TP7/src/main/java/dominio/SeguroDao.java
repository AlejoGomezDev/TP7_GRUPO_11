package dominio;

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
	private String dbName = "SegurosGroup";
	
	public ArrayList<Seguro> obtenerSeguros() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<TipoSeguro> obtenerTipos() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
