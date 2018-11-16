<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, java.util.ArrayList, java.util.Map, java.util.HashMap" %>


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
			
			<div class="containerHomeAdmin" id="contenitore">

				<div class="tab1HA">
				
					<div class="rig2 col2">
						Utenti registrati
					</div>
					<div class="rig2 col3">
						<% out.print((int) request.getAttribute("utentiRegistrati")); %>
					</div>
					
					<div class="rig3 col2">
						Utenti abilitati
					</div>
					<div class="rig3 col3">
						<% out.print((Double) request.getAttribute("percentualeUtentiAbilitati")); %>%
					</div>
				
					<div class="rig4 col2">
						Gruppi<br>creati
					</div>
					<div class="rig4 col3">
						<% out.print((int) request.getAttribute("gruppiCreati")); %>
					</div>
				
					<div class="rig5 col2">
						Gruppi completati
					</div>
					<div class="rig5 col3">
						<% out.print((Double) request.getAttribute("percentualeGruppiCompletati")); %>%
					</div>
					
				</div>
				
				<div class="containerTabella rig2 col2" style="justify-self: center; width: 80%;">
					<div class="tab3HA header">
						<div class="col1">
							Gruppo
						</div>
						<div class="col2">
							Partecipazione [%]
						</div>
					
					</div>
					
					<div class="body">
						<%
							List<String[]> partecipazione = (List<String[]>) request.getAttribute("partecipazioneUtentiAiGruppi");
							for (String[] part : partecipazione) {
						%>	
					
						
						<div class="tab3HA riga">
							<div class="col1">
								<% out.println(part[1]); %>
							</div>
							<div class="col2">
								<% out.println(part[2]); %>
							</div>
						</div>
					<%		
							}
						%>
					</div>
				</div>
				
					<div class="containerTabella rig1 col2" style="justify-self: center; width: 90%; height: 80%">
					<div class="tab2HA header">
						<div class="col1">
							Attività
						</div>
						<div class="col2">
							Gruppi completi [%]
						</div>
						<div class="col3">
							Gruppi incompleti [%]
						</div>
					
					</div>
					
					<div class="body">
						<%
							List<String[]> gruppiCompl = (List<String[]>) request.getAttribute("popolaritaAttivitaGruppiCompletati");
							for (String[] gruppoC : gruppiCompl) {
						%>	
						
							<div class="tab2HA riga">
								<div class="col1">
									<% out.println(gruppoC[1]); %>
								</div>
								<div class="col2">
									<% out.println(gruppoC[2]); %>
								</div>
								<div class="col3">
									<% out.println(gruppoC[3]); %>
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
	
