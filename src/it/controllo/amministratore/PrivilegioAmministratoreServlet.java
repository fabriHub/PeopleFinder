package it.controllo.amministratore;

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

/**
 * Servlet implementation class PrivilegioAmministratoreServlet
 */
public class PrivilegioAmministratoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrivilegioAmministratoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOUtenteAdmin daoUtenteAdmin = new DAOUtenteAdmin();
		DAOUtente daoUtente = new DAOUtente();
		Utente utente = new Utente();
		Long id = Long.parseLong(request.getParameter("idUtente"));
		
    	try {
    		utente = daoUtente.findById(id);
    		if (utente.getAmministratore() == 0) {
    			daoUtenteAdmin.rendiAmministratore(id);
    		} else {
    			daoUtenteAdmin.escludiAmministratore(id);
    		}
		} catch (DAOException e) {
			e.printStackTrace();
		}
    	
    	response.sendRedirect("./findAllUtenti");
	}

	

}
