<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, java.util.ArrayList, it.modello.Attivita, it.modello.Gruppo, java.util.Map, java.util.HashMap, java.text.SimpleDateFormat, java.util.Date" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="it">
	<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<link href="https://fonts.googleapis.com/css?family=Courgette" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="./main.css">
	
	<title>People Finder</title>
	
	</head>
	
	<body>
		<div class="limiter">
		
			<%@ include file="menuUtente.jsp" %>
		
			<div class="container3" id="contenitore">
			
				<form class="containerFormCreaGruppo" action="updateGruppo" method="POST">
					
					<select name="attivita" required>
						<option value="" disabled hidden>Attività</option>
						<%
							Gruppo gruppo = (Gruppo) request.getAttribute("gruppo");
							List<Attivita> attivita = (List<Attivita>) request.getAttribute("attivita");
							for(Attivita att : attivita) {
						%>	
					 		<option value="<% out.print(att.getId()); %>" <% if ( att.getId() == gruppo.getIdAttivita() ){ out.print("selected"); } %>><% out.print(att.getNome()+" - "+ String.valueOf(att.getNumeroPartecipanti())); %></option>
						<% } %>
					</select>
					
					<div class="col2">
						<input type="datetime-local" name="data" value="<% out.print(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").format(gruppo.getData())); %>" required>
					</div>
					<div class="col3">
						<input type="textarea" name="descrizione" placeholder="Descrizione" value="<% out.print(gruppo.getDescrizione()); %>" required>
					</div>
					<div class="col4">
						<button class=""> MODIFICA </button>
					</div>
				</form>
				
					
			</div>
			
			
			<div class="logout">
				<button class="" onclick="location.href='../logout'">
					LOGOUT
				</button>
			</div>	
		
		</div>
		
		
		
	</body>
</html>
	
