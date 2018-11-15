package it.controllo.amministratore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DAOUtenteAdmin daoUtenteAdmin = new DAOUtenteAdmin();
		
		int gruppiCreati = 0;
		int utentiRegistrati = 0;
		Double percentualeUtentiAbilitati = 0.0;
		Double percentualeGruppiCompletati = 0.0;
		List<String[]> popolaritaAttivitaGruppiCompletati = new ArrayList<String[]>();
		List<String[]> partecipazioneUtentiAiGruppi = new ArrayList<String[]>();
		
		try {	
			utentiRegistrati = daoUtenteAdmin.contaUtenti();
			percentualeUtentiAbilitati = daoUtenteAdmin.percentualeUtentiAbilitati();
			gruppiCreati = daoUtenteAdmin.contaGruppi();
			percentualeGruppiCompletati = daoUtenteAdmin.percentualeGruppiCompletati();
			popolaritaAttivitaGruppiCompletati = daoUtenteAdmin.popolaritaAttivitaCompleto();
			partecipazioneUtentiAiGruppi = daoUtenteAdmin.partecipazioneUtentiAiGruppi();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("utentiRegistrati", utentiRegistrati);	
		request.setAttribute("percentualeUtentiAbilitati", percentualeUtentiAbilitati);	
		request.setAttribute("gruppiCreati", gruppiCreati);	
		request.setAttribute("percentualeGruppiCompletati", percentualeGruppiCompletati);	
		request.setAttribute("popolaritaAttivitaGruppiCompletati", popolaritaAttivitaGruppiCompletati);	
		request.setAttribute("partecipazioneUtentiAiGruppi", partecipazioneUtentiAiGruppi);	
		
		request.getRequestDispatcher("/amministratore/homeAmministratore.jsp").forward(request, response);

	}
}