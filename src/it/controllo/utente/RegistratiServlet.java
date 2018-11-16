package it.controllo.utente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.modello.Utente;
import it.persistenza.implementazione.DAOException;
import it.persistenza.implementazione.DAOUtente;
import it.persistenza.interfaccia.IDAOUtente;

/**
 * Servlet implementation class RegistratiServlet
 */
//@WebServlet("/RegistratiServlet")
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
		
		IDAOUtente daoUtente = new DAOUtente();
		
		Utente utente = new Utente();
		utente.setMail(request.getParameter("mail"));
		utente.setTelefono(request.getParameter("telefono"));	
		utente.setNickname(request.getParameter("nickname"));
		
		try {
			if(daoUtente.existsUtente(utente)) {
				request.getRequestDispatcher("registrati.jsp?#ERRORE").forward(request, response);
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		utente.hashPassword(request.getParameter("password1"));

		try {
			daoUtente.add(utente);
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("./index.jsp");
		
	}

}
