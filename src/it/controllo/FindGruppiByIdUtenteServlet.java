package it.controllo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.modello.IscrizioneGruppo;
import it.persistenza.implementazione.DAOException;
import it.persistenza.implementazione.DAOIscrizioneGruppo;
import it.persistenza.interfaccia.IDAOIscrizioneGruppo;

/**
 * Servlet implementation class FindGruppiByIdUtenteServlet
 */
public class FindGruppiByIdUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindGruppiByIdUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IDAOIscrizioneGruppo daoIscrizioneGruppo = new DAOIscrizioneGruppo();
		List<IscrizioneGruppo> listaIscrizioneGruppi = new ArrayList<IscrizioneGruppo>();
		Long id = Long.parseLong(request.getParameter("id_utente"));
		
		
		try {
			listaIscrizioneGruppi = daoIscrizioneGruppo.findGruppiByIdUtente(id);
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
		request.setAttribute("listaIscrizioneGruppi", listaIscrizioneGruppi);
		request.getRequestDispatcher("provaServlet.jsp?xxx=1").forward(request, response);
	}
}
