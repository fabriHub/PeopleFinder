package it.controllo.utente;

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
 * Servlet implementation class FindUtentiByIdGruppoServlet
 */
public class FindUtentiByIdGruppoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindUtentiByIdGruppoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IDAOIscrizioneGruppo daoIscrizioneGruppo = new DAOIscrizioneGruppo();
		List<IscrizioneGruppo> listaUtentiIscrizioneGruppi = new ArrayList<IscrizioneGruppo>();
		Long id = Long.parseLong(request.getParameter("id_gruppo"));
		
		
		try {
			listaUtentiIscrizioneGruppi = daoIscrizioneGruppo.findUtentiByIdGruppo(id);
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
		request.setAttribute("listaUtentiIscrizioneGruppi", listaUtentiIscrizioneGruppi);
		request.getRequestDispatcher("provaServlet.jsp?xxx=1").forward(request, response);
	}
	

}
