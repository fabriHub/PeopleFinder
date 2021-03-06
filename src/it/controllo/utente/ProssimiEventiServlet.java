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
 * Servlet implementation class GestioneGruppiServlet
 */
public class ProssimiEventiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProssimiEventiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IDAOIscrizioneGruppo daoIscrizioneGruppo = new DAOIscrizioneGruppo();
		List<String[]> gruppi = new ArrayList<String[]>();
		Long id = (Long) request.getSession().getAttribute("idUtente");
		
		try {
			gruppi = daoIscrizioneGruppo.findAllTuoiGruppi(id);
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("prossimiEventi", gruppi);
		request.getRequestDispatcher("/utente/prossimiEventi.jsp").forward(request, response);
		
	}

	

}
