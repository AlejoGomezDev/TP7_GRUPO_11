package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.SeguroDao;
import dominio.TipoSeguro;
import dominio.TipoSeguroDao;
import dominio.segurosDto;

/**
 * Servlet implementation class ServletListar
 */
@WebServlet("/servletListar")
public class servletListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TipoSeguroDao daoTipo;
    /**
     * Default constructor. 
     */
    public servletListar() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Obtener los tipos se seguro
		TipoSeguroDao daoTipo = new TipoSeguroDao(); 
		ArrayList<TipoSeguro> listaTipos = daoTipo.obtenerTodos();
		System.out.println("Tamaño de listaTipos: " + listaTipos.size());
		request.setAttribute("listaTipos", listaTipos);
		RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");
		rd.forward(request, response);
		
		/*
		 * //MOSTRAR LOS TIPOS DE SEGUROS
		daoTipo = new TipoSeguroDao();
		ArrayList<TipoSeguro> listaTipos = new ArrayList<TipoSeguro>();
		listaTipos = daoTipo.obtenerTodos();
		
		request.setAttribute("listaTipos",listaTipos);

		
		//OBTENER EL VALUE DEL TIPO DE SEGURO
		int idTipo = Integer.parseInt(request.getParameter("filtro"));
		SeguroDao segurosDao = new SeguroDao();
		ArrayList<segurosDto> listaSeguro = new ArrayList<segurosDto>();
		
		RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");   
		rd.forward(request, response);
		
		if(idTipo == 0) {
			listaSeguro = segurosDao.obtenerSeguros();
		
			request.setAttribute("listaSeguro", listaSeguro);
		}

		
		if(request.getParameter("btnFiltrar") != null) {

			listaSeguro = segurosDao.obtenerSegurosFiltrado(idTipo);

			request.setAttribute("listaSeguro", listaSeguro);
			
			rd.forward(request, response);
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

}
