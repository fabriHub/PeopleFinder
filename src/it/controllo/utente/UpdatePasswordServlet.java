package it.controllo.utente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		if(!request.getParameter("newPwd").equals(request.getParameter("newPwd1"))) {
			request.getRequestDispatcher("#").forward(request, response);
			return;
		}
		
		IDAOUtente daoUtente = new DAOUtente();
		Utente oldPwd = new Utente();
		Utente newPwd = new Utente();
		Utente newPwd1 = new Utente();
		
		oldPwd.setId(Long.parseLong(request.getParameter("id")));
		oldPwd.hashPassword(request.getParameter("oldPwd"));
		newPwd.setId(oldPwd.getId());
		newPwd.hashPassword(request.getParameter("newPwd"));
		newPwd1.hashPassword(request.getParameter("newPwd1"));

		
		try {
			daoUtente.updatePassword(oldPwd, newPwd);
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("provaServlet.jsp?id="+newPwd.getId().toString());
	}

}
