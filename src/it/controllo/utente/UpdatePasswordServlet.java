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
 * Servlet implementation class UpdatePasswordServlet
 */
public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(!request.getParameter("password1").equals(request.getParameter("password2"))) {
			request.getRequestDispatcher("/account.jsp").forward(request, response);
			return;
		}
		
		HttpSession session = request.getSession();
		IDAOUtente daoUtente = new DAOUtente();
		Utente oldPwd = new Utente();
		Utente newPwd = new Utente();
		Map<String,String> errore = new HashMap<String,String>();
		
		if(session.getAttribute("ERRORE") != null) {
			errore = (HashMap<String,String>) session.getAttribute("ERRORE");
		}
		
		oldPwd.setId((Long) session.getAttribute("idUtente"));
		oldPwd.hashPassword(request.getParameter("password"));
		
		try {
			if(!daoUtente.verificaPwd(oldPwd)) {
				errore.put("password", "La vecchia password non � corretta");
				session.setAttribute("ERRORE", errore);
				response.sendRedirect("./accountUtente?#ERRORE");
			}
		} catch (DAOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		newPwd.setId(oldPwd.getId());
		newPwd.hashPassword(request.getParameter("password1"));

		
		try {
			daoUtente.updatePassword(oldPwd, newPwd);
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		if(!response.isCommitted()) {
			response.sendRedirect("populateHomeUtente");
		}
	}

}
