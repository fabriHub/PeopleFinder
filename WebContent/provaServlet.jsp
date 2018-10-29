<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.modello.Gruppo" %>
<%@ page import="it.persistenza.interfaccia.IDAOGruppo" %>
<%@ page import="it.persistenza.implementazione.DAOGruppo" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p>prova servlet</p>

<p>Output</p>

	<% 
		IDAOGruppo daoGruppo = new DAOGruppo();
		out.println = request.getParameter("id");
		Long id = Long.parseLong(request.getParameter("id"));
		Gruppo gruppo = new Gruppo();
		gruppo = daoGruppo.findById(id);
		Integer anno = gruppo.getData().getYear() + 1900;
		Integer mese = gruppo.getData().getMonth() + 1;
	%>
	

<form method="POST" action="updateGruppo">
	
	<input type="text" name="id" value="<%= gruppo.getId() %>"/>
	<input type="text" name="anno_evento" value="<%= anno %>"/>
	<input type="text" name="mese_evento" value="<%= mese %>"/>
	<input type="text" name="giorno_evento" value="<%= gruppo.getData().getDate() %>"/>
	<input type="text" name="ora_evento" value="<%= gruppo.getData().getHours() %>"/>
	<input type="text" name="minuti_evento" value="<%= gruppo.getData().getMinutes() %>"/>
	<input type="text" name="descrizione" value="<%= gruppo.getDescrizione() %>"/>
	
	
	<input type="submit" value="modifica"/>
</form>

<a href="findAllUtenti">link servlet</a>

</body>
</html>