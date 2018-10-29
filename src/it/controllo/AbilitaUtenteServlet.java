package it.controllo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.modello.Utente;
import it.persistenza.implementazione.DAOException;
import it.persistenza.implementazione.DAOUtente;
import it.persistenza.implementazione.DAOUtenteAdmin;
import it.persistenza.interfaccia.IDAOUtente;

/**
 * Servlet implementation class AbilitaUtenteServlet
 */
public class AbilitaUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AbilitaUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	DAOUtenteAdmin daoUtenteAdmin = new DAOUtenteAdmin();

    	Long id = Long.parseLong(request.getParameter("id_utente"));
    	
    	try {
			daoUtenteAdmin.abilita(id);
		} catch (DAOException e) {
			e.printStackTrace();
		}
    	
    	response.sendRedirect("provaServlet.jsp?xxx=1");
    }

}
