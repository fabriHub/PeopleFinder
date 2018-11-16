package it.controllo.filtri;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.persistenza.implementazione.DAOUtenteAdmin;

/**
 * Servlet Filter implementation class FiltroRegistrazione
 */
public class FiltroAggiungiAttivita implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroAggiungiAttivita() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		Map<String,String> errore = new HashMap<String,String>();
		
		if(session.getAttribute("ERRORE") != null) {
			session.removeAttribute("ERRORE");
		}
		
		System.out.println(httpRequest.getAttributeNames());
		
		if (httpRequest.getParameter("nome") == null || httpRequest.getParameter("nome").isEmpty()) {
			errore.put("nome", "Inserisci un'attività");
		}
		
		if (httpRequest.getParameter("numeroPartecipanti") == null || httpRequest.getParameter("numeroPartecipanti").isEmpty()) {
			errore.put("numeroPartecipanti", "Scegli un numero di partecipanti");
		} else {
			if(!DAOUtenteAdmin.validateNumero(httpRequest.getParameter("numeroPartecipanti"))) {
				errore.put("numeroPartecipanti", "Inserire un numero valido");
			}
		}
		
		if (!errore.isEmpty()) {
			session.setAttribute("ERRORE", errore);
			httpResponse.sendRedirect("./findAllAttivita?#ERRORE");
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
