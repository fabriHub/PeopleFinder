package it.controllo;

import it.modello.Utente;
import it.persistenza.implementazione.DAOUtente;
import it.persistenza.interfaccia.IDAOException;
import it.persistenza.interfaccia.IDAOUtente;

public class ProvaUtente {

	public static void main(String[] args) {

		IDAOUtente mioUtente = new DAOUtente();
		
		Utente utente = new Utente();
		utente.setMail("");
		
		try {
			mioUtente.add(utente);
		} catch (IDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
