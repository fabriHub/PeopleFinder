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
	
		// Per visualizzare la percentuale di utenti abilitati
		DAOUtenteAdmin daoUtenteAdmin = new DAOUtenteAdmin();
		Double utenti = 0.0;
		Double utentiAbilitati = 0.0;
		Double percentuale = 0.0;
		
		try {
			utenti = daoUtenteAdmin.contaUtenti();
			utentiAbilitati = daoUtenteAdmin.contaUtentiAbilitati();
			percentuale = (100*utentiAbilitati)/utenti;
			
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		
		// Per visualizzare la percentuale di gruppi completati
		
		
		request.setAttribute("percentualeUtentiAbilitati", percentuale);
		request.getRequestDispatcher("provaServlet.jsp?xxx=1").forward(request, response);
	
	}

}
