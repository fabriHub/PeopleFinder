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
		
			
					
			<div class="container2">
			
					
			
				<div class="titoloRegistrazione">
					Registrazione
				</div>


			<div class="containerRegistr1">

				<form class="containerFormRegistr1" action="registrati" method="POST">
					<div class="containerInput"
						style="grid-column-start: 1; grid-column-end: -1; grid-row-start: 1; grid-row-end: 2;">
						<input type="text" name="mail" placeholder="Email" required>
					</div>
					<div class="containerSymbol"
						style="grid-column-start: 1; grid-column-end: 2; grid-row-start: 1; grid-row-end: 2;">
						<i class="fa fa-envelope"></i>
					</div>

					<div class="containerInput"
						style="grid-column-start: 1; grid-column-end: -1; grid-row-start: 2; grid-row-end: 3;">
						<input type="text" name="nickname" placeholder="Nickname" required>
					</div>
					<div class="containerSymbol"
						style="grid-column-start: 1; grid-column-end: 2; grid-row-start: 2; grid-row-end: 3;">
						<i class="fa fa-user"></i>
					</div>

					<div class="containerInput"
						style="grid-column-start: 1; grid-column-end: -1; grid-row-start: 3; grid-row-end: 4;">
						<input type="text" name="telefono" placeholder="Telefono" required>
					</div>
					<div class="containerSymbol"
						style="grid-column-start: 1; grid-column-end: 2; grid-row-start: 3; grid-row-end: 4;">
						<i class="fa fa-phone"></i>
					</div>
			</div>

			<div class="containerRegistr2">
				<div class="containerFormRegistr2">
					<div class="containerInput" style="grid-column-start: 1; grid-column-end: -1; grid-row-start: 1; grid-row-end: 2;">
						<input type="password" name="password1" placeholder="Password" required>
					</div>
					<div class="containerSymbol" style="grid-column-start: 1; grid-column-end: 2; grid-row-start: 1; grid-row-end: 2;">
						<i class="fa fa-lock"></i>
					</div>

					<div class="containerInput"	style="grid-column-start: 1; grid-column-end: -1; grid-row-start: 2; grid-row-end: 3;">
						<input type="password" name="password2"	placeholder="Conferma password" required>
					</div>
					<div class="containerSymbol" style="grid-column-start: 1; grid-column-end: 2; grid-row-start: 2; grid-row-end: 3;">
						<i class="fa fa-lock"></i>
					</div>

					<div class="containerInput" style="grid-column-start: 1; grid-column-end: -1; grid-row-start: 3; grid-row-end: 4;">
						<button class="">REGISTRATI</button>
						
						<div id="ERRORE" class="overlay">
								<div class="errore">
									<h2>ERRORE!</h2>
									<a class="close" href="#">&times;</a>
									<div class="content">
										Le password non coincidono
									</div>
								</div>
							</div>
						
					</div>

				</div>
				</form>

			</div>

			<div class="accedi">
						<a href="index.jsp" style="text-decoration: none;">Hai già un account? Accedi <i class="fa fa-long-arrow-right m-l-5" style="font-size: 15px;"></i></a>
					</div>	
			
			</div>
		</div>
				

		
	</body>
</html>
	
