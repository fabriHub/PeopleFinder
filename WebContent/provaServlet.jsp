<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="it.modello.IscrizioneGruppo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p>prova servlet</p>

<p>Output</p>

	 <% //List<IscrizioneGruppo> gruppi = (List<IscrizioneGruppo>)request.getAttribute("listaUtentiIscrizioneGruppi");
		//for (Utente utente: utenti){
		//	out.println(utente);
		//}
		//out.println("provaUtentiByIdGruppo");
		//if(gruppi != null){
		//	out.println(gruppi.toString());
		//}
	%> 

<form method="GET" action="abilitaUtente">
	
	<input type="text" name="id_utente" placeholder="inserisci id utente"/>
	
	<input type="submit" value="submit"/>
</form>

<a href="findAllUtenti">link servlet</a>

</body>
</html>