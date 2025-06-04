package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dominio.TipoSeguroDao;

@WebServlet("/servletAgregar")
public class servletAgregar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TipoSeguroDao dao;
    
    public servletAgregar() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao = new TipoSeguroDao();
		
		
		request.setAttribute("tipos",dao.obtenerTodos());
		RequestDispatcher ds = request.getRequestDispatcher("/AgregarSeguro.jsp");
		ds.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
