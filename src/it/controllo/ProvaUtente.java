package it.controllo;

import java.util.List;

import it.modello.Utente;
import it.persistenza.implementazione.DAOException;
import it.persistenza.implementazione.DAOUtente;
import it.persistenza.interfaccia.IDAOUtente;

public class ProvaUtente {

	public static void main(String[] args) {

//		addUtente();
//		findAll();
//		update();
//		findById();
//		delete();
//		findAll();
//		verificaPasswordUtente();
	}
	
	private static void addUtente() {
		IDAOUtente mioUtente = new DAOUtente();
		
		Utente utente = new Utente();
		utente.setMail("provaMail2");
		utente.setNickname("utente12");
		utente.setTelefono("+39123456");
		utente.hashPassword("password1");
		
		
		try {
			mioUtente.add(utente);
			
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	
	
	private static void findAll () {
		IDAOUtente mioUtente = new DAOUtente();
		
		try {
			List<Utente> listaUtenti = mioUtente.findAll();
			System.out.println(listaUtenti);
			
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	
	private static void findById () {
		IDAOUtente mioUtente = new DAOUtente();
		
		try {
			Utente utente = mioUtente.findById(1L);
			System.out.println(utente);
			
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	
	private static void update () {
		IDAOUtente mioUtente = new DAOUtente();
		
		Utente utente = new Utente();
		utente.setId(1L);
		utente.setMail("provaMail2");
		utente.setNickname("utente2");
		utente.setTelefono("+39123455");
		utente.setAbilitato(1);
		utente.setAmministratore(0);
		
		try {
			
			mioUtente.update(utente);
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	
	private static void delete () {
		IDAOUtente mioUtente = new DAOUtente();
		
		try {
			
			mioUtente.delete(1L);
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	
	private static void verificaPasswordUtente () {
		IDAOUtente mioUtente = new DAOUtente();
		Utente utente = new Utente();
		utente.setId(6L);
		utente.hashPassword("");
		
		try {
			
			if(mioUtente.verificaPassword(utente)) {
				System.out.println("sono uguali");
			}else {
				System.out.println("sono diversi");
			}
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	
}

