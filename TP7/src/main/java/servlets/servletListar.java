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

		SeguroDao segurosDao = new SeguroDao();
		ArrayList<Seguro> listaSeguro = new ArrayList<Seguro>();
		listaSeguro = segurosDao.obtenerSeguros();
		
		ArrayList<TipoSeguro> listaTipo = new ArrayList<TipoSeguro>();
		listaTipo =	segurosDao.obtenerTipos();
		
		request.setAttribute("listaTipos", listaTipo);
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
