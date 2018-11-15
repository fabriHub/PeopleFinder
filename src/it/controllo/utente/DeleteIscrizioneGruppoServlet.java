package it.controllo.utente;

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
 * Servlet implementation class DeleteIscrizioneGruppoServlet
 */
public class DeleteIscrizioneGruppoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteIscrizioneGruppoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IDAOIscrizioneGruppo daoIscrizioneGruppo = new DAOIscrizioneGruppo();
		Long idGruppo = Long.parseLong(request.getParameter("idGruppo"));
		Long idUtente = (Long) request.getSession().getAttribute("idUtente");
		
		IscrizioneGruppo iscrizioneGruppo = new IscrizioneGruppo();
		
		iscrizioneGruppo.setIdGruppo(idGruppo);
		iscrizioneGruppo.setIdUtente(idUtente);
		
		try {
			daoIscrizioneGruppo.disiscriviti(iscrizioneGruppo);
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("./prossimiEventi");
	}

}
