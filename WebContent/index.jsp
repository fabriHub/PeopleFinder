<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.HashMap, java.util.Map, java.util.Map.Entry" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="main.css">
	
	<title>People Finder</title>
	
	</head>
	
	<body>
		<div class="limiter">
			<div class="container">
			
				<div class="containerImmagine">
					<img src="images/people3.jpg" class="immagine">
					<a class="bottoneImmagine">
						<div class="testoBottoneImmagine">
							<b>
							Il nostro sito è rivolto a chiunque desideri trovare altre persone per svolgere un'attività in comune. <br>
							Il numero di partecipanti ad un gruppo è prestabilito a seconda dell'attività (per esempio per il calcetto è 10).<br>
							Tutti gli iscritti ad un gruppo possono visualizzare i contatti degli altri componenti per favorire l'organizzazione dell'evento.</b>

						</div>
					</a>
				</div>
				
				<div class="containerLogin">
					
					<div class="containerTitolo">
						People Finder	
					</div>
					
					<form class="containerFormLogin" action="login" method="POST">
						<div class="containerInput" style="grid-column-start: 1; grid-column-end: -1; grid-row-start: 1; grid-row-end: 2;">
							<input type="text" name="mail" placeholder="Email" >
						</div>
						<div class="containerSymbol" style="grid-column-start: 1; grid-column-end: 2; grid-row-start: 1; grid-row-end: 2;">
							<i class="fa fa-envelope"></i>
						</div>
						
						<div class="containerInput" style="grid-column-start: 1; grid-column-end: -1; grid-row-start: 2; grid-row-end: 3;">
							<input type="password" name="password" placeholder="Password">
						</div>
						
						<div class="containerSymbol" style="grid-column-start: 1; grid-column-end: 2; grid-row-start: 2; grid-row-end: 3;">
							<i class="fa fa-lock"></i>
						</div>
						
						<div class="containerInput" style="grid-column-start: 1; grid-column-end: -1; grid-row-start: 3; grid-row-end: 4;">
							<button class="">
							LOGIN
							</button>
							
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
				
				<div class="containerRegistrati">
					<a href="registrati.jsp" style="text-decoration: none;">Non sei ancora registrato? Registrati <i class="fa fa-long-arrow-right m-l-5"></i></a>
				</div>
				
			</div>
		
		</div>
		

		
	</body>
</html>
	
