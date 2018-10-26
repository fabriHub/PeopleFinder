<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="it.modello.Attivita" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p>prova servlet</p>

<p>Output</p>

	<% List<Attivita> allAttivita = (List<Attivita>)request.getAttribute("listaAttivita");
		//for (Utente utente: utenti){
		//	out.println(utente);
		//}
		out.println("provaAggiuntaAttivita");
		if(allAttivita != null){
			out.println(allAttivita.toString());
		}
		out.println(request.getParameter("xxx"));
	%>

<form method="POST" action="aggiungiAttivita">
	
	<input type="text" name="nome" placeholder="inserisci nome"/>
	<input type="text" name="numero_partecipanti" placeholder="inserisci numero_partecipanti"/>
	
	<input type="submit" value="submit"/>
</form>

<a href="findAllAttivita">link servlet</a>

</body>
</html>