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
		
		System.out.println(utenteTmp);
		
		try {
			utente = daoUtente.loginUtente(utenteTmp);
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(utente != null) {
			System.out.println("utente esistente");
			HttpSession session = request.getSession();
			session.setAttribute("idUtente", utente.getId());
			session.setAttribute("isAmministratore", utente.getAmministratore());
//			request.getRequestDispatcher("homeUtente.jsp").forward(request, response);
			response.sendRedirect("homeUtente.jsp");
		} else {
			response.sendRedirect("./index.jsp?#ERRORE");
		}
	}

}
