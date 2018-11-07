package it.controllo.utente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.modello.Gruppo;
import it.persistenza.implementazione.DAOException;
import it.persistenza.implementazione.DAOGruppo;
import it.persistenza.interfaccia.IDAOGruppo;

/**
 * Servlet implementation class FindGruppiByIdUtenteServlet
 */

public class FindByIdUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindByIdUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IDAOGruppo daoGruppo = new DAOGruppo();
		List<Gruppo> gruppi = new ArrayList<Gruppo>();
		Long id = Long.parseLong(request.getParameter("id_utente"));
		
		
		try {
			gruppi = daoGruppo.findByIdUtente(id);
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
		request.setAttribute("listaGruppi", gruppi);
		request.getRequestDispatcher("provaServlet.jsp?xxx=1").forward(request, response);
	}

}
