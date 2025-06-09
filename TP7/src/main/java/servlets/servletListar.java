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

		//Obtener los tipos de seguro y cargar el DDL
		TipoSeguroDao daoTipo = new TipoSeguroDao(); 
		ArrayList<TipoSeguro> listaTipos = daoTipo.obtenerTodos();
		request.setAttribute("listaTipos", listaTipos);

		SeguroDao segurosDao = new SeguroDao();
		ArrayList<Seguro> listaSeguro = null;
		
		//Ver si hay algun filtro
		String filtro = request.getParameter("filtro");
		String botonPresionado = request.getParameter("btnFiltrar");
		
		//Si se presiona el boton...
		if(botonPresionado != null && filtro != null) {
		
			if(filtro.equals("todos")) {
				
			}else {
				int idTipo = Integer.parseInt(filtro);
				listaSeguro = segurosDao.obtenerSegurosFiltrado(idTipo);
			}	
		}else {
			listaSeguro = segurosDao.obtenerSeguros();
		}
		 request.setAttribute("listaSeguro", listaSeguro);
		 RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");
		 rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

}
