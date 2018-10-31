package it.controllo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.persistenza.implementazione.DAOException;
import it.persistenza.implementazione.DAOUtenteAdmin;

/**
 * Servlet implementation class PercentualeUtentiAbilitatiServlet
 */
public class StatisticheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatisticheServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DAOUtenteAdmin daoUtenteAdmin = new DAOUtenteAdmin();

		// Per visualizzare la percentuale di utenti abilitati
		Double utentiRegistrati = 0.0;
		Double utentiAbilitati = 0.0;
		Double percentualeUtentiAbilitati = 0.0;
		try {
			utentiRegistrati = daoUtenteAdmin.contaUtenti();
			utentiAbilitati = daoUtenteAdmin.contaUtentiAbilitati();
			percentualeUtentiAbilitati = (100*utentiAbilitati)/utentiRegistrati;
		} catch (DAOException e) {
			e.printStackTrace();
		}
		request.setAttribute("percentualeUtentiAbilitati", percentualeUtentiAbilitati);
		
		
		// Per visualizzare la percentuale di gruppi completati
		Double gruppiCreati = 0.0;
		Double gruppiCompletati = 0.0;
		Double percentualeGruppiCompletati = 0.0;
		try {
			gruppiCreati = daoUtenteAdmin.contaGruppi();
			gruppiCompletati = daoUtenteAdmin.contaGruppiCompletati();
			percentualeGruppiCompletati = (100*gruppiCompletati)/gruppiCreati;
		} catch (DAOException e) {
			e.printStackTrace();
		}
		request.setAttribute("percentualeGruppiCompletati", percentualeGruppiCompletati);
		
		
		// Per visualizzare la classifica di popolarità delle attività 
		
		
		
		
		request.getRequestDispatcher("provaServlet.jsp?xxx=1").forward(request, response);
		
	
	}
}
