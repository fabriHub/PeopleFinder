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
						<% out.print((Double) request.getAttribute("percentualeUtentiAbilitati")); %>
					</div>
				
					<div class="rig4 col2">
						Gruppi creati
					</div>
					<div class="rig4 col3">
						<% out.print((int) request.getAttribute("gruppiCreati")); %>
					</div>
				
					<div class="rig5 col2">
						Gruppi completati
					</div>
					<div class="rig5 col3">
						<% out.print((Double) request.getAttribute("percentualeGruppiCompletati")); %>
					</div>
					
				</div>
				
				<% 
					//List<String[]> listaGruppi = (List<String[]>) request.getAttribute("listaGruppi");
					//for(String[] stringa : listaGruppi){
					//	String onclick = "onclick=\"window.location='####?idGruppo=" + stringa[0] + "'\"";
				%>	
				
			</div>
			
			
			<div class="logout">
				<button class="" onclick="location.href='./logout'">
					LOGOUT
				</button>
			</div>	
		
		</div>
		
		
		
	</body>
</html>
	
