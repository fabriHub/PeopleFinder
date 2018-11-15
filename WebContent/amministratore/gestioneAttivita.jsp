<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, java.util.ArrayList" %>
<%@ page import="it.modello.Attivita" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<link href="https://fonts.googleapis.com/css?family=Courgette" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="./main.css">
	
	<title>People Finder</title>
	
	</head>
	
	<body>
		<div class="limiter">
		
			<%@ include file="menuAmministratore.jsp" %>
		
			<div class="container" id="contenitore">

				<div class="containerTabella">
					
					<div class="tabellaRighe3Col header">
						<div class="col1 ">
							Nome
						</div>
						<div class="col2 ">
							Numero Partecipanti
						</div>
						<div class="col3 ">
							Abilitata
						</div>
					</div>
					
					<div class="body">
						<%
							List<Attivita> allAttivita = (List<Attivita>) request.getAttribute("listaAttivita");
							for (Attivita attivita : allAttivita) {
						%>	
						<div class="tabellaRighe3Col riga">
							<div class="col1 ">
								<%= attivita.getNome() %>
							</div>
							<div class="col2 ">
								<%= attivita.getNumeroPartecipanti() %>
							</div>
							<div class="col3 ">
								<i class="fa fa-circle <% if(attivita.getAbilitata().equals(0)) { out.println("pallozzoRosso"); } else { out.println("pallozzoVerde"); } %>" onclick="location.href='./abilitazioneAttivita?idAttivita=<% out.print(attivita.getId()); %>'"></i>
							</div>
						</div>
						<%		
							}
						%>
					</div>
				</div>
				
			</div>
			
			<div class="logout">
				<button class="" onclick="location.href='./logout'">
					LOGOUT
				</button>
			</div>	
		
		</div>
		
		
		
	</body>
</html>
	
