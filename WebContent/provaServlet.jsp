<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="it.persistenza.implementazione.DAOIscrizioneGruppo"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p>prova servlet</p>

<p>Output</p>


<form method="GET" action="deleteGruppo">
	
	
	
	
	<input type="text" name="id" placeholder="Inserisci id gruppo"/>
	
	
	<input type="submit" value="cancella"/>
</form>
	





<%
	
	//out.println("utenti registrati: "+request.getAttribute("utentiRegistrati")+"<br>");
	//out.println("utenti abilitati: "+request.getAttribute("percentualeUtentiAbilitati")+"<br>");
	//out.println("utenti disabilitati: "+request.getAttribute("percentualeUtentiDisabilitati")+"<br>");
	//out.println("gruppi creati: "+request.getAttribute("gruppiCreati")+"<br>");
	//out.println("gruppi completati: "+request.getAttribute("percentualeGruppiCompletati")+"<br>");
	//out.println("gruppi non completati: "+request.getAttribute("percentualeGruppiNonCompletati")+"<br>");
	//out.println("popolarit� gruppi completati: "+request.getAttribute("popolaritaAttivitaGruppiCompletati")+"<br>");
	//out.println("popolarit� gruppi non completati: "+request.getAttribute("popolaritaAttivitaGruppiNonCompletati")+"<br>");
	//out.println("partecipazione utenti ai gruppi: "+request.getAttribute("partecipazioneUtentiAiGruppi")+"<br>");
	
	//out.println("<br>");
%>

<a href="statistiche">link servlet</a>

</body>
</html>