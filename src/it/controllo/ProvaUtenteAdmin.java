package it.controllo;

import it.modello.Utente;
import it.persistenza.implementazione.DAOException;
import it.persistenza.implementazione.DAOUtenteAdmin;

public class ProvaUtenteAdmin {

	public static void main(String[] args) {
		DAOUtenteAdmin daoUtenteAdmin = new DAOUtenteAdmin();

		
//		daoUtenteAdmin.contaUtenti();
//		daoUtenteAdmin.contaGruppi();
//		daoUtenteAdmin.contaGruppiCompletati();
//		daoUtenteAdmin.contaGruppiNonCompletati();
//		daoUtenteAdmin.gradimentoAttivita();
//		abilitaUtente(22L);
//		disabilitaUtente(22L);
//		daoUtenteAdmin.contaGruppiAttivita(2L);
		
	}
	
	public static void abilitaUtente (Long id) {
		DAOUtenteAdmin daoUtenteAdmin = new DAOUtenteAdmin();
		Utente utente = new Utente();
		utente.setId(id);
		try {
			daoUtenteAdmin.abilita(id);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void disabilitaUtente (Long id) {
		DAOUtenteAdmin daoUtenteAdmin = new DAOUtenteAdmin();
		Utente utente = new Utente();
		utente.setId(id);
		try {
			daoUtenteAdmin.disabilita(id);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	

}
