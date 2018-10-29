package it.controllo;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.modello.Gruppo;
import it.persistenza.implementazione.DAOException;
import it.persistenza.implementazione.DAOGruppo;
import it.persistenza.interfaccia.IDAOGruppo;

/**
 * Servlet implementation class UpdateGruppoServlet
 */

public class UpdateGruppoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateGruppoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IDAOGruppo daoGruppo = new DAOGruppo();
		Gruppo gruppo = new Gruppo();
		gruppo.setId(Long.parseLong(request.getParameter("id")));
		gruppo.setDescrizione(request.getParameter("descrizione"));
		gruppo.setData(new Date(Integer.parseInt(request.getParameter("anno_evento"))-1900, Integer.parseInt(request.getParameter("mese_evento"))-1, Integer.parseInt(request.getParameter("giorno_evento")), Integer.parseInt(request.getParameter("ora_evento")), Integer.parseInt(request.getParameter("minuti_evento"))));
		
		
		try {
			daoGruppo.update(gruppo);
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("provaServlet.jsp?id=44");
	}

	}


