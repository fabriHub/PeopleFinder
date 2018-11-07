<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<link href="https://fonts.googleapis.com/css?family=Courgette" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="main.css">
	
	<title>People Finder</title>
	
	</head>
	
	<body>
		<div class="limiter">
		
			<div class="utente">
			<i class="fa fa-user-circle" style="color: #FDF5E6"> <span style="color: #FDF5E6; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); font-family: Courgette;"> nomeUtente </span> </i>
			
			</div>

<!-- ############## MENU ############## MENU ############## MENU ############## MENU ############## MENU ############## MENU ############## -->

				<div class="containerMenu" onmouseover="mOver()" onmouseout="mOut()">
					<div class="elementiMenu sinistra">
						<div class="linkMenu">
							prova
						</div>
						<div class="linkMenu">
							prova
						</div>
						<div class="linkMenu">
							prova
						</div>
					</div>
					
					<div class="menu" id="bottoneMenu">
						<i class="fa fa-navicon" style="color: white;"></i>
					</div>
					
					<div class="elementiMenu destra">
						<div class="linkMenu">
							prova
						</div>
						<div class="linkMenu">
							prova
						</div>
						<div class="linkMenu">
							prova
						</div>
						<div class="linkMenu">
							prova
						</div>
					</div>
				</div>
				
				<script>
					function mOver() {
					    document.getElementById("contenitore").classList.add("animazioneContenitore");
					    document.getElementById("bottoneMenu").classList.add("animazioneMenu");
					    
					    var elementi = document.getElementsByClassName("elementiMenu");
					    var i;
					    for (i = 0; i < elementi.length; i++) {
						elementi[i].classList.add("animazioneElementi");
					    }
					}

					function mOut() {
					    document.getElementById("contenitore").classList.remove("animazioneContenitore");
					    document.getElementById("bottoneMenu").classList.remove("animazioneMenu");
					    var elementi = document.getElementsByClassName("elementiMenu");
					    var i;
					    for (i = 0; i < elementi.length; i++) {
						elementi[i].classList.remove("animazioneElementi");
					    }
					}
				</script>

<!-- ############## MENU ############## MENU ############## MENU ############## MENU ############## MENU ############## MENU ############## -->
		
			<div class="container" id="contenitore">
<!--				<div class="containerMenu">
					<div class="menu">
					<i class="fa fa-navicon" style="color: white"></i>
					</div>
				</div>-->

				
			</div>
			
			
			<div class="logout">
				<button class="" onclick="location.href='index.jsp'">
					LOGOUT
				</button>
			</div>	
		
		</div>
		
		
		
	</body>
</html>
	
