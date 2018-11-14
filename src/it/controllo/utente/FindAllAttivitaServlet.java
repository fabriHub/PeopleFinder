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
import it.persistenza.interfaccia.IDAOAttivita;

/**
 * Servlet implementation class FindAllAttivitaServlet
 */

public class FindAllAttivitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllAttivitaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IDAOAttivita daoAttivita = new DAOAttivita();
		List<Attivita> allAttivita = new ArrayList<Attivita>();
		
		try {
			allAttivita = daoAttivita.findAll();
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
		request.setAttribute("listaAttivita", allAttivita);
		request.getRequestDispatcher("/amministratore/gestioneAttivita.jsp").forward(request, response);
	}


}
