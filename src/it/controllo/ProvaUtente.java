package it.controllo;

import it.modello.Utente;
import it.persistenza.implementazione.DAOException;
import it.persistenza.implementazione.DAOUtente;
import it.persistenza.interfaccia.IDAOUtente;

public class ProvaUtente {

	public static void main(String[] args) {

		addUtente();
		
		
	}
	
	private static void addUtente() {
		IDAOUtente mioUtente = new DAOUtente();
		
		Utente utente = new Utente();
		utente.setMail("provaMail");
		utente.setNickname("utente1");
		utente.setTelefono("+3912345");
		utente.setAbilitato(true);
		utente.setAmministratore(false);
		utente.setPassword("password");
		
		
		try {
			mioUtente.add(utente);
			
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

}
