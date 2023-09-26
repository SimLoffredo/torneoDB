package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.DaoGiocatore;
import repository.DaoSquadra;

/**
 * Servlet implementation class SZeroPoint
 */
@WebServlet("/SZeroPoint")
public class SZeroPoint extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoSquadra daoSquadra = DaoSquadra.get_instance();
    DaoGiocatore daoGiocatore = DaoGiocatore.getInstance();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("squadre", daoSquadra.getSquadre());
		request.getRequestDispatcher("homepage.jsp").forward(request, response);
	}

	
}
