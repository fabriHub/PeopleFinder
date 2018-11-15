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
 * Servlet Filter implementation class FiltroCampiVuotiLogin
 */

public class FiltroLogin implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroLogin() {
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
			errore.put("mail", "inserire la mail");
		}
		
		if (httpRequest.getParameter("password").isEmpty()) {
			errore.put("password", "inserire la password");
		}
		
		if (!errore.isEmpty()) {
			
			session.setAttribute("ERRORE", errore);
			httpResponse.sendRedirect("./index.jsp?#ERRORE");
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
