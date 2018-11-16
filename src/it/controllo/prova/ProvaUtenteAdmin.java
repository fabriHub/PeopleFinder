package it.controllo.prova;

import java.util.ArrayList;
import java.util.List;

import it.modello.Attivita;
import it.modello.Gruppo;
import it.modello.Utente;
import it.persistenza.implementazione.DAOException;
import it.persistenza.implementazione.DAOGruppo;
import it.persistenza.implementazione.DAOUtenteAdmin;
import it.persistenza.interfaccia.IDAOGruppo;

public class ProvaUtenteAdmin {

	public static void main(String[] args) {
		
//		daoUtenteAdmin.contaUtenti();
//		daoUtenteAdmin.contaGruppi();
//		daoUtenteAdmin.contaGruppiCompletati();
//		daoUtenteAdmin.contaGruppiNonCompletati();
//		daoUtenteAdmin.gradimentoAttivita();
//		abilitaUtente(22L);
//		disabilitaUtente(22L);
//		daoUtenteAdmin.contaGruppiAttivita(2L);
		statistiche1();

//		isAbilitatoUtente();
//		isAmministratore1();
//		rendiAmministratore1(22L);
//		escludiAmministratore1(22L);
//		isAbilitataAttivita();
//		disabilitaAttivita1(21L);
//		abilitaAttivita1(21L);
//		contaUtentiDis();
	
	}
	
	
	public static void isAbilitataAttivita () {
		DAOUtenteAdmin daoUtenteAdmin = new DAOUtenteAdmin();
		Attivita attivita = new Attivita();
		attivita.setId(attivita.getId());
		try {
			daoUtenteAdmin.isAbilitata(21L);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void contaUtentiDis () {
		DAOUtenteAdmin daoUtenteAdmin = new DAOUtenteAdmin();
		try {
			daoUtenteAdmin.percentualeUtentiDisabilitati();
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public static void disabilitaAttivita1 (Long id) {
		DAOUtenteAdmin daoUtenteAdmin = new DAOUtenteAdmin();
		Attivita attivita = new Attivita();
		attivita.setId(id);
		try {
			daoUtenteAdmin.disabilitaAttivita(id);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void abilitaAttivita1 (Long id) {
		DAOUtenteAdmin daoUtenteAdmin = new DAOUtenteAdmin();
		Attivita attivita = new Attivita();
		attivita.setId(id);
		try {
			daoUtenteAdmin.abilitaAttivita(id);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void isAbilitatoUtente () {
		DAOUtenteAdmin daoUtenteAdmin = new DAOUtenteAdmin();
		Utente utente = new Utente();
		utente.setId(utente.getId());
		try {
			daoUtenteAdmin.isAbilitato(22L);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void isAmministratore1 () {
		DAOUtenteAdmin daoUtenteAdmin = new DAOUtenteAdmin();
		Utente utente = new Utente();
		utente.setId(utente.getId());
		try {
			daoUtenteAdmin.isAmministratore(22L);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
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
	
	public static void rendiAmministratore1 (Long id) {
		DAOUtenteAdmin daoUtenteAdmin = new DAOUtenteAdmin();
		Utente utente = new Utente();
		utente.setId(id);
		try {
			daoUtenteAdmin.rendiAmministratore(id);
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
	
	public static void escludiAmministratore1 (Long id) {
		DAOUtenteAdmin daoUtenteAdmin = new DAOUtenteAdmin();
		Utente utente = new Utente();
		utente.setId(id);
		try {
			daoUtenteAdmin.escludiAmministratore(id);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void statistiche1() {
		DAOUtenteAdmin daoUtenteAdmin = new DAOUtenteAdmin();


		try {
			List<String[]> popolarita = daoUtenteAdmin.popolaritaAttivitaCompleto();
			for (String[] pop : popolarita) {
				for (String p : pop)
				System.out.println(p);
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}

	}

}
	


	


