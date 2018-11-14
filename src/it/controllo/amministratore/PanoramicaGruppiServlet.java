package it.controllo.amministratore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.modello.Gruppo;
import it.persistenza.implementazione.DAOException;
import it.persistenza.implementazione.DAOGruppo;
import it.persistenza.interfaccia.IDAOGruppo;

/**
 * Servlet implementation class FindAllUtentiServlet
 */

public class PanoramicaGruppiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PanoramicaGruppiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IDAOGruppo daoGruppo = new DAOGruppo();
		List<String[]> gruppi = new ArrayList<String[]>();

		try {
			gruppi = daoGruppo.panoramicaGruppi();
			
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("panoramicaGruppi", gruppi);
		request.getRequestDispatcher("/amministratore/panoramicaGruppi.jsp").forward(request, response);
	}
		
	}

