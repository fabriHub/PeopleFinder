package it.controllo;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DAOUtenteAdmin daoUtenteAdmin = new DAOUtenteAdmin();
		
		Gruppo gruppo = null;

		Double utentiRegistrati = 0.0;
		Double utentiAbilitati = 0.0;
		Double percentualeUtentiAbilitati = 0.0;
		Double gruppiCreati = 0.0;
		Double gruppiCompletati = 0.0;
		Double gruppiNonCompletati = 0.0;
		Double percentualeGruppiCompletati = 0.0;
		Double percentualePopAttivitaCompl = 0.0;
		Double percentualePopAttivitaNonCompl = 0.0;
		Double percentualePartecipazioneUtentiAiGruppi = 0.0;
		Map<Attivita, Integer> mappa = null;
		Map<Attivita, Integer> mappa2 = null;
		Map<Long, Integer> mappa3 = null;
		Integer valore = 0;
		Attivita attivita = null;
		Long idGruppo = 0L;
		Map<Attivita, Double> mappaConPercentuale = new LinkedHashMap<Attivita, Double>();
		Map<Attivita, Double> mappaConPercentuale2 = new LinkedHashMap<Attivita, Double>();
		Map<Long, Double> mappaConPercentuale3 = new LinkedHashMap<Long, Double>();
		
		try {	
			// Per visualizzare la percentuale di utenti abilitati
			utentiRegistrati = daoUtenteAdmin.contaUtenti();
			utentiAbilitati = daoUtenteAdmin.contaUtentiAbilitati();
			percentualeUtentiAbilitati = (100*utentiAbilitati)/utentiRegistrati;
			
			// Per visualizzare la percentuale di gruppi completati
			gruppiCreati = daoUtenteAdmin.contaGruppi();
			gruppiCompletati = daoUtenteAdmin.contaGruppiCompletati();
			gruppiNonCompletati = daoUtenteAdmin.contaGruppiNonCompletati();
			percentualeGruppiCompletati = (100*gruppiCompletati)/gruppiCreati;
			
			// Per visualizzare la classifica di popolarità delle attività completate
			mappa = daoUtenteAdmin.popolaritaAttivitaCompleto();
			for(Map.Entry<Attivita, Integer> entry : mappa.entrySet()) {
				attivita = (Attivita) entry.getKey();
				valore = (Integer) entry.getValue(); 
				percentualePopAttivitaCompl = (100*valore)/gruppiCompletati;
				mappaConPercentuale.put(attivita, percentualePopAttivitaCompl);
			}

			// Per visualizzare la classifica di popolarità delle attività non completate
			mappa2 = daoUtenteAdmin.popolaritaAttivitaNonCompleto();
			for(Map.Entry<Attivita, Integer> entry2 : mappa2.entrySet()) {
				attivita = (Attivita) entry2.getKey();
				valore = (Integer) entry2.getValue(); 
				percentualePopAttivitaNonCompl = (100*valore)/gruppiNonCompletati;
				mappaConPercentuale2.put(attivita, percentualePopAttivitaNonCompl);
			}	
			
			// Per visualizzare la percentuale di partecipazione in ciascun gruppo
			mappa3 = daoUtenteAdmin.partecipazioneUtentiAiGruppi();
			for(Map.Entry<Long, Integer> entry3 : mappa3.entrySet()) {
				idGruppo = (Long) entry3.getKey();
				valore = entry3.getValue(); 
				percentualePartecipazioneUtentiAiGruppi = (100*valore)/attivita.getNumeroPartecipanti();
				mappaConPercentuale3.put(idGruppo, percentualePartecipazioneUtentiAiGruppi);
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
	
		request.setAttribute("percentualeUtentiAbilitati", percentualeUtentiAbilitati);
		request.setAttribute("percentualeGruppiCompletati", percentualeGruppiCompletati);
		request.setAttribute("popolaritaAttivitaCompleto", mappaConPercentuale);
		request.setAttribute("popolaritaAttivitaNonCompleto", mappaConPercentuale2);
		request.setAttribute("percentualePartecipazioneUtentiAiGruppi", mappaConPercentuale3);	
		
		request.getRequestDispatcher("provaServlet.jsp?xxx=1").forward(request, response);
	}
}
