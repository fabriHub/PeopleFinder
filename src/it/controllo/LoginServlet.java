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
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IDAOUtente daoUtente = new DAOUtente();
		Utente utenteTmp = new Utente();
		Utente utente = null;
		
		utenteTmp.setMail(request.getParameter("email"));
		utenteTmp.hashPassword(request.getParameter("password"));
		
		try {
			utente = daoUtente.loginUtente(utenteTmp);
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(utente != null) {
			HttpSession session = request.getSession();
			session.setAttribute("idUtente", utente.getId());
			session.setAttribute("isAmministratore", utente.getAmministratore());
			request.getRequestDispatcher("prova.jsp").forward(request, response);
		}
		response.sendRedirect("./index.jsp?errore=1");
	}

}
