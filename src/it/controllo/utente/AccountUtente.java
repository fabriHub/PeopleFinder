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
 * Servlet implementation class PopulateHomeUtenteServlet
 */
public class AccountUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountUtente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IDAOUtente daoUtente = new DAOUtente();
//		List<String[]> listaGruppi = new ArrayList<String[]>();
		Utente utente = null;
		String[] stringa = null;
		
		Long id = (Long) request.getSession().getAttribute("idUtente");
		
		try {
			
			utente = daoUtente.findById(id);
			stringa = new String[4];
			stringa[0] = String.valueOf(id);
			stringa[1] = utente.getMail();
			stringa[2] = utente.getNickname();
			stringa[3] = utente.getTelefono();
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("datiUtente", stringa);
		request.getRequestDispatcher("/utente/account.jsp").forward(request, response);
	}
}
