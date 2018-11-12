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
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.persistenza.implementazione.DAOUtente;

/**
 * Servlet Filter implementation class FiltroDuePassword
 */
public class FiltroDuePassword implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroDuePassword() {
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
			errore = (HashMap<String,String>) session.getAttribute("ERRORE");
		}
		
		if (!httpRequest.getParameter("password1").equals(httpRequest.getParameter("password2"))) {
			errore.put("password", "le due password devono coincidere");
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
