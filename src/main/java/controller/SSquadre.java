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
 * Servlet implementation class SSquadre
 */
@WebServlet("/SSquadre")
public class SSquadre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoSquadra daoSquadra = DaoSquadra.get_instance();
	DaoGiocatore daoGiocatore = DaoGiocatore.getInstance();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch(Integer.parseInt(request.getParameter("scelta"))) {
		case 1: //	Lista Squadre
			request.setAttribute("squadre", daoSquadra.getSquadre());
			request.getRequestDispatcher("tabellaSquadre.jsp").forward(request, response);
			break;
		case 2://elimina
			daoGiocatore.svincolaGiocatori(Integer.parseInt(request.getParameter("id")));
			daoSquadra.eliminaSquadra(Integer.parseInt(request.getParameter("id")));
			response.sendRedirect("SSquadre?scelta=1");
			break;
		case 3://singola squadra
			System.out.println(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("squadra", daoSquadra.getSquadra(Integer.parseInt(request.getParameter("id"))));
			request.getRequestDispatcher("modificaSquadra.jsp").forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch(Integer.parseInt(request.getParameter("scelta"))) {
		case 1: //Inserimento
			String nomeSquadra = request.getParameter("nome");
			daoSquadra.addSquadra(nomeSquadra);
			response.sendRedirect("SSquadre?scelta=1");
			break;
		case 2:// modifica
			String squadraUpdate = request.getParameter("nome");
			daoSquadra.modificaSquadra(squadraUpdate, Integer.parseInt(request.getParameter("id")));
			response.sendRedirect("SSquadre?scelta=1");
			break;
		}
	}

}
