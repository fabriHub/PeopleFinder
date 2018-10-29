package it.controllo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.modello.IscrizioneGruppo;
import it.persistenza.implementazione.DAOException;
import it.persistenza.implementazione.DAOIscrizioneGruppo;
import it.persistenza.interfaccia.IDAOIscrizioneGruppo;

/**
 * Servlet implementation class AggiungiIscrizioneGruppoServlet
 */

public class AggiungiIscrizioneGruppoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiIscrizioneGruppoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IDAOIscrizioneGruppo daoIscrizioneGruppo = new DAOIscrizioneGruppo();
		Long idUtente = Long.parseLong(request.getParameter("id_utente"));
		Long idGruppo = Long.parseLong(request.getParameter("id_gruppo"));
		IscrizioneGruppo iscrizioneGruppo = new IscrizioneGruppo();
		iscrizioneGruppo.setIdUtente(idUtente);
		iscrizioneGruppo.setIdGruppo(idGruppo);
		
		try {
			
			daoIscrizioneGruppo.add(iscrizioneGruppo);
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("provaServlet.jsp?xxx=1");
	}

}
