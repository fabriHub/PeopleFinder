package it.controllo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.modello.Gruppo;
import it.modello.Utente;
import it.persistenza.implementazione.DAOException;
import it.persistenza.implementazione.DAOGruppo;
import it.persistenza.implementazione.DAOUtente;
import it.persistenza.interfaccia.IDAOGruppo;
import it.persistenza.interfaccia.IDAOUtente;

/**
 * Servlet implementation class FindAllGruppoServlet
 */
public class FindAllGruppoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllGruppoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			IDAOGruppo daoGruppo = new DAOGruppo();
			List<Gruppo> gruppi = new ArrayList<Gruppo>();
			
			try {
				gruppi = daoGruppo.findAll();
				
			} catch (DAOException e) {
				e.printStackTrace();
			}
			request.setAttribute("listaGruppi", gruppi);
			request.getRequestDispatcher("provaServlet.jsp?xxx=1").forward(request, response);
		}

}
