package it.controllo.utente;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
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
 * Servlet implementation class UpdateGruppoServlet
 */

public class CaricaUpdateGruppoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CaricaUpdateGruppoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IDAOGruppo daoGruppo = new DAOGruppo();
		IDAOAttivita daoAttivita = new DAOAttivita();
		List<Attivita> attivita = new ArrayList<Attivita>();
		Gruppo gruppo = new Gruppo();
		
		try {
			attivita = daoAttivita.findAllAbilitate();
			gruppo = daoGruppo.findById(Long.parseLong(request.getParameter("idGruppo")));
		} catch (NumberFormatException | DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("attivita", attivita);
		request.setAttribute("gruppo", gruppo);
		request.getRequestDispatcher("/utente/updateGruppo.jsp").forward(request,response);
	}

	}


