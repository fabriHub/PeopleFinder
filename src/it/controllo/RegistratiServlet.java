package it.controllo;

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
 * Servlet implementation class LoginServlet
 */

public class RegistratiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistratiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!request.getParameter("password1").equals(request.getParameter("password2"))) {
			request.getRequestDispatcher("registrazione.jsp?errore=1").forward(request, response);
		}
		
		IDAOUtente daoUtente = new DAOUtente();
		Utente utente = null;
		
////		utenteTmp.setMail(request.getParameter("email"));
////		utenteTmp.hashPassword(request.getParameter("password"));
//		
//		try {
////			utente = daoUtente.loginUtente(utenteTmp);
//			
//		} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		if(utente != null) {
//			HttpSession session = request.getSession();
//			session.setAttribute("idUtente", utente.getId());
//			session.setAttribute("isAmministratore", utente.getAmministratore());
//			request.getRequestDispatcher("prova.html").forward(request, response);
//		}
		response.sendRedirect("./index.jsp?errore=1");
	}

}
