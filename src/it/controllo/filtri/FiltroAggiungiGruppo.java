package it.controllo.filtri;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

/**
 * Servlet Filter implementation class FiltroRegistrazione
 */
public class FiltroAggiungiGruppo implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroAggiungiGruppo() {
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
		
		if (httpRequest.getParameter("attivita") == null || httpRequest.getParameter("attivita").isEmpty()) {
			errore.put("attivita", "Scegli un'attività");
		}
		
		if (httpRequest.getParameter("data") == null || httpRequest.getParameter("data").isEmpty()) {
			errore.put("data", "Scegli una data");
		} else
			try {
				if(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(request.getParameter("data")).before(new Date())) {
					errore.put("data", "Inserire una data valida");
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		
		if (httpRequest.getParameter("descrizione") == null || httpRequest.getParameter("descrizione").isEmpty()) {
			errore.put("descrizione", "Inserire una descrizione");
		}
		if (!errore.isEmpty()) {
			session.setAttribute("ERRORE", errore);
			httpResponse.sendRedirect("./gestioneGruppi?#ERRORE");
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
