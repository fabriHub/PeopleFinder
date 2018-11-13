package it.controllo.utente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.modello.Utente;
import it.persistenza.implementazione.DAOException;
import it.persistenza.implementazione.DAOUtente;
import it.persistenza.interfaccia.IDAOUtente;

/**
 * Servlet implementation class UpdateUtenteServlet
 */

public class UpdateUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		IDAOUtente daoUtente = new DAOUtente();
		Utente utente = new Utente();
		utente.setId((Long) session.getAttribute("idUtente"));
		utente.setMail(request.getParameter("mail"));
		utente.setTelefono(request.getParameter("telefono"));
		utente.setNickname(request.getParameter("nickname"));
		
		
		try {
			daoUtente.update(utente);
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("provaServlet.jsp?id=22");
	}

}
