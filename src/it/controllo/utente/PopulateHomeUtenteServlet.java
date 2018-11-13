package it.controllo.utente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.persistenza.implementazione.DAOException;
import it.persistenza.implementazione.DAOIscrizioneGruppo;
import it.persistenza.interfaccia.IDAOIscrizioneGruppo;

/**
 * Servlet implementation class PopulateHomeUtenteServlet
 */
public class PopulateHomeUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopulateHomeUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IDAOIscrizioneGruppo daoIscrizioneGruppo = new DAOIscrizioneGruppo();
		List<String[]> listaGruppi = new ArrayList<String[]>();
		
		Long id = (Long) request.getSession().getAttribute("idUtente");
		
		try {
			listaGruppi = daoIscrizioneGruppo.findGruppiHomeByIdUtente(id);
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("listaGruppi", listaGruppi);
		request.getRequestDispatcher("/utente/homeUtente.jsp").forward(request, response);
	}
}
