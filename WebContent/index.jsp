<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<link href='https://fonts.googleapis.com/css?family=Sofia' rel='stylesheet'>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="main.css">
	
	<title>People Finder</title>
	
	</head>
	
	<body>
		<div class="limiter">
			<div class="container">
			
				<div class="containerImmagine">
					<img src="images/people3.jpg" class="immagine">
					<a class="bottoneImmagine" href="#" style="text-decoration: none;">
						<div class="testoBottoneImmagine">
							Chi siamo
						</div>
					</a>
				</div>
				
				<div class="containerLogin">
					
					<div class="containerTitolo">
						People Finder	
					</div>
					
					<form class="containerFormLogin" action="login" method="POST">
						<div class="containerInput" style="grid-column-start: 1; grid-column-end: -1; grid-row-start: 1; grid-row-end: 2;">
							<input type="text" name="mail" placeholder="Email">
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
						</div>
					</form>
					
					<div class="containerRegistrati">
						<a href="#" style="text-decoration: none;">Non sei ancora registrato? Registrati <i class="fa fa-long-arrow-right m-l-5" style="font-size: 15px;"></i></a>
					</div>					
				</div>
			</div>
		
		</div>
		

		
	</body>
</html>
	
