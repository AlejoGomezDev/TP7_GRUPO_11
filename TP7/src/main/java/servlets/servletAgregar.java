package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Seguro;
import dominio.SeguroDao;
import dominio.TipoSeguro;
import dominio.TipoSeguroDao;

@WebServlet("/servletAgregar")
public class servletAgregar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TipoSeguroDao daoTipo;
	SeguroDao daoSeguro;
	
    public servletAgregar() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		daoTipo = new TipoSeguroDao();
		ArrayList<TipoSeguro> listaTipos = new ArrayList<TipoSeguro>();
		listaTipos = daoTipo.obtenerTodos();
		
		daoSeguro = new SeguroDao();
		int proximoId = daoSeguro.obtenerProximoId();
		
		request.setAttribute("proximoID",proximoId);
		request.setAttribute("listaTipos",listaTipos);
		RequestDispatcher ds = request.getRequestDispatcher("/AgregarSeguro.jsp");
		
		ds.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int filas = 0;
		//Si se hizo click en agregar
		if(request.getParameter("btnAgregarSeguro") != null) {
			
			//obtenemos todo lo del form 
			String descripcion = request.getParameter("txtDescripcion");
		    String tipo = request.getParameter("ddlTipos");
		    String costo = request.getParameter("txtCosto");
		    String costoMaximo = request.getParameter("txtCostoMaximo");

		    //creamos un booleano en false y un mensaje de error vacio para ir llenando
		    boolean hayErrores = false;
		    String mensajeError = "";
		    
		    if(descripcion == null || descripcion.trim().isEmpty()) {
		        mensajeError += "* La descripción es obligatoria.<br>";
		        hayErrores = true;
		    }

		    if(tipo == null || tipo.trim().isEmpty()) {
		        mensajeError += "* Debe seleccionar un tipo de seguro.<br>";
		        hayErrores = true;
		    }

		    if(costo == null || costo.trim().isEmpty()) {
		        mensajeError += "* El costo de contratación es obligatorio.<br>";
		        hayErrores = true;
		    }
		    
		    if(costo != null && NaN(costo.trim())){
		        mensajeError += "* El costo de contratación debe estar formado solo por números.<br>";
		        hayErrores = true;
		    }

		    if(costoMaximo == null || costoMaximo.trim().isEmpty()) {
		        mensajeError += "* El costo máximo asegurado es obligatorio.<br>";
		        hayErrores = true;
		    }
		    
		    if(costoMaximo != null && NaN(costoMaximo.trim())){
		        mensajeError += "* El costo máximo debe estar formado solo por números.<br>";
		        hayErrores = true;
		    }
		    
		    
		    if(hayErrores) {
		    	//SI HAY ERRORES SETEAMOS EL MENSAJE DE ERROR A LA REQUEST
		    	request.setAttribute("mensajeError", mensajeError);
		    }else {
		    	//SI NO HAY ERRORES...INSERTAR
		    	
		    	//Creamos instancia de Seguro
		    	Seguro seg = new Seguro();
		    	seg.setIdTipo(Integer.parseInt(tipo));
		    	seg.setDescripcion(descripcion);
		    	seg.setCostoAsegurado(Integer.parseInt(costoMaximo));
		    	seg.setCostoContratacion(Integer.parseInt(costo));
		    	
		    	//obtenemos las filas
		    	filas = daoSeguro.agregarSeguro(seg);	
		    	
		    	//SETEAMOS LAS FILAS A LA REQUEST
		    	request.setAttribute("cantFilas", filas);
		    }
		    
		}
		//DISPATCHER
		RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");
		
        //SETEAMOS LOS TIPOS DE SEGURO Y EL ID
        ArrayList<TipoSeguro> tipos = daoTipo.obtenerTodos(); 
        int proximoId = daoSeguro.obtenerProximoId();

        request.setAttribute("listaTipos", tipos);
        request.setAttribute("proximoID", proximoId);
        
        //MANDAMOS LA REQUEST
        rd.forward(request, response);
	}

	public boolean NaN(String texto) {
	    try {
	        Integer.parseInt(texto);
	        return false;
	    } catch (NumberFormatException e) {
	        return true;
	    }
	}
	
}
