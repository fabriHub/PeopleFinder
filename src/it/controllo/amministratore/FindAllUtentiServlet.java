package it.controllo.amministratore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.modello.Utente;
import it.persistenza.implementazione.DAOException;
import it.persistenza.implementazione.DAOUtente;
import it.persistenza.interfaccia.IDAOUtente;

/**
 * Servlet implementation class FindAllUtentiServlet
 */

public class FindAllUtentiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllUtentiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IDAOUtente daoUtente = new DAOUtente();
		List<Utente> utenti = new ArrayList<Utente>();

		try {
			utenti = daoUtente.findAll();
			
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("listaUtenti", utenti);
		request.getRequestDispatcher("/amministratore/gestioneUtenti.jsp").forward(request, response);
	}
		
	}

