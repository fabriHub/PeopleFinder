<%@page import="it.persistenza.implementazione.DAOIscrizioneGruppo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p>prova servlet</p>

<p>Output</p>


<form method="POST" action="statistiche">
	
	
	
	
	<input type="submit" value="mostra percentuale"/>
</form>

<% out.println(request.getAttribute("percentualeUtentiAbilitati")+"%"); %>

<% out.println(request.getAttribute("percentualeGruppiCompletati")+"%"); %>

<% out.println(request.getAttribute("popolaritaAttivitaCompleto")); %>

<% out.println(request.getAttribute("popolaritaAttivitaNonCompleto")); %>

<% out.println(request.getAttribute("percentualePartecipazioneUtentiAiGruppi")); %>

<a href="findAllUtenti">link servlet</a>

</body>
</html>