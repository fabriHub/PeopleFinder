package it.controllo.amministratore;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.modello.Attivita;
import it.persistenza.implementazione.DAOAttivita;
import it.persistenza.implementazione.DAOException;
import it.persistenza.implementazione.DAOUtenteAdmin;

/**
 * Servlet implementation class AbilitazioneAttivitaServlet
 */
public class AbilitazioneAttivitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AbilitazioneAttivitaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOUtenteAdmin daoUtenteAdmin = new DAOUtenteAdmin();
		DAOAttivita daoAttivita = new DAOAttivita();
		Attivita attivita = new Attivita();
		Long id = Long.parseLong(request.getParameter("idAttivita"));
		
    	try {
    		attivita = daoAttivita.findById(id);
    		if (attivita.getAbilitata() == 0) {
    			daoUtenteAdmin.abilitaAttivita(id);
    		} else {
    			daoUtenteAdmin.disabilitaAttivita(id);
    		}
		} catch (DAOException e) {
			e.printStackTrace();
		}
    	
    	response.sendRedirect("./findAllAttivita");
	
	}

}
