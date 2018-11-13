package it.controllo.utente;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
		Utente utente = new Utente();
		
		utenteTmp.setMail(request.getParameter("mail"));
		utenteTmp.hashPassword(request.getParameter("password"));
		
		
		try {
			utente = daoUtente.loginUtente(utenteTmp);
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		if(utente != null) {
			session.setAttribute("idUtente", utente.getId());
			session.setAttribute("isAmministratore", utente.getAmministratore());
			if (utente.getAmministratore() == 1) {
				response.sendRedirect("statistiche");
			} else {
				response.sendRedirect("populateHomeUtente");
			}
		} else {
			Map<String,String> errore = new HashMap<String,String>();
			errore.put("login", "Email o password errate");
			session.setAttribute("ERRORE", errore);
			response.sendRedirect("./index.jsp?#ERRORE");
		}
	}

}
