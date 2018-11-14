<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, java.util.ArrayList" %>
<%@ page import="it.modello.Utente" %>

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
					
					<div class="tabellaRighe5Col header">
						<div class="col1 ">
							Nickname
						</div>
						<div class="col2 ">
							Mail
						</div>
						<div class="col3 ">
							Telefono
						</div>
						<div class="col4 ">
							Abilitato
						</div>
						<div class="col5 ">
							Amministratore	
						</div>
					</div>
					
					<div class="body">
						<%
							List<Utente> utenti = (List<Utente>) request.getAttribute("listaUtenti");
							utenti.toString();
							for(Utente utente1 : utenti) {
						%>	
						<div class="tabellaRighe5Col riga">
							<div class="col1">
								<%= utente1.getNickname() %>
							</div>
							<div class="col2">
								<%= utente1.getMail()%>
							</div>
							<div class="col3">
								<%= utente1.getTelefono() %>
							</div>
							<div class="col4">
								<% if (utente1.getAbilitato()==1){%>
								<i class="fa fa-circle" style="color: green" ></i>
								<%} else { %>
								<i class="fa fa-circle" style="color: red;"></i>
								<% } %>
							</div>
							<div class="col5">
								<% if (utente1.getAmministratore()==1){%>
								<i class="fa fa-circle" style="color: green" ></i>
								<%} else { %>
								<i class="fa fa-circle" style="color: red;"></i>
								<% } %>
							</div>
						</div>
						<%		
							}
						%>
					</div>
				</div>
			
			<div class="logout">
				<button class="" onclick="location.href='../logout'">
					LOGOUT
				</button>
			</div>	
		
		</div>
		
		
		
	</body>
</html>
	
