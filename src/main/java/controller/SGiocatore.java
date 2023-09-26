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

@WebServlet("/SGiocatore")
public class SGiocatore extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoGiocatore daoGiocatore = DaoGiocatore.getInstance();
	DaoSquadra daoSquadra = DaoSquadra.get_instance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch(Integer.parseInt(request.getParameter("scelta"))) {
		case 1: //Lista squadre per Inserimento
			request.setAttribute("squadre", daoSquadra.getSquadre());
			request.getRequestDispatcher("inserimentoGiocatore.jsp").forward(request, response);
			break;
		case 2: //Lista per visualizzazione
			request.setAttribute("giocatori",daoGiocatore.getGiocatori());
			request.setAttribute("squadre", daoSquadra.getSquadre());
			request.getRequestDispatcher("tabellaGiocatori.jsp").forward(request, response);
			break;
		case 3:// Elimina
			daoGiocatore.deleteGiocatore(Integer.parseInt(request.getParameter("id")));
			response.sendRedirect("SGiocatore?scelta=2");
			break;
		case 4:// Singolo giocatore & squadra
			request.setAttribute("giocatore", daoGiocatore.getGiocatore(Integer.parseInt(request.getParameter("idGiocatore"))));
			request.setAttribute("squadre", daoSquadra.getSquadre());
			
			request.getRequestDispatcher("modificaGiocatore.jsp").forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch(Integer.parseInt(request.getParameter("scelta"))) {
		case 1: // Inserimento
			Giocatore giocatore = new Giocatore();
			giocatore.setNome(request.getParameter("nome"));
			giocatore.setCognome(request.getParameter("cognome"));
			giocatore.setnMaglia(Integer.parseInt(request.getParameter("numMaglia")));
			String data = request.getParameter("date");
			giocatore.setDataNascita(Date.valueOf(data));
			System.out.println(request.getParameter("squadre"));
			giocatore.setId_squadra(Integer.parseInt(request.getParameter("squadre")));
			daoGiocatore.addGiocatore(giocatore);
			response.sendRedirect("SGiocatore?scelta=2");
			break;
		case 2:// Modifica
			Giocatore giocatoreUpdate = new Giocatore();
			giocatoreUpdate.setId(Integer.parseInt(request.getParameter("idGiocatore")));
			giocatoreUpdate.setNome(request.getParameter("nome"));
			giocatoreUpdate.setCognome(request.getParameter("cognome"));
			giocatoreUpdate.setnMaglia(Integer.parseInt(request.getParameter("nMaglia")));
			String dataUpdate = request.getParameter("date");
			giocatoreUpdate.setDataNascita(Date.valueOf(dataUpdate));
			giocatoreUpdate.setId_squadra(Integer.parseInt(request.getParameter("squadre")));
			daoGiocatore.updateGiocatore(giocatoreUpdate);
			response.sendRedirect("SGiocatore?scelta=2");
			break;
		}
	}

}
