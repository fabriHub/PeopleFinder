package it.controllo.filtri;

import java.io.IOException;
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

import it.persistenza.implementazione.DAOUtente;

/**
 * Servlet Filter implementation class FiltroRegistrazione
 */
public class FiltroRegistrazione implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroRegistrazione() {
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
		
		if (httpRequest.getParameter("mail").isEmpty()) {
			errore.put("mail", "Inserire la mail");
		} else if(!DAOUtente.validateMail(httpRequest.getParameter("mail"))) {
			errore.put("mail", "Inserire una mail valida");
		}
		
		if (httpRequest.getParameter("telefono").isEmpty()) {
			errore.put("telefono", "Inserire il numero di telefono");
		} else if(!DAOUtente.validateTelefono(httpRequest.getParameter("telefono"))) {
			errore.put("telefono", "Inserire un numero di telefono valido");
		}
		
		if (httpRequest.getParameter("nickname").isEmpty()) {
			errore.put("nickname", "Inserire il nickname");
		}
		
		if (!httpRequest.getParameter("password1").equals(httpRequest.getParameter("password2"))) {
			errore.put("password", "Le due password devono coincidere");
		}
		
		if (!errore.isEmpty()) {
			session.setAttribute("ERRORE", errore);
			httpResponse.sendRedirect("./registrati.jsp?#ERRORE");
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
