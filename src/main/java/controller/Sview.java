package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Giocatore;
import repository.DaoGiocatore;
import repository.DaoSquadra;

/**
 * Servlet implementation class SZeroPoint
 */
@WebServlet("/Sview")
public class Sview extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoSquadra daoSquadra = DaoSquadra.get_instance();
	DaoGiocatore daoGiocatore = DaoGiocatore.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch(Integer.parseInt(request.getParameter("scelta"))) {
		case 1:
			request.setAttribute("squadra", daoSquadra.getSquadra(Integer.parseInt(request.getParameter("id"))));
			request.setAttribute("giocatori", daoGiocatore.getGiocatoribyID(Integer.parseInt(request.getParameter("id"))));
			request.getRequestDispatcher("overview.jsp").forward(request, response);
			break;
		case 2:
			request.setAttribute("giocatori", daoGiocatore.getGiocatoribyID(100));
			request.setAttribute("squadre", daoSquadra.getSquadre());
			request.getRequestDispatcher("modificaSvincolati.jsp").forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(Integer.parseInt(request.getParameter("idGiocatore")));
		System.out.println(Integer.parseInt(request.getParameter("squadre")));
		daoGiocatore.updateSvincolato(Integer.parseInt(request.getParameter("idGiocatore")),Integer.parseInt(request.getParameter("squadre")));
		response.sendRedirect("Sview?scelta=2");
	}
}
