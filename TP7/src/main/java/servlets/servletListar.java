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
import dominio.segurosDto;

/**
 * Servlet implementation class ServletListar
 */
@WebServlet("/Listar")
public class servletListar extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		int idTipo = Integer.parseInt(request.getParameter("filtro"));
		SeguroDao segurosDao = new SeguroDao();
		ArrayList<segurosDto> listaSeguro = new ArrayList<segurosDto>();
		ArrayList<TipoSeguro> listaTipo = new ArrayList<TipoSeguro>();
		RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");   
		
		if(request.getParameter("btnFiltrar") != null) {
			listaSeguro = segurosDao.obtenerSegurosFiltrado(idTipo);
			
			listaTipo =	segurosDao.obtenerTipos();
			
			request.setAttribute("listaTipos", listaTipo);
			request.setAttribute("listaSeguro", listaSeguro);
			
			rd.forward(request, response);
		}
		else {
			listaSeguro = segurosDao.obtenerSeguros();
			

			listaTipo =	segurosDao.obtenerTipos();
			
			request.setAttribute("listaTipos", listaTipo);
			request.setAttribute("listaSeguro", listaSeguro);

			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

}
