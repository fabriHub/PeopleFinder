<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.HashMap, java.util.Map, java.util.Map.Entry" %>

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
		
			<div class="container" id="contenitore">

				<div class="containerTabella">
					
					<div class="tabellaRighe3Col header">
						<div class="col1 ">
							Attività
						</div>
						<div class="col2 ">
							Data
						</div>
						<div class="col3 ">
							Completo
						</div>
					</div>
					
					<div class="body">
					
						<%
							
						%>
						<div class="tabellaRighe3Col riga">
							<div class="col1 ">
								col1 r2
							</div>
							<div class="col2 ">
								col2 r2
							</div>
							<div class="col3 ">
								col3 r2
							</div>
						</div>
						
					</div>
					
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
	
