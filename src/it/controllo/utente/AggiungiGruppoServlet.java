package it.controllo.utente;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.modello.Gruppo;
import it.modello.Utente;
import it.persistenza.implementazione.DAOException;
import it.persistenza.implementazione.DAOGruppo;
import it.persistenza.implementazione.DAOUtente;
import it.persistenza.interfaccia.IDAOGruppo;
import it.persistenza.interfaccia.IDAOUtente;

/**
 * Servlet implementation class AggiungiGruppoServlet
 */

public class AggiungiGruppoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiGruppoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	IDAOGruppo daoGruppo = new DAOGruppo();

    	
    	Gruppo gruppo = new Gruppo();
//		HttpSession session = request.getSession();
		
		Long id = (Long) request.getSession().getAttribute("idUtente");  // abbiamo recuperato l'ID dell'utente dalla sessione che viene creata con il login
    	gruppo.setIdUtente(id);
    	gruppo.setIdAttivita(Long.parseLong(request.getParameter("attivita")));
    	try {
			gruppo.setData(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(request.getParameter("data")));
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	gruppo.setDescrizione(request.getParameter("descrizione"));
    	
    	try {
    		daoGruppo.add(gruppo);

    	} catch (DAOException e) {
    		e.printStackTrace();
    	}

    	response.sendRedirect("./gestioneGruppi");
    }

}
