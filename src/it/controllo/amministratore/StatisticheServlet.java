package it.controllo.amministratore;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.modello.Attivita;
import it.modello.Gruppo;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DAOUtenteAdmin daoUtenteAdmin = new DAOUtenteAdmin();
		
		int utentiRegistrati = 0;
		Double percentualeUtentiAbilitati = 0.0;
		Double percentualeUtentiDisabilitati = 0.0;
		int gruppiCreati = 0;
		Double percentualeGruppiCompletati = 0.0;
		Double percentualeGruppiNonCompletati = 0.0;
		Map<Attivita, Double> popolaritaAttivitaGruppiCompletati = new LinkedHashMap<Attivita, Double>();
		Map<Attivita, Double> popolaritaAttivitaGruppiNonCompletati = new LinkedHashMap<Attivita, Double>();
		Map<Long, Double> partecipazioneUtentiAiGruppi = new LinkedHashMap<Long, Double>();
		
		try {	
			utentiRegistrati = daoUtenteAdmin.contaUtenti();
			percentualeUtentiAbilitati = daoUtenteAdmin.percentualeUtentiAbilitati();
			percentualeUtentiDisabilitati = daoUtenteAdmin.percentualeUtentiDisabilitati();
			gruppiCreati = daoUtenteAdmin.contaGruppi();
			percentualeGruppiCompletati = daoUtenteAdmin.percentualeGruppiCompletati();
			percentualeGruppiNonCompletati = daoUtenteAdmin.percentualeGruppiNonCompletati();
			popolaritaAttivitaGruppiCompletati = daoUtenteAdmin.popolaritaAttivitaCompleto();
			popolaritaAttivitaGruppiNonCompletati = daoUtenteAdmin.popolaritaAttivitaNonCompleto();
			partecipazioneUtentiAiGruppi = daoUtenteAdmin.partecipazioneUtentiAiGruppi();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("utentiRegistrati", utentiRegistrati);	
		request.setAttribute("percentualeUtentiAbilitati", percentualeUtentiAbilitati);	
		request.setAttribute("percentualeUtentiDisabilitati", percentualeUtentiDisabilitati);	
		request.setAttribute("gruppiCreati", gruppiCreati);	
		request.setAttribute("percentualeGruppiCompletati", percentualeGruppiCompletati);	
		request.setAttribute("percentualeGruppiNonCompletati", percentualeGruppiNonCompletati);	
		request.setAttribute("popolaritaAttivitaGruppiCompletati", popolaritaAttivitaGruppiCompletati);	
		request.setAttribute("popolaritaAttivitaGruppiNonCompletati", popolaritaAttivitaGruppiNonCompletati);	
		request.setAttribute("partecipazioneUtentiAiGruppi", partecipazioneUtentiAiGruppi);	
		
		
		request.getRequestDispatcher("provaServlet.jsp?xxx=1").forward(request, response);

	}
}