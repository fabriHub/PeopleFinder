<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, java.util.ArrayList" %>

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
					
					<div class="tabellaRighe5ColG header">
						<div class="col1 ">
							Attivit�
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
							gruppi.toString();
							for(String[] gruppo : gruppi) {
						%>	
							<div class="tabellaRighe5ColG riga <% if (gruppo[2].equals("1")) out.println("eventoPassato"); %>">
								<div class="col1">
									<% out.println(gruppo[1]); %>
								</div>
								<div class="col2">
									<% out.println(gruppo[2]); %>
								</div>
								<div class="col3">
									<% out.println(gruppo[3]); %>
								</div>
								<div class="col4">
									<i class="fa fa-edit" style="color: #002f7d;"></i>
								</div>
								<div class="col5">
									<i class="fa fa-trash" style="color: red;"></i>
								</div>
							</div>
						<%		
							}
						%>
					</div>
				</div>
					<input type = "button" value = "Crea nuovo gruppo" onclick="location.href=''">
			</div>
			
			
			<div class="logout">
				<button class="" onclick="location.href='../logout'">
					LOGOUT
				</button>
			</div>	
		
		</div>
		
		
		
	</body>
</html>
	
