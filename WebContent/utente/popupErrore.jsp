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