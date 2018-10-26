package it.controllo;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.modello.Attivita;
import it.modello.Gruppo;
import it.persistenza.implementazione.DAOAttivita;
import it.persistenza.implementazione.DAOException;
import it.persistenza.implementazione.DAOGruppo;
import it.persistenza.interfaccia.IDAOAttivita;
import it.persistenza.interfaccia.IDAOGruppo;

/**
 * Servlet implementation class AggiungiAttivitaServlet
 */
public class AggiungiAttivitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiAttivitaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	IDAOAttivita daoAttivita = new DAOAttivita();

    	Attivita attivita = new Attivita();
    	attivita.setNome(request.getParameter("nome"));
    	attivita.setNumeroPartecipanti(Integer.parseInt(request.getParameter("numero_partecipanti")));

    	try {
    		daoAttivita.add(attivita);

    	} catch (DAOException e) {
    		e.printStackTrace();
    	}

    	response.sendRedirect("./provaServlet.jsp");
    }

}
