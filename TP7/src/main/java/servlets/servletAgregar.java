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
		
		request.setAttribute("listaTipos",listaTipos);
		request.setAttribute("proximoID",proximoId);
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
		    
		    //Instancia de Seguro
		    Seguro seg = new Seguro();
		    seg.setIdTipo(Integer.parseInt(tipo));
		    seg.setDescripcion(descripcion);
		    seg.setCostoAsegurado(Integer.parseInt(costoMaximo));
		    seg.setCostoContratacion(Integer.parseInt(costo));
		    
		    //Instancia de SeguroDAO
		    SeguroDao segdao = new SeguroDao();
		    
		    
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

		    if(costoMaximo == null || costoMaximo.trim().isEmpty()) {
		        mensajeError += "* El costo máximo asegurado es obligatorio.<br>";
		        hayErrores = true;
		    }
		    
		    if(hayErrores) {
		    	//si hay errores mandamos un mensaje de error
		    	request.setAttribute("mensajeError", mensajeError);
		    	
		        //mandar los tipos y el id para que no se rompan
		        ArrayList<TipoSeguro> tipos = daoTipo.obtenerTodos(); 
		        int proximoId = daoSeguro.obtenerProximoId();

		        request.setAttribute("listaTipos", tipos);
		        request.setAttribute("proximoID", proximoId);
		    	
		    	
		        request.getRequestDispatcher("AgregarSeguro.jsp").forward(request, response);
		        return;
		    }
		    
		    //SI NO HAY ERRORES...INSERTAR
		    filas = segdao.agregarSeguro(seg);
		}
		//REDISPATCHER
		request.setAttribute("cantFilas", filas);
		RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");
		rd.forward(request, response);
	}

}
