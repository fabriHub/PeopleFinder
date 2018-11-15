package it.controllo.utente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.modello.Attivita;
import it.persistenza.implementazione.DAOAttivita;
import it.persistenza.implementazione.DAOException;
import it.persistenza.implementazione.DAOGruppo;
import it.persistenza.interfaccia.IDAOAttivita;
import it.persistenza.interfaccia.IDAOGruppo;

/**
 * Servlet implementation class GestioneGruppiServlet
 */
public class GestioneGruppiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestioneGruppiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IDAOGruppo daoGruppo = new DAOGruppo();
		IDAOAttivita daoAttivita = new DAOAttivita();
		List<String[]> gruppi = new ArrayList<String[]>();
		List<Attivita> attivita = new ArrayList<Attivita>();
		Long id = (Long) request.getSession().getAttribute("idUtente");
		
		
		
		try {
			gruppi = daoGruppo.findAllGestioneGruppi(id);
			attivita = daoAttivita.findAllAbilitate();
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("attivita", attivita);
		request.setAttribute("gruppi", gruppi);
		request.getRequestDispatcher("/utente/gestioneGruppi.jsp").forward(request, response);
		
	}

	

}
