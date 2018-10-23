package it.controllo;

import java.util.Map;
import java.util.Map.Entry;

import it.modello.Attivita;
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
//		statistiche1();
		statistiche2();
		
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
	
	public static void statistiche1() {
		DAOUtenteAdmin daoUtenteAdmin = new DAOUtenteAdmin();
		Map<Integer,Attivita> mappa = daoUtenteAdmin.popolaritaAttivitaNonCompleto();
		
		for(Entry<Integer, Attivita> e : mappa.entrySet()) {
			System.out.println(e.getKey() + " - " + e.getValue());
		}
		
	}
	
	public static void statistiche2() {
		DAOUtenteAdmin daoUtenteAdmin = new DAOUtenteAdmin();
		Map<Integer,Long> mappa = daoUtenteAdmin.partecipazioneUtentiAiGruppi();
		
		for(Entry<Integer, Long> e : mappa.entrySet()) {
			System.out.println(e.getKey() + " - " + e.getValue());
		}
		
	}
	

}
