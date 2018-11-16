<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, java.util.ArrayList, it.modello.Attivita, java.util.Map, java.util.HashMap" %>

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
			
				<form class="containerFormCreaGruppo" action="aggiungiGruppo" method="POST">
					
					<select name="attivita" required>
						<option value="" disabled selected hidden>Attività</option>
						<%
							List<Attivita> attivita = (List<Attivita>) request.getAttribute("attivita");
							for(Attivita att : attivita) {
						%>	
					 		<option value="<% out.print(att.getId()); %>"><% out.print(att.getNome()+" - "+ String.valueOf(att.getNumeroPartecipanti())); %></option>
						<% } %>
					</select>
					
					<div class="col2">
						<input type="datetime-local" name="data" required>
					</div>
					<div class="col3">
						<input type="textarea" name="descrizione" placeholder="Descrizione" required>
					</div>
					<div class="col4">
						<button class=""> CREA </button>
					</div>
				</form>
				
				

				<div class="containerTabella2">
				
					<div class="tabellaProva header">
						<div class="col1 ">
							Attività
						</div>
						<div class="col2 ">
							Data
						</div>
						<div class="col3 ">
							Descrizione
						</div>
						<div class="col4 ">
						</div>
						<div class="col5 ">
						</div>
					</div>
					
					<div class="body">
					
						<%
							List<String[]> gruppi = (List<String[]>) request.getAttribute("gruppi");
							for(String[] gruppo : gruppi) {
						%>	
							<div class="tabellaProva riga <% if (gruppo[2].equals("1")) out.println("eventoPassato"); %>">
								<div class="col1"> 
									<div class="scritteTabella">
										<% out.println(gruppo[1]); %>
									</div>
								</div>
								<div class="col2">
									<div class="scritteTabella">	
										<% out.println(gruppo[2]); %>
									</div>
								</div>
								<div class="col3">
									<div class="scritteTabella">
										<% out.println(gruppo[3]); %>
									</div>
								</div>
								<div class="col4">
									<i class="fa fa-edit" style="color: #002f7d;" onclick="location.href='./caricaUpdateGruppo?idGruppo=<% out.print(gruppo[0]); %>'"></i>
								</div>
								<div class="col5">
									<i class="fa fa-trash" style="color: red;" onclick="location.href='./deleteGruppo?idGruppo=<% out.print(gruppo[0]); %>'"></i>
								</div>
							</div>
						<%		
							}
						%>
					</div>
				</div>
					
					<div id="ERRORE" class="overlay">
						<div class="errore">
							<h2>ERRORE!</h2>
							<a class="close" href="#">&times;</a>
							<div class="content">
								
								<%
									if(session.getAttribute("ERRORE") != null){
										Map<String,String> errore = (HashMap<String,String>) session.getAttribute("ERRORE");
										out.println("<br>");
										for(Map.Entry<String, String> entry : errore.entrySet()){
											out.println(entry.getValue() + "<br>");
										}
										session.removeAttribute("ERRORE");
									}
								%>
							</div>
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
	
