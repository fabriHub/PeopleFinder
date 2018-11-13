<%@ page import="it.persistenza.implementazione.DAOUtente" %>

<div class="utente">
	<i class="fa fa-user-circle" style="color: #FDF5E6">
		<span style="color: #FDF5E6; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); font-family: Courgette;">
			<%
			DAOUtente utente = new DAOUtente();
			
			out.println(utente.getNicknameById((Long) session.getAttribute("idUtente")));
			%>
		</span>
	</i>

</div>

<div class="containerMenu" onmouseover="mOver()" onmouseout="mOut()">
	<div class="elementiMenu sinistra">
		<a class="linkMenu" href="./gestioneGruppi">
			Gestione gruppi
		</a>
		<div class="linkMenu">
			Unisciti a un gruppo
		</div>
		
	</div>
	
	<div class="menu" id="bottoneMenu">
		<i class="fa fa-navicon" style="color: white;"></i>
	</div>
	
	<div class="elementiMenu destra">
		<div class="linkMenu">
			I tuoi gruppi
		</div>
		<a class="linkMenu" href="./accountUtente">
				Account
		</a>
		<% if((Integer)session.getAttribute("isAmministratore").equals(1)) {%>
			<a class="linkMenu" href="./accountUtente">
					Entra come amministratore
			</a>
		<% } %>
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