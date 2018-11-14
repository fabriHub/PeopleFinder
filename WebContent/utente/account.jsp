<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, java.util.ArrayList, java.util.HashMap, java.util.Map, java.util.Map.Entry" %>

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
		
			<%@ include file="menuUtente.jsp" %>
					
			<div class="container2" id="contenitore">
			
					
			
				<div class="titoloRegistrazione" style="align-self: center;">
					Modifica account
				</div>

			<!-- <div > -->
			
				<% 
					String[] datiUtente = (String[]) request.getAttribute("datiUtente");
				%>

				<div class="centro">
					<form class="sinistra_1 containerFormAccount" action="updateUtente" method="POST">
						<div class="containerInput"
							style="grid-column-start: 1; grid-column-end: -1; grid-row-start: 1; grid-row-end: 2;">
							<input type="text" name="mail" placeholder="Email" value="<% out.println(datiUtente[1]); %>" required>
						</div>
						<div class="containerSymbol"
							style="grid-column-start: 1; grid-column-end: 2; grid-row-start: 1; grid-row-end: 2;">
							<i class="fa fa-envelope"></i>
						</div>
	
						<div class="containerInput"
							style="grid-column-start: 1; grid-column-end: -1; grid-row-start: 2; grid-row-end: 3;">
							<input type="text" name="nickname" placeholder="Nickname" value="<% out.println(datiUtente[2]); %>" required>
						</div>
						<div class="containerSymbol"
							style="grid-column-start: 1; grid-column-end: 2; grid-row-start: 2; grid-row-end: 3;">
							<i class="fa fa-user"></i>
						</div>
	
						<div class="containerInput"
							style="grid-column-start: 1; grid-column-end: -1; grid-row-start: 3; grid-row-end: 4;">
							<input type="text" name="telefono" placeholder="Telefono" value="<% out.println(datiUtente[3]); %>" required>
						</div>
						<div class="containerSymbol"
							style="grid-column-start: 1; grid-column-end: 2; grid-row-start: 3; grid-row-end: 4;">
							<i class="fa fa-phone"></i>
						</div>
						
						<div class="containerInput" style="grid-column-start: 1; grid-column-end: -1; grid-row-start: 4; grid-row-end: 5;">
							<button class="">MODIFICA DATI</button>
						</div>
					</form>
		
					<form class="destra_1 containerFormAccount" action="updatePassword" method="POST">
						<div class="containerInput" style="grid-column-start: 1; grid-column-end: -1; grid-row-start: 1; grid-row-end: 2;">
							<input type="password" name="password" placeholder="Vecchia password" required>
						</div>
						<div class="containerSymbol" style="grid-column-start: 1; grid-column-end: 2; grid-row-start: 1; grid-row-end: 2;">
							<i class="fa fa-lock"></i>
						</div>
						
						<div class="containerInput" style="grid-column-start: 1; grid-column-end: -1; grid-row-start: 2; grid-row-end: 3;">
							<input type="password" name="password1" placeholder="Nuova password" required>
						</div>
						<div class="containerSymbol" style="grid-column-start: 1; grid-column-end: 2; grid-row-start: 2; grid-row-end: 3;">
							<i class="fa fa-lock"></i>
						</div>
	
						<div class="containerInput"	style="grid-column-start: 1; grid-column-end: -1; grid-row-start: 3; grid-row-end: 4;">
							<input type="password" name="password2"	placeholder="Conferma password" required>
						</div>
						<div class="containerSymbol" style="grid-column-start: 1; grid-column-end: 2; grid-row-start: 3; grid-row-end: 4;">
							<i class="fa fa-lock"></i>
						</div>
	
						<div class="containerInput" style="grid-column-start: 1; grid-column-end: -1; grid-row-start: 4; grid-row-end: 5;">
							<button class="">AGGIORNA PASSWORD</button>
							
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
					</form>
				</div>

			<!-- </div> -->

				<div class="cancellati containerInput" style="">
					<button class="">CANCELLATI</button>	
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
	
